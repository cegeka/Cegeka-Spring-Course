package com.cegeka.springcourse.testing.smartpoints.calculation;

import com.cegeka.springcourse.testing.foodproduct.FoodProduct;
import org.springframework.stereotype.Component;

@Component
public class ProteinCalculator {
    public float calculate(FoodProduct foodProduct) {
        return 3.2f * foodProduct.getNumberOfProtein();
    }
}
