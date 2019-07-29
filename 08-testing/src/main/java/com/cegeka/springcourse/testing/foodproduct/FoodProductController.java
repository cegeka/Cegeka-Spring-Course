package com.cegeka.springcourse.testing.foodproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("foodproduct")
public class FoodProductController {

    @Autowired
    private FoodProductService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addFoodProduct(@RequestBody FoodProduct foodProduct) {
        service.add(foodProduct);
    }

    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FoodProduct getFoodProduct(@PathVariable("name") String name) {
        return service.get(name);
    }

    @GetMapping(value = "/{name}/sp/{amountconsumed}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Float getSmartPointsForFoodProduct(@PathVariable("name") String name, @PathVariable("amountconsumed") int amountconsumed) {
        return service.getSp(name, amountconsumed);
    }
}
