package com.bnpp.smartf.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public String findAll() {
		return "should return the users list..";
	}

}
