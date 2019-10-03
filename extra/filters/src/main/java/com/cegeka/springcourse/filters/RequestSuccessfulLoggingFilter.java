package com.cegeka.springcourse.filters;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Component
@Order(4)
public class RequestSuccessfulLoggingFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);

        HttpServletRequest httpRequest = ((HttpServletRequest)servletRequest);
        String userId = httpRequest.getRequestURI().split("entrance/")[1];

        System.out.println("Request for " + userId + " successful");

    }
}
