package com.cegeka.springcourse.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Order(1)
@WebFilter(urlPatterns = "/entrance/*")
public class MemberIdFilter implements Filter {

    @Autowired
    private MemberRepository repository;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = ((HttpServletRequest)servletRequest);
        String userId = httpRequest.getRequestURI().split("entrance/")[1];
        if(!repository.getMembers().contains(userId)) {
            HttpServletResponse response =((HttpServletResponse)servletResponse);
            response.sendError(400, "MemberId not found");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }
}
