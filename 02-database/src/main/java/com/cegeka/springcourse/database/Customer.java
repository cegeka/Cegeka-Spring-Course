package com.cegeka.springcourse.database;

import java.util.List;

public class Customer {

    private int id;
    private String name;
    private String lastName;
    private boolean seniorDiscount;
    private List<Order> orders;
}
