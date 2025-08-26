package com.code.SpringCachingProject.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/*
    This configuration needed if you did not mark Springboot app @EnableCaching
 */

@Configuration
@EnableCaching      // this is needed to enable caching
public class AppConfig {
}
