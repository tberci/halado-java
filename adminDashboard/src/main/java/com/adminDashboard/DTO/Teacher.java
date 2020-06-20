package com.adminDashboard.DTO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int id;

	@NotNull 
	private String name;
	
	@NotEmpty
	@Column(name = "neptun" ,unique=true)
	@Size(min = 6, max= 6,  message="A neptun azonosító nem lehet 6 karakternél kisebb sem nagyobb.")
	private String neptun;
	
	@OneToMany(mappedBy = "teacher")
	private List<Student> studentList;
	
	@NotNull 
	@ManyToOne()
	@JoinColumn(name="semester_id",nullable = false) 
	private Semester semester;

	public Teacher() {
		
	}

	public Teacher(String name) {
		this.name = name;
	}

	public List<Student> getStudentList() {
		return studentList;
	}



	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
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
	public String getNeptun() {
		return neptun;
	}
	public void setNeptun(String neptun) {
		this.neptun = neptun;
	}

	
	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", nev=" + name + ", neptun=" + neptun + "]";
	}
	
	
	
}
