package com.cegeka.springcourse.testing.foodproduct;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FoodProductRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private FoodProductRepository repository;

    @Test
    public void findByProductName() {
        FoodProduct toSave = new FoodProduct("Plastic", 1, 6, 2, 3, 4);
        entityManager.persist(toSave);
        entityManager.flush();

        FoodProduct actual = repository.findByProductname(toSave.getProductname());

        Assertions.assertThat(actual.getProductname()).isEqualTo(toSave.getProductname());
        Assertions.assertThat(actual.getNumberOfCalories()).isEqualTo(toSave.getNumberOfCalories());
        Assertions.assertThat(actual.getNumberOfProtein()).isEqualTo(toSave.getNumberOfProtein());
        // etc...
    }

    @Test
    public void save() {
        FoodProduct toSave = new FoodProduct("Cardboard", 5, 78, 4, 54, 45);

        FoodProduct actual = repository.save(toSave);

        Assertions.assertThat(actual.getProductname()).isEqualTo(toSave.getProductname());
        Assertions.assertThat(actual.getNumberOfCalories()).isEqualTo(toSave.getNumberOfCalories());
        Assertions.assertThat(actual.getNumberOfProtein()).isEqualTo(toSave.getNumberOfProtein());
        // etc...
    }
}