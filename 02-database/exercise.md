# Road house

The road house bar has some problems keeping track of all the ingredients they have in stock.
This makes it hard for the cook to determine if he can or cannot cook what a customer wants and when he should order some more ingredients of a certain type.

1. localhost:8080/ingredients/amount should return a list of key-value pairs indicating how many ingredients there are per type of food.
<br/>Eg:<br/>
{'potato': 5},<br/>
{'ketchup': 6},<br/>
{'vinegar': 7}<br/><br/>
Map the correct columns on the Ingredients object. Then create a repository extending JpaRepository that can work with these Ingredient objects.
 
2. Implement the getGlutenFreeProductNames and getGlutenContainingProductNames methods.

3. A Customer has a number of Orders. An Order is always linked to one Customer. 
Implement the getOrdersForCustomer method on CustomerController. It should return a Customer object that has all of its orders.
To achieve this you'll need to:
    1. Add some new tables in data.sql (also populate these tables with some data)
    2. Add the necessary mappings to the Customer and Order objects
    3. Create a new repository for Customer

4. An Order has a number of Ingredients needed to prepare it. An Ingredient is used in multiple orders.
Implement the getOrdersWhereIngredientIsUsed in the OrderController. 
Similar steps as in exercise 3 should be followed.

5. Implement the addIngredient method on IngredientController

6. Implement the removeIngredient method on IngredientController. What happens if you remove an Ingredient that is coupled to an Order?

7. Implement the updateIngredientName method on IngredientController

##Extra

1. Rewrite the getOrdersForCustomer with a JdbcTemplate query.

2. Create specifications to find Customers whose first and last name contain 'p' and who do not have a senior discount. 
Implement this in the getUsingSpecification in CustomerController.

https://dzone.com/articles/using-spring-data-jpa-specification <br/>
https://spring.io/blog/2011/04/26/advanced-spring-data-jpa-specifications-and-querydsl/ <br/>
https://www.baeldung.com/rest-api-search-language-spring-data-specifications
