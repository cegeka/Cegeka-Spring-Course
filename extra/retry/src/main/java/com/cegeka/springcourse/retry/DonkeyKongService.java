package com.cegeka.springcourse.retry;

import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DonkeyKongService {
    public static int coinsRemaining = 0;

    @Retryable(
            value = {GameOverException.class},
            maxAttempts = Integer.MAX_VALUE
    )
    public String play(String player) {
        if (coinsRemaining == 0) {
            throw new OutOfCoinsException();
        } else {
            coinsRemaining--;
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

    @Recover
    public String recover(OutOfCoinsException o, String player) {
        return player + " going home";
    }
}
