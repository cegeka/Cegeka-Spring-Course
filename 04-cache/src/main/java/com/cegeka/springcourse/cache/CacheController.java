package com.cegeka.springcourse.cache;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {

    @GetMapping("/cache/clear/{cachename}")
    private void clearCache(@PathVariable("cachename") String name) {

    }

    @GetMapping("/cache/precache/{cachename}/{id}")
    private void preCache(@PathVariable("cachename") String name, @PathVariable("id") String userid) {

    }
}
