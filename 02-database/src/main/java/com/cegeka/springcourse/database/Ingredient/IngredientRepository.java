package com.cegeka.springcourse.database.Ingredient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

    public List<Name> findDistinctByContainGluten(boolean containGluten);
}
