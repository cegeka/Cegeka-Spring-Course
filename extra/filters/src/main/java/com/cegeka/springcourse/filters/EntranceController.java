package com.cegeka.springcourse.filters;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class EntranceController {

    @PostMapping(path = "/entrance/{memberId}")
    public String enter(@RequestBody BookAndMember bookAndMember) {
        return "Welcome " + bookAndMember.getMemberName() + "!\n "
                + "Have fun reading " + bookAndMember.getBookName();
    }
}
