package com.harshit.learn_springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //without scope annotation an object gets created even if you don't call getBean
@Scope(value = "prototype") //will create new object every time; also will create only when you call getBean
public class Alien {
    private int aid;
    private String aname;
    private String tech;

    @Autowired
    @Qualifier("lap1") //to search by name [optional]
    private Laptop laptop;

    public Alien(){
        System.out.println("obj created");
    }

    public int getAid() {
        return aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public void show(){
        System.out.println("alien show");
        laptop.compile();
    }
}
