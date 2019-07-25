package com.cegeka.springcourse.database.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerOrdersCustomRepository customRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/{id}/orders")
    public Customer getOrdersForCustomer(@PathVariable("id") int customerId) {
//        return customerRepository.findById(customerId);
        return customRepository.getOrdersForCustomer(customerId);
    }

    @GetMapping("/specification")
    public List<Customer> getCustomersAccordingToAgreedSpecifications() {
        return customerRepository.findAll(hasNoSeniorDiscount().and(firstNameContainsP()).and(lastNameContainsP()));
    }

    private Specification<Customer> lastNameContainsP() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.or(
                criteriaBuilder.like(root.get("lastName"), "%P%"),
                criteriaBuilder.like(root.get("lastName"), "%p%"));
    }

    private Specification<Customer> firstNameContainsP() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.or(
                criteriaBuilder.like(root.get("name"), "%P%"),
                criteriaBuilder.like(root.get("name"), "%p%"));
    }

    private static Specification<Customer> hasNoSeniorDiscount() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.isFalse(root.get("seniorDiscount"));
    }
}
