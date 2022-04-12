package com.springboot.workers.springjdbc.controller;

import java.sql.Timestamp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping("/")
	public String showWelcomMessage() {
		return "Hello Visitor!<br>Visiting Timee: " + new Timestamp(System.currentTimeMillis());
	}
}
