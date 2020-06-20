package com.adminDashboard.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adminDashboard.DTO.Milestone;



@Repository
public interface MilestoneRepository  extends CrudRepository<Milestone, Integer> {
	public List<Milestone> findAll();

	public Milestone findByName(String name);
	
}
