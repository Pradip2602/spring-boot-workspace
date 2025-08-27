package com.code.SpringCachingProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Objects;

/*
        - This is custom Cache Manager
        - If you use redis then redis data dependency needs to added in maven
 */

@Service
public class CacheService {

    // Getting cache manager bean to get cache
    @Autowired
    private CacheManager cacheManager;

    // This method will print cache
    public void printCacheData(String cacheName) {

        // getting cache from cache manager
        Cache cache = cacheManager.getCache(cacheName);

        if (cache != null) {
            System.out.println("Cache Content : ");
            System.out.println(Objects.requireNonNull(cache.getNativeCache()).toString());
        } else {
            System.out.println("No such cache found : " + cacheName);
        }

    }

}
