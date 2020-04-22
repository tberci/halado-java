package calculatorLogic;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.calculatorLogic.CalculatorLogic;

public class CalcilatorLogicTest {

	
	
	@Test
	public void osszeadTest() {
		CalculatorLogic calc = new CalculatorLogic();
		
		Integer a = 10;
		Integer b = 4;
		Integer result = (int) calc.osszead(a, b);
		Integer expected = 14;
		assertEquals(expected, result);
	}
	
	
	@Test
	public void kivonTest() {
		CalculatorLogic calc = new CalculatorLogic();
		
		Integer a = 10;
		Integer b = 4;
		Integer result = (int) calc.kivon(a, b);
		Integer expected = 6;
		assertEquals(expected, result);
	}
	
	@Test
	public void szorozTest() {
		CalculatorLogic calc = new CalculatorLogic();
		
		Integer a = 10;
		Integer b = 4;
		Integer result = (int) calc.szoroz(a, b);
		Integer expected = 40;
		assertEquals(expected, result);
	}
	
	@Test
	public void osztTest() {
		CalculatorLogic calc = new CalculatorLogic();
		
		Integer a = 10;
		Integer b = 4;
		Integer result = (int) calc.oszt(a, b);
		Integer expected = 2;
		assertEquals(expected, result);
	}

}
