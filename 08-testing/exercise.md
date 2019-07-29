# Weight Watchers

Weight Watchers became famous by assigning every food product a number of 'Smart Points'.
To reach your weight goal, you simply have to add the points of all items you eat during the day and make sure it does not cross some self defined limit.
This piece of software stores all kinds of food products and allows for users to retrieve the Smart Points worth of a food item.

For all of the following exercises 1 rule applies: You are not allowed to alter the production code in any way.

1. Unit test the SmartPointsCalculator. You can find the correct formula by following the commented out link at the top of the class.
One extra factor to be brought into consideration is the 'consumedDosis'. 
Eg: if the suggestedDosisInGrams of a product is 100g and the actualConsumedDosisInGram is 500g, the number of calculated SP by the original formula should be multiplied by 5.
2. Integration test the FoodProductRepository (see if you can save/retrieve by name)
3. End to end test the getSmartPointsForFoodProduct REST call. 

## Extra
1. Did you find the bug? You are allowed to correct it.
2. Tests should not add/alter/remove data in the production database. 
Make sure your tests don't either.