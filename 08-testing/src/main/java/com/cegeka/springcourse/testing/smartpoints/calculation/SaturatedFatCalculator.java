package com.cegeka.springcourse.testing.smartpoints.calculation;

import com.cegeka.springcourse.testing.foodproduct.FoodProduct;
import org.springframework.stereotype.Component;

@Component
public class SaturatedFatCalculator {
    public int calculate(FoodProduct foodProduct) {
        return 9 * foodProduct.getNumberOfSaturatedFat();
    }
}
