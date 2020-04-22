package com.calculatorweb.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Dto {

		@NotNull
		private Double x;
		@NotNull
		private Double y;

		public Double getX() {
			return x;
		}
		public void setX(Double x) {
			this.x = x;
		}
		public Double getY() {
			return y;
		}
		public void setY(Double y) {
			this.y = y;
		}
		
		
}
