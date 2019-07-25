package com.cegeka.springcourse.database.Ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("ingredients")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping("/amount")
    public Map<String, Long> getNumberOfIngredientsInStock() {
        return ingredientRepository.findAll().stream()
                .collect(Collectors.groupingBy(Ingredient::getName, Collectors.counting()));
    }

    @GetMapping("/glutenfree")
    public List<String> getGlutenFreeProductNames() {
        return ingredientRepository.findDistinctByContainGluten(false)
                .stream()
                .map(Name::getName)
                .collect(Collectors.toList());
    }

    @GetMapping("/glutencontaining")
    public List<String> getGlutenContainingProductNames() {
        return ingredientRepository.findDistinctByContainGluten(true)
                .stream()
                .map(Name::getName)
                .collect(Collectors.toList());
    }

    @GetMapping("/add/ingredient/{name}")
    public void addIngredient(@PathVariable("name") String name) {
        ingredientRepository.save(new Ingredient(name, true));
    }

    @GetMapping("/remove/ingredient/{id}")
    public void removeIngredient(@PathVariable("id") int id) {
        ingredientRepository.deleteById(id);
    }

    @GetMapping("/update/ingredient/{id}/{name}")
    public void updateIngredientName(@PathVariable("id") int id, @PathVariable("name") String name) {
        ingredientRepository.findById(id)
            .map(ingredient -> {
                ingredient.setName(name);
                return ingredientRepository.save(ingredient);
            }).orElseThrow(() -> new IllegalArgumentException("Ingredient to update not found"))
        ;
    }
}
