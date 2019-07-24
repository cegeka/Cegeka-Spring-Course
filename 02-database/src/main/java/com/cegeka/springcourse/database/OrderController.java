package com.cegeka.springcourse.database;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("order")
public class OrderController {

    @GetMapping("/ingredient/{id}")
    public Object getOrdersWhereIngredientIsUsed() {
        return null;
    }

}
