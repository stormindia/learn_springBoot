package com.harshit.learn_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LearnSpringBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =  SpringApplication.run(LearnSpringBootApplication.class, args);
        System.out.println("Hello");

        Alien a = context.getBean(Alien.class);
        a.show();

//        Alien a1 = context.getBean(Alien.class);
//        a1.show();
    }

}
