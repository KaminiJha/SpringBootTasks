package com.springboot.workers.crudapi.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.service.WorkerService;


@RestController
@RequestMapping("/worker")
public class WorkerController {
	@Autowired
	private WorkerService workerService;

	@GetMapping("/worker/{id}")
	public Worker showWorker(@PathVariable int id) throws SQLException {
		return this.workerService.getWorker(id);

	}

	@GetMapping("/all")
	public List<Worker> showAllWorker() throws SQLException {
		return this.workerService.getWorkers();

	}

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public String createWorker(@RequestBody Worker worker) throws SQLException {
//		System.out.println(worker);
		return this.workerService.createWorker(worker);
	}

	@PatchMapping("/update/{id}")
	public Boolean updateWorker(@RequestBody Map<String, String> params, @PathVariable int id) throws SQLException {
		return this.workerService.updateWorker(id,params.get("email"));
	}

	@DeleteMapping("/delete/{id}")
	public Boolean deleteWorker(@PathVariable int id) throws SQLException {
		return this.workerService.deleteWorkerById(id);

	}
}