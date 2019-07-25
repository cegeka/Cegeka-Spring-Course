package com.cegeka.springcourse.database.customer;

import com.cegeka.springcourse.database.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerOrdersCustomRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Customer getOrdersForCustomer(int customerId) {
       return jdbcTemplate.query("SELECT * FROM customer c inner join orders o on c.id = o.customer_id where c.id = ?",
                new Object[]{customerId},
                new CustomerRowMapper()
        );
    }


    private class CustomerRowMapper implements ResultSetExtractor<Customer> {
        @Override
        public Customer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            Customer customer = null;
            List<Order> orders = new ArrayList<>();
            while(resultSet.next()) {
                if(customer == null) {
                    customer = new Customer(
                            resultSet.getInt(1),
                            resultSet.getString("NAME"),
                            resultSet.getString("LAST_NAME"),
                            resultSet.getBoolean("SENIOR_DISCOUNT")
                    );
                }
                orders.add(new Order(
                        resultSet.getInt(5),
                        resultSet.getDate("ORDER_DATE"),
                        resultSet.getString("CUSTOMER_ID")
                ));
            }
            customer.setOrders(orders);
            return customer;
        }
    }
}
