package com.springboot.workers.crudapi.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.repository.WorkerRepository;

@Service
public class WorkerService {
	
	@Autowired
	WorkerRepository workerRepo;
	
	public Worker getWorker(Integer id) throws SQLException {
			return workerRepo.findWorkerById(id);
	}
	

	public List<Worker> getWorkers() throws SQLException {
			return workerRepo.findAllWorkers();
	}
	
	public String createWorker(Worker worker) throws SQLException {
			workerRepo.insertWorker(worker);
			return worker.getFirstName()+" Added Successfully";	
	}
	

	public boolean updateWorker(Integer id, String email) throws SQLException {
			workerRepo.updateWorkerEmailById(email,id);
			return true;
		
	}

	public boolean deleteWorkerById(Integer id) throws SQLException {
			workerRepo.deleteWorkerById(id);
			return true;	
	}
}
