package com.cegeka.springcourse.boot;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.ReactiveHealthIndicator;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class VdabHealthIndicator implements ReactiveHealthIndicator {

    @Override
    public Mono<Health> health() {
        HttpStatus statusCode = new RestTemplateBuilder().build().getForEntity("http://www.vdab.be", String.class).getStatusCode();
        return statusCode.is3xxRedirection() ? Mono.just(new Health.Builder().up().build()) : Mono.just(new Health.Builder().down().build());
    }
}
