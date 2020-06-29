package com.adminDashboard.DTO;

import javax.validation.constraints.NotNull;


public class SemesterDto {

	public enum Status {
	    ACTIVE,
	    INACTIVE, 
	    FINISHED; 
	}
		@NotNull
		private int id;
		
		@NotNull
		private String name;


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
		
}
