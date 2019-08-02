package com.cegeka.springcourse.retry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArcadeController {

    @Autowired
    private DonkeyKongService donkeyKongService;

    @GetMapping("/play/{playername}/{coins}")
    public String play(@PathVariable("playername") String playername, @PathVariable("coins") int coins) {
        DonkeyKongService.coinsRemaining = coins;
        return donkeyKongService.play(playername);
    }
}
