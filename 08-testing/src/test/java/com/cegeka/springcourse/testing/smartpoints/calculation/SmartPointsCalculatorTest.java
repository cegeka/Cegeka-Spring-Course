package com.cegeka.springcourse.testing.smartpoints.calculation;

import com.cegeka.springcourse.testing.foodproduct.FoodProduct;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SmartPointsCalculator.class})
public class SmartPointsCalculatorTest {
    @Autowired
    private SmartPointsCalculator smartPointsCalculator;
    @MockBean
    private ProteinCalculator proteinCalculator;
    @MockBean
    private SaturatedFatCalculator saturatedFatCalculator;
    @MockBean
    private SugarCalculator sugarCalculator;
    @MockBean
    private ConsumedDosisCalculator consumedDosisCalculator;

    @Test
    public void calculatePoints() {
        FoodProduct foodProduct = new FoodProduct("Cheese", 220, 7, 100, 100, 100);
        int actualConsumedDosisInGram = 1;

        Mockito.when(sugarCalculator.calculate(foodProduct)).thenReturn(200);
        Mockito.when(saturatedFatCalculator.calculate(foodProduct)).thenReturn(300);
        Mockito.when(proteinCalculator.calculate(foodProduct)).thenReturn(60f);
        Mockito.when(consumedDosisCalculator.calculate(foodProduct, actualConsumedDosisInGram)).thenReturn(2f);

        Float actual = smartPointsCalculator.calculatePoints(foodProduct, actualConsumedDosisInGram);

        Assertions.assertThat(actual).isEqualTo(40);
    }
}