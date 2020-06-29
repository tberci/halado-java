package com.adminDashboard.DTO;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class MilestoneDto {

	@NotNull 
	private int id;
	@NotNull 
	private String name;
	
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@NotNull 
	private String notice;
	
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public SemesterDto getSemester() {
		return semester;
	}

	public void setSemester(SemesterDto semester) {
		this.semester = semester;
	}
	
	
	
}
