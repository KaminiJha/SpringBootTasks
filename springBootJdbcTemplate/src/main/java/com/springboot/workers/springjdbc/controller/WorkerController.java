package com.springboot.workers.springjdbc.controller;

import java.sql.Date;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.springjdbc.model.Worker;
import com.springboot.workers.springjdbc.repository.WorkerRepo;

@RestController
@RequestMapping("/worker")
public class WorkerController {
	@Autowired
	private WorkerRepo workerRepo;
	
	@GetMapping("/create")
	public String createWorker()  {
		int rowsAffected;
		try {
			rowsAffected = this.workerRepo.add(new Worker(19876, "TestFname", "TestLastNmae", 12355, "TestDEpt", "test@gmail.com"));
			return rowsAffected + " rows Affected";
		}
		catch(SQLException e)
		{
			return "Error";
		}
		
		
		
	}
	
}
