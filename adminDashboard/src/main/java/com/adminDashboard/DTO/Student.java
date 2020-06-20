package com.adminDashboard.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotNull 
	private String name;
	
	@NotEmpty
	@Column(name = "neptun" ,unique=true)
	@Size(min = 6, max= 6 ,message="A neptun azonosító nem lehet 6 karakternél kisebb ,sem nagyobb.")
	private String neptun;
	
	//@NotNull 
	@ManyToOne()
	@JoinColumn(name="teacher_id",nullable = false)  //generál a hibernate egy idegen kulcsot a teacher adattaghoz., Vagyis összeköti a Teacher táblával.
	private Teacher teacher;
	
public Student() {
		
	}
	


	
	public Student(int id, @NotNull String name, @NotNull String neptun,  Teacher teacher) {
		super();
		this.id = id;
		this.name = name;
		this.neptun = neptun;
		this.teacher = teacher;
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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
}
