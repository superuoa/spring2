package com.example.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;
import com.example.demo.model.User;

@Repository
public class SpringJava4sDAO {

    @Autowired
    private JdbcTemplate jdbcTemplateOne;

    @Autowired
    private JdbcTemplate jdbcTemplateTwo;


    public List <User> isData() {

        
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		
		List<User> article = jdbcTemplateOne.query("select * from user", rowMapper);

        return article;

    }

    public String dsVerification() {

        String status = "";

        String query = jdbcTemplateTwo.queryForObject("SELECT COUNT(*) FROM customer;", String.class);

        if (query.equals("1")) {
            status = "Datasource connection successful..!";
        } else {
            status = "Datasource connection failed..!";
        }

        return status;

    }
}