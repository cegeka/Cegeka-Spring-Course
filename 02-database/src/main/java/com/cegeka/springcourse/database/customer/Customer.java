package com.cegeka.springcourse.database.customer;

import com.cegeka.springcourse.database.order.Order;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "senior_discount")
    private boolean seniorDiscount;
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private List<Order> orders;

    private Customer(){}

    public Customer(int id, String name, String lastName, boolean seniorDiscount) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.seniorDiscount = seniorDiscount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isSeniorDiscount() {
        return seniorDiscount;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
