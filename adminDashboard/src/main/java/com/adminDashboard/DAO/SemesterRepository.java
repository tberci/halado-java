package com.adminDashboard.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adminDashboard.DTO.Semester;
import com.adminDashboard.DTO.Semester.Status;

@Repository
public interface SemesterRepository  extends CrudRepository<Semester, Integer>{

	public List<Semester> findAll();
	
	//public List<Semester> findByActive(Boolean active);

	public  List<Semester> findByStatus(Status state);

	public Semester findByName(String name);
	
}
