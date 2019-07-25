package com.cegeka.springcourse.database.order;

import com.cegeka.springcourse.database.Ingredient.Ingredient;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private int id;
    @Column(name = "order_date")
    private Date orderDate;
    @Column(name = "customer_id")
    private String customerId;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "order_ingredients",
            joinColumns = { @JoinColumn(name = "order_id") },
            inverseJoinColumns = { @JoinColumn(name = "ingredient_id") }
    )
    private Set<Ingredient> ingredients = new HashSet<>();

    private Order(){}

    public Order(int id, Date orderDate, String customerId) {
        this.id = id;
        this.orderDate = orderDate;
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }
}
