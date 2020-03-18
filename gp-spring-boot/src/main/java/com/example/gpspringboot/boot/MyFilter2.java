package com.example.gpspringboot.boot;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFilter2 extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        doSomthing();
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
    public static  void  doSomthing(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

        ServletRequestAttributes requestAttributes1 = (ServletRequestAttributes) requestAttributes;

        HttpServletRequest request = requestAttributes1.getRequest();

        ServletContext servletContext = request.getServletContext();

        StringBuffer requestURL = request.getRequestURL();

        String requestURI = request.getRequestURI();

        servletContext.log("/MyFilter2 MyFilter2  MyFilter2"+requestURL+"--"+requestURI);

    }
}
