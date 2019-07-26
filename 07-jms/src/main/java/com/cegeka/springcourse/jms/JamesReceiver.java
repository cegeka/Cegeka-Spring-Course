package com.cegeka.springcourse.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JamesReceiver {

    @Autowired
    private BruceRepository bruceRepository;

    @JmsListener(destination = "THIRST")
    public void receiveThirstMessage(BruceIsThirstyMessage bruceIsThirstyMessage) {
        Bruce bruce = bruceRepository.getBruce();
        bruce.giveDrink();
        bruceRepository.updateBruce(bruce);
    }

    @JmsListener(destination = "BOOK")
    public void receiveBookMessage(BruceWantsToRead bruceWantsToRead) {
        Bruce bruce = bruceRepository.getBruce();
        bruce.giveBookToRead(bruceWantsToRead.getBook());
        bruceRepository.updateBruce(bruce);
    }

}
