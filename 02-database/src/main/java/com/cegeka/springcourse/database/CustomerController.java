package com.cegeka.springcourse.database;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController()
@RequestMapping("customer")
public class CustomerController {

    @GetMapping("/{id}/orders")
    public List<String> getOrdersForCustomer(@PathParam("id") String customerId) {
        return null;
    }
}
