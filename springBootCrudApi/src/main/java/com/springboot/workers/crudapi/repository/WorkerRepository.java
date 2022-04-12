package com.springboot.workers.crudapi.repository;

import java.sql.*;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.workers.crudapi.dao.WorkerDAO;
import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.util.DataBaseConnection;

import java.util.ArrayList;

@Repository
public class WorkerRepository implements WorkerDAO {
    private final Connection con;
    
    public WorkerRepository() throws SQLException {
        this.con = DataBaseConnection.getConnection();
    }

    @Override
    public int insertWorker(Worker worker) throws SQLException {
        String format =  "INSERT INTO my_worker (WORKER_ID,FIRST_NAME,LAST_NAME,SALARY,JOINING_DATE,DEPARTMENT,EMAIL) VALUES (?,?,?,?,?,?,? )";
        try (PreparedStatement ps = con.prepareStatement(format)) {
        	System.out.println("inside repo");
        	System.out.println(worker.getWorkerId()+"\n,"+worker.getFirstName()+"\n,"+worker.getLastName()+"\n,"+worker.getSalary()+"\n,"+worker.getJoiningDate()+"\n,"+ worker.getDept()+"\n,"+ worker.getEmail());
            ps.setInt(1, worker.getWorkerId());
            ps.setString(2, worker.getFirstName());
            ps.setString(3, worker.getLastName());
            ps.setInt(4, worker.getSalary());
            ps.setDate(5, worker.getJoiningDate());
            ps.setString(6, worker.getDept());
            ps.setString(7, worker.getEmail());

            int col = ps.executeUpdate();
            System.out.println(col + " row added");
            return col;
        }
    }

    
    @Override
    public Worker findWorkerById(int workerId) throws SQLException {
        String get = String.format("select * from my_worker where worker_id='%d'", workerId);
        Worker worker = null;
        try (Statement state = con.createStatement()) {
            ResultSet result = state.executeQuery(get);
            while (result.next()) {
                int id = result.getInt(1);
                String fName = result.getString(2);
                String lName = result.getString(3);
                int salary = result.getInt(4);
                Date jDate = result.getDate(5);
                String dept = result.getString(6);
                String email = result.getString(7);
                worker = new Worker(id, fName, lName, salary, jDate, dept, email);
            }
        }
        return worker;
    }

    @Override
    public List<Worker> findAllWorkers() throws SQLException {
        List<Worker> workers = new ArrayList<>();

        try (Statement state = con.createStatement()) {
            ResultSet res = state.executeQuery("select * from my_worker");
            while (res.next()) {
                int id = res.getInt(1);
                String fName = res.getString(2);
                String lName = res.getString(3);
                int salary = res.getInt(4);
                Date jDate = res.getDate(5);
                String dept = res.getString(6);
                String email = res.getString(7);
                workers.add(new Worker(id, fName, lName, salary, jDate, dept, email));
            }
        }
        return workers;
    }

    @Override
    public void replaceWorker(Worker worker) throws SQLException {
        String update = "update my_worker set first_name=?,last_name=?,salary=?,joining_date=?,department=?,email=? where worker_id=?";
        try (PreparedStatement prep = con.prepareStatement(update)) {
            prep.setString(1, worker.getFirstName());
            prep.setString(2, worker.getLastName());
            prep.setInt(3, worker.getSalary());
            prep.setDate(4, worker.getJoiningDate());
            prep.setString(5, worker.getDept());
            prep.setString(6, worker.getEmail());
            prep.setInt(7, worker.getWorkerId());

            int rowCount = prep.executeUpdate();
            System.out.println(rowCount + " row updated");
        }
    }
    
    @Override
    public boolean updateWorkerEmailById( String email,int workerId) throws SQLException{
    	String update = "update my_worker set email=? where worker_id=?";
    	
    	PreparedStatement prep = con.prepareStatement(update);
    	prep.setString(1, email);
    	prep.setInt(2, workerId);
    	
    	int rowCount = prep.executeUpdate();
    	
    	return rowCount==1;
    		
    }


	@Override
	public void deleteWorkerById(int workerId) throws SQLException {
		// TODO Auto-generated method stub
		String query="Delete from my_worker where worker_id=?";
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setInt(1, workerId);
		int rowCount=pstmt.executeUpdate();
		System.out.println( rowCount+" row is deleted successfully");
	}

	

	
}
