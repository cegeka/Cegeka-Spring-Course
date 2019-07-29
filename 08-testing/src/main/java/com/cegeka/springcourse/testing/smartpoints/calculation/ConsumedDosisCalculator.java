package com.cegeka.springcourse.testing.smartpoints.calculation;

import com.cegeka.springcourse.testing.foodproduct.FoodProduct;
import org.springframework.stereotype.Component;

@Component
public class ConsumedDosisCalculator {


    public float calculate(FoodProduct foodProduct, int actualConsumedDosisInGram) {
        return (float) foodProduct.getSuggestedDosisInGrams() / actualConsumedDosisInGram;
    }
}
