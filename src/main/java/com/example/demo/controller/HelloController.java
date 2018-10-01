package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;

@RestController
public class HelloController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
    JdbcTemplate jdbcTemplate;
    
	@RequestMapping("/")
    public String restTest(@RequestParam(value="name", defaultValue="World") String name) {
        return "Hello " + name ;
    }
	
	
	@GetMapping("/getUser")
    public List<User> getUser(@RequestParam(value="name",defaultValue="ALL") String name) {
		
		System.out.println("DDDDDDDDDDDDDDDDDDDDDddd");
		
		String sql = "SELECT * FROM users WHERE firstname like ?";
        List<Object> params = new ArrayList<Object>();
        if(name.equals("ALL")) {
        	params.add("%%");
        } else {
        	params.add("%"+name+"%");
        }

        Object arr [] = params.toArray(new Object[params.size()]);
        
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		
		List<User> article = jdbcTemplate.query(sql, rowMapper, arr);
		
		logger.debug("list size " + article.size());
    	
        return article;
    }
	
	
}
