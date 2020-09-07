package com.rkanban.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rkanban.demo.services.RedmineIOHelper;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println(new RedmineIOHelper().getProjects().size());
    }

}
