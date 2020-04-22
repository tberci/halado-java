package proba;

import java.util.Scanner;

import com.calculatorLogic.CalculatorLogic;

public class Console {

	public static void main(String[] args) {
		
		CalculatorLogic calc = new CalculatorLogic();
		Scanner sc = new Scanner(System.in);
		
		double c ;
		
		String operator = null;
	
		System.out.println("elsõ szám");
		double a = sc.nextDouble();
		
		System.out.println("második szám");
		double b = sc.nextDouble();
		
		
		System.out.println("operands : + , - , * , /");
		operator = sc.next();
		
		
		switch(operator) {
		case  "+" : 
			c = calc.osszead(a, b);System.out.println("vegeredmeny :" + c);	
			break;
			
		case "-" :
			c = calc.kivon(a, b);System.out.println("vegeredmeny :" + c)	;
			break;
			
		case "*" : 
			c = calc.szoroz(a, b);System.out.println("vegeredmeny :" + c);	
			break;
			
		case "/" : 
			c = calc.oszt(a, b);System.out.println("vegeredmeny :" + c)	;
			break;
		}
		
		
	
	sc.close();
	}

}
