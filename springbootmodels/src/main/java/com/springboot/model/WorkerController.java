package com.springboot.model;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Worker;

@RestController
@RequestMapping("/worker")
public class WorkerController {

	@GetMapping("/showWorker")
	public Worker showWorker() {
		return new Worker(111, "Kamini", "Jha", 10000, "IT","email@gmail.com");
	}

	@GetMapping("/all/showWorkers")
	public List<Worker> showWorkers() {
		return Arrays.asList(
				new Worker(222, "Akansha", "Singh", 12345, new Date(System.currentTimeMillis()), "Creative Dept",
						"aka@gmail.com"),
				new Worker(333, "Arushi", "Sharma", 23456, new Date(System.currentTimeMillis()), "Masti",
						"arushi@gmail.com"),
				new Worker(444, "Div", "Mishra", 45678, new Date(System.currentTimeMillis()), "Accounting",
						"div@gmail.com"));
	}

}