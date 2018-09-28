package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;

@RestController
public class HelloController {

	@Autowired
    JdbcTemplate jdbcTemplate;
    
	@RequestMapping("/")
    public String restTest(@RequestParam(value="name", defaultValue="World") String name) {
        return "Hello " + name ;
    }
	
	
	@RequestMapping("/getUser")
    public List<User> getUser(@RequestParam(value="name",required=false) String name) {
		
		String sql = "SELECT * FROM users WHERE firstname like ?";
        List<Object> params = new ArrayList<Object>();
        params.add("%"+name+"%");
        
        Object arr [] = params.toArray(new Object[params.size()]);
        
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		
		List<User> article = jdbcTemplate.query(sql, rowMapper, arr);
    	
        return article;
    }
	
	
}
