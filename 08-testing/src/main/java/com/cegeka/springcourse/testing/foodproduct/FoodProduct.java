package com.cegeka.springcourse.testing.foodproduct;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "FOODPRODUCT")
public class FoodProduct implements Serializable {

    @Id
    private String productname;
    @Column(name = "CALORIES")
    private int numberOfCalories;
    @Column(name = "SUGAR")
    private int numberOfSugar;
    @Column(name = "FAT")
    private int numberOfSaturatedFat;
    @Column(name = "PROTEIN")
    private int numberOfProtein;
    @Column(name = "DOSIS")
    private int suggestedDosisInGrams;

    public FoodProduct() {
    }

    public FoodProduct(String productname, int numberOfCalories, int numberOfSaturatedFat, int numberOfProtein, int suggestedDosisInGrams) {
        this.productname = productname;
        this.numberOfCalories = numberOfCalories;
        this.numberOfSaturatedFat = numberOfSaturatedFat;
        this.numberOfProtein = numberOfProtein;
        this.suggestedDosisInGrams = suggestedDosisInGrams;
    }

    public String getProductname() {
        return productname;
    }

    public int getNumberOfCalories() {
        return numberOfCalories;
    }

    public int getNumberOfSaturatedFat() {
        return numberOfSaturatedFat;
    }

    public int getNumberOfProtein() {
        return numberOfProtein;
    }

    public int getSuggestedDosisInGrams() {
        return suggestedDosisInGrams;
    }

    public int getNumberOfSugar() {
        return numberOfSugar;
    }
}
