package com.cegeka.springcourse.testing.foodproduct;

import com.cegeka.springcourse.testing.smartpoints.calculation.SmartPointsCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FoodProductService {

    @Autowired
    private FoodProductRepository repository;
    @Autowired
    private SmartPointsCalculator calculator;

    public void add(FoodProduct foodProduct) {
        if(get(foodProduct.getProductname()) == null) {
            repository.save(foodProduct);
        } else {
            throw new IllegalArgumentException("Fooditem with name " + foodProduct.getProductname() + " already exists!");
        }
    }

    public FoodProduct get(String name) {
        return repository.findByProductname(name);
    }

    public Float getSp(String name, int amountconsumed) {
        FoodProduct foodProduct = get(name);
        return calculator.calculatePoints(foodProduct, amountconsumed);
    }
}
