package com.adminDashboard.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TeacherDto {

	private int id;

	@NotNull 
	private String name;
	
	@NotEmpty
	@Size(min = 6, max= 6,  message="A neptun azonosító nem lehet 6 karakternél kisebb sem nagyobb.")
	private String neptun;
	
	
	@NotNull 
	private SemesterDto semester;

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


	public SemesterDto getSemester() {
		return semester;
	}

	public void setSemester(SemesterDto semester) {
		this.semester = semester;
	}
	
	
	
}