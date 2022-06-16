package com.home.thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller //Make sure you have @Controller annotation instead of @RestController, because @RestController annotation will convert the responses returning from methods as JSON types.
public class ProductController {
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String getProductPage(){
        return "product";
    }
}
