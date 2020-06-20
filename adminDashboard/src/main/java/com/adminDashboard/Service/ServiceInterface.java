package com.adminDashboard.Service;

import java.util.List;
import java.util.Optional;

import com.adminDashboard.DTO.Milestone;
import com.adminDashboard.DTO.Semester;
import com.adminDashboard.DTO.Student;
import com.adminDashboard.DTO.Teacher;

public interface ServiceInterface {
	
	public Semester saveSemester(Semester semester);
	
	public List<Semester> listSemesters();
		
	public Teacher saveTeacher(Teacher teacher);
	
	public List<Teacher> listTeachers(); 
	
	
	public Milestone saveMilestone(Milestone milestone);
	
	
	public List<Milestone> listMilestones(); 
		
	
	public Student saveStudent(Student student);
	
	
	public List<Student> listStudents();
	
	
	public String removeSemester(int id);
		
	
	public Optional<Semester> findById(int id);


	//public List<Semester> findActive();
	 
	public List<Semester> findAllInactive();
      
    

	   
}
