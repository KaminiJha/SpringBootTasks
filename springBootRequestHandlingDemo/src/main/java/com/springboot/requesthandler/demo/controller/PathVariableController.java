package com.springboot.requesthandler.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableController {

	@GetMapping("/showPathVariable/{id}")
	public String showName(@PathVariable String id)
	{
		return "id is "+id;
	}
}
