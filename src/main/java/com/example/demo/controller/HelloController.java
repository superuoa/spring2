package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/test")
    public String restTest(@RequestParam(value="name", defaultValue="World") String name) {
        return "Return name= " + name ;
    }
	
}
