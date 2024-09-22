package com.example.electronicStore.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String homeController(HttpServletRequest request)
    {
        String paramValue = request.getHeader("Cookie");
        System.out.println(paramValue);
        return "Hello"+paramValue;
    }

    @GetMapping("csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request)
    {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("hello")
    public String sayHello()
    {
                return "Hello from hello endpoint";}


    @GetMapping("admin")
    public String sayAdminHello()
    {
        return "Hello from admin endpoint";}
}
