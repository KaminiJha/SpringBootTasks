package com.springboot.workers.springjdbc.repository;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.workers.springjdbc.dao.WorkerDAO;
import com.springboot.workers.springjdbc.model.Worker;

@Repository
public class WorkerRepo implements WorkerDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int add(Worker worker) throws SQLException {
		// TODO Auto-generated method stub
		int workerId = worker.getWorkerId();
        String firstName = worker.getFirstName();
        String lastName = worker.getLastName();
        int salary = worker.getSalary();
        Date date = worker.getJoiningDate();
        String department = worker.getDept();
        String email = worker.getEmail();
        String password=worker.getPassword();
        String joiningDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        String query = "INSERT INTO my_worker VALUES(?,?,?,?,?,?,?,?);";
        int  result=jdbcTemplate.update(query,	workerId,firstName,lastName, salary, joiningDate, department, email,password);
        System.out.println("##########  after update %%%%%%");
        return result;	
//		return 1;
	}

	@Override
	public Worker getWorker(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Worker> getWorkers() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Worker emp) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
