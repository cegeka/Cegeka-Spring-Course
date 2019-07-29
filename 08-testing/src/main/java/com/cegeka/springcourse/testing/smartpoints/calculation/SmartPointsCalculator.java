package com.cegeka.springcourse.testing.smartpoints.calculation;

import com.cegeka.springcourse.testing.foodproduct.FoodProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//  http://calorielab.com/news/2015/10/08/weight-watchers-pointsplus-formula/
@Component
public class SmartPointsCalculator {

    @Autowired
    private SugarCalculator sugarCalculator;
    @Autowired
    private SaturatedFatCalculator saturatedFatCalculator;
    @Autowired
    private ProteinCalculator proteinCalculator;
    @Autowired
    private ConsumedDosisCalculator consumedDosisCalculator;

    public Float calculatePoints(FoodProduct foodProduct, int actualConsumedDosisInGram) {
        return  consumedDosisCalculator.calculate(foodProduct, actualConsumedDosisInGram) *
                ((foodProduct.getNumberOfCalories()
                + sugarCalculator.calculate(foodProduct)
                + saturatedFatCalculator.calculate(foodProduct)
                - proteinCalculator.calculate(foodProduct))
                / 33);
    }
}
