package com.cegeka.springcourse.filters;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;


@Order(2)
@WebFilter(urlPatterns = "/entrance/*")
public class MembershipStatusFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = ((HttpServletRequest) servletRequest);
        String headerValue = httpRequest.getHeader("MEMBERSHIP_STATUS");
        if (headerValue == null || !valueExists(headerValue)) {
            HttpServletResponse response = ((HttpServletResponse) servletResponse);
            response.sendError(400, "Membership status not present or unknown");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    private boolean valueExists(String headerValue) {
        return Arrays.stream(MembershipStatus.values())
                .anyMatch(enumVal -> enumVal.name().equals(headerValue.toUpperCase()));
    }
}
