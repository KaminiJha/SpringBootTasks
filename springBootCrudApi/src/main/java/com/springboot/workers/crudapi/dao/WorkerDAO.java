package com.springboot.workers.crudapi.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.workers.crudapi.model.Worker;


public interface WorkerDAO {

	public int insertWorker(Worker worker) throws SQLException;

	public void deleteWorkerById(int workerId) throws SQLException;

	public Worker findWorkerById(int workerId) throws SQLException;

	public List<Worker> findAllWorkers() throws SQLException;
	
	public boolean updateWorkerEmailById(String email, int id) throws SQLException;
	
	public void replaceWorker(Worker worker) throws SQLException;
}