package com.adminDashboard.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adminDashboard.DTO.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	public List<Student> findAll();

	

	public Student findByName(String name);



	
	
}
