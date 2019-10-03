package com.cegeka.springcourse.filters;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;


@Component
@Order(3)
public class AccessLoggingFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = ((HttpServletRequest)servletRequest);
        String userId = httpRequest.getRequestURI().split("entrance/")[1];

        System.out.println("Member " + userId + " wants to enter");

        filterChain.doFilter(servletRequest, servletResponse);

    }
}
