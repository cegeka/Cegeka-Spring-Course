package com.cegeka.springcourse.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class CacheController {

    @Autowired
    private CacheManager cacheManager;

    @GetMapping("/cache/clear/{cachename}")
    private void clearCache(@PathVariable("cachename") String name) {
        Optional.ofNullable(cacheManager.getCache(name)).ifPresent(Cache::clear);
    }

    @GetMapping("/cache/precache/{cachename}/{id}")
    private void preCache(@PathVariable("cachename") String name, @PathVariable("id") String userid) {
        Optional.ofNullable(cacheManager.getCache(name)).ifPresent(cache -> cache.put(userid, new ArrayList()));
    }
}
