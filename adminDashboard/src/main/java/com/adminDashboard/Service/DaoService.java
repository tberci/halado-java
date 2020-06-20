package com.adminDashboard.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.adminDashboard.DAO.MilestoneRepository;
import com.adminDashboard.DAO.SemesterRepository;
import com.adminDashboard.DAO.StudentRepository;
import com.adminDashboard.DAO.TeacherRepository;
import com.adminDashboard.DTO.Milestone;
import com.adminDashboard.DTO.Semester;
import com.adminDashboard.DTO.Student;
import com.adminDashboard.DTO.Teacher;
import com.adminDashboard.DTO.Semester.Status;


@Service
public class DaoService implements ServiceInterface {

	
	@Autowired
	private SemesterRepository semesterRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private MilestoneRepository milestoneRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	

	@Override
	public Semester saveSemester(Semester semester) {
		return semesterRepository.save(semester);
	}
	@Override
	public List<Semester> listSemesters() {
		return semesterRepository.findAll();
	}
	
	@Override
	public Teacher saveTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}
	@Override
	public List<Teacher> listTeachers() {
		return teacherRepository.findAll();
	}
	@Override
	public Milestone saveMilestone(Milestone milestone) {
		return milestoneRepository.save(milestone);
	}
	@Override
	public List<Milestone> listMilestones() {
		return milestoneRepository.findAll();
	}
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	@Override
	public List<Student> listStudents() {
		return studentRepository.findAll();
	}
	
	@Override
	public String removeSemester(int id) {
		semesterRepository.deleteById(id);
		return "semester removed" +id;
	}
	
	@Override
	 public Optional<Semester> findById(int id) {

	        return semesterRepository.findById(id);
	    }
	
	@Override
	public List<Semester> findAllInactive() {
		  return semesterRepository.findByStatus(Status.INACTIVE);
	}

}
