package com.adminDashboard.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adminDashboard.Entity.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer>{

	public List<Teacher> findAll();



	public Teacher findByName(String nev);

	
	
      
	
}
