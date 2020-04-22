package com.calculatorLogic;

public class CalculatorLogic implements Calculator {

	private double szam1;
	private double szam2;
	
	
	
	public CalculatorLogic() {
	}

	
	
	public double getSzam1() {
		return szam1;
	}



	public void setSzam1(double szam1) {
		this.szam1 = szam1;
	}



	public double getSzam2() {
		return szam2;
	}



	public void setSzam2(double szam2) {
		this.szam2 = szam2;
	}



	public double osszead(double a, double b) {
		return a+b;
		
	}

	public double kivon(double a, double b) {
		return a-b;
		
	}

	public double szoroz(double a, double b) {
		return a*b;
		
	}

	public double oszt(double a, double b) {
		
		return a/b;
		
	}

}
