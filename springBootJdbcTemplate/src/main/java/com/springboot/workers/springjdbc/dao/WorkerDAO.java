package com.springboot.workers.springjdbc.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.workers.springjdbc.model.Worker;

public interface WorkerDAO {
	//create
	public int add(Worker worker) throws SQLException;
	//read
	public Worker getWorker(int id) throws SQLException;
	public List<Worker> getWorkers() throws SQLException;
	//update
	public int update(Worker emp) throws SQLException;
	//delete
    public int delete(int id) throws SQLException;    
}
