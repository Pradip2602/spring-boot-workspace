package com.code.SpringCachingProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/*
    If you created configuration class and marked it @EnableCaching then
    no need to mark spring app as @EnableCaching
 */

@SpringBootApplication
//@EnableCaching    // Enabling caching
public class SpringCachingProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCachingProjectApplication.class, args);
    }

}
