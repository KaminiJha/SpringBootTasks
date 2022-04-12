package com.springboot.workers.crudapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.crudapi.util.DateTimeUtilities;





@RestController
public class HomeController {
	@GetMapping("/")
	public String showWelcomMessage() {
		return "Hello Visitor!<br>Visiting Time: " + DateTimeUtilities.getTimeStamp();
	}
}