package com.cegeka.springcourse.database.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/ingredient/{ingredientId}")
    public List<Order> getOrdersWhereIngredientIsUsed(@PathVariable("ingredientId") int ingredientId) {
        return orderRepository.findByIngredientsId(ingredientId);
    }

}
