package com.harshit.bootjpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {

    @Id
    private int alienid;
    private String aname;
    private String tech;

    public int getAlienid() {
        return alienid;
    }

    public void setAlienid(int alienid) {
        this.alienid = alienid;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + alienid +
                ", aname='" + aname + '\'' +
                '}';
    }
}
