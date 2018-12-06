package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.repository.SpringJava4sDAO;

@RestController
public class SpringJava4sController {

    @Autowired
    public SpringJava4sDAO dao;

    @RequestMapping("/getcustInfo")
    public List <User> customerInformation() {
        List <User> customers = dao.isData();
        return customers;
    }

    @RequestMapping("/testSecondDatasource")
    public String dSverify() {
        return dao.dsVerification();
    }
}