package com.adminDashboard.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "semester")
public class Semester {
	
public enum Status {
    ACTIVE,
    INACTIVE, 
    FINISHED; 
}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id" ,unique=true)
	private int id;
	

	
	@Column(name = "name",unique=true,nullable = false, updatable = false)
	private String name;
	
	
	
	@OneToMany(mappedBy = "semester" )
	private List<Teacher> teachers;
	
	@OneToMany(mappedBy = "semester")
	private List<Milestone> milestones;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status = Status.INACTIVE;
	
	public Semester() {
		
	}
	
	public Semester(int id,String name) {
		this.id = id;
		this.name = name;
	}


	public Semester(int id, String name, Status status) {

		this.id = id;
		this.name = name;
		this.status = status;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}


	public List<Milestone> getMilestones() {
		return milestones;
	}


	public void setMilestones(List<Milestone> milestones) {
		this.milestones = milestones;
	}



	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}

}
