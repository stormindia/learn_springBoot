package com.harshit.bootjpa.controller;

import com.harshit.bootjpa.dao.AlienRepo;
import com.harshit.bootjpa.dao.AlienRepoJPA;
import com.harshit.bootjpa.model.Alien;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class AlienController {
    //Thread.sleep(1000);
    @Autowired
    AlienRepo repo;

    @Autowired
    AlienRepoJPA jpaRepo;

    @RequestMapping("/") //By default RequestMapping is get
    public String home(){
        return "home.jsp";
    }

    @RequestMapping("/addAlien")
    public String addAlien(Alien alien){
        repo.save(alien);
        return "home.jsp";
    }

    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int alienid){
        ModelAndView mv = new ModelAndView("showAlien.jsp");
        Alien alien = repo.findById(alienid).orElse(new Alien());
        mv.addObject(alien);

        System.out.println(repo.findByTech("112"));
        System.out.println(repo.findByAlienidGreaterThanEqual(0));
        System.out.println(repo.findByTechSorted("112"));

        return mv;
    }

    @RequestMapping("/aliens")
    //@RequestMapping(value = "/XMLaliens", produces = {"application/xml"}) //to restrict the response to xml only
    @ResponseBody   //to tell browser that response will be of type returned by function(String in this case)
    public String getAliens(){
        return repo.findAll().toString();
    }

    // In JSON format
    @RequestMapping("/jpaAliens")
    @ResponseBody
    public List<Alien> getJPAAliens(){
        return jpaRepo.findAll();
    }

    @RequestMapping("/alien/{alienid}")
    @ResponseBody
    public String getAlienbyID(@PathVariable("alienid") int alienid){
        return repo.findById(alienid).toString();
    }

    // In JSON format
    @RequestMapping("/jpaAlien/{alienid}")
    @ResponseBody
    public Optional<Alien> getJpaAlienbyID(@PathVariable("alienid") int alienid){
        return jpaRepo.findById(alienid);
    }
}

@RestController
class RestAlienController{
    @Autowired
    //AlienRepo repo;
    AlienRepoJPA repo;

    @PostMapping("/addAlien")
    public Alien addAlien(Alien alien){
    //public Alien addAlien(Alien alien, consumes={"application/json}){
    //public Alien addAlien(@RequestBody Alien alien){ //to use with RAW data
        repo.save(alien);
        //System.out.println("asdfsfsdfsfsdf");
        return alien;
    }

    @DeleteMapping("/deleteAlien/{alienid}")
    public String deleteAlien(@PathVariable int alienid){
        Alien a = repo.getOne(alienid);
        //Alien a = repo.findById(alienid).orElse(new Alien());
        repo.delete(a);
        //return "deleted";
        return a.toString();
    }

}