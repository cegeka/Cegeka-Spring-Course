package com.cegeka.springcourse.testing.foodproduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodProductRepository extends JpaRepository<FoodProduct, String> {

    FoodProduct findByProductname(String name);
}
