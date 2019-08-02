package com.cegeka.springcourse.retry;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DonkeyKongService {
    public static int coinsRemaining = 0;

    public String play(String player) {
        coinsRemaining--;
        if (coinsRemaining == 0) {
            throw new OutOfCoinsException();
        }
        int score = 0;
        System.out.println(player + " started playing donkey kong");
        while (score < 1602) {
            score += keepPlaying();
            System.out.println("Current score is " + score);
        }
        return "High score achieved for " + player + " !";
    }

    private int keepPlaying() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (LocalDateTime.now().getSecond() % 10 == 5) {
            throw new GameOverException();
        }
        return 200;
    }
}
