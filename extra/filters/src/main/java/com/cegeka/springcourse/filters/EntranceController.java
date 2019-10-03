package com.cegeka.springcourse.filters;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class EntranceController {

    @PostMapping(path = "/entrance/{memberId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> enter(@RequestBody BookAndMember bookAndMember) {
        return ResponseEntity.ok().body("Welcome " + bookAndMember.getMemberName() + "!\n "
                + "Have fun reading " + bookAndMember.getBookName());
    }

    @PostMapping(path = "/back-entrance/{memberId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> enterViaBack(@RequestBody BookAndMember bookAndMember) {
        return ResponseEntity.ok().body("Welcome " + bookAndMember.getMemberName() + "!\n "
                + "Have fun reading " + bookAndMember.getBookName());
    }
}
