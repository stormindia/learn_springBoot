package com.harshit.mywebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

//    @RequestMapping("home")
//    public String home(HttpServletRequest request, HttpServletResponse response)
//    {
//        HttpSession session = request.getSession();
//        String name = request.getParameter("name");
//        System.out.println("hi");
//        System.out.println(name);
//        //request.setAttribute("name",name);
//        session.setAttribute("name",name);
//
//        return "home";
//    }

//    @RequestMapping("home")
//    public ModelAndView home(@RequestParam("name") String myName)
//    {
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("name",myName);
//        mv.setViewName("home");
//        return mv;
//    }

    @RequestMapping("home")
    public ModelAndView home(Alien alien)
    {
        ModelAndView mv = new ModelAndView();
        mv.addObject("obj",alien);
        mv.setViewName("home");
        return mv;
    }
}
