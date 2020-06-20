import static org.junit.Assert.*;

import org.junit.Test;

import komplex.NeptunCodeGenerator;

public class NeptunCodeGeneratorTest {

	@Test
	public void getNextCounterTest() { 
		
		NeptunCodeGenerator ncode = new NeptunCodeGenerator();
		
		int counter = 0;
		
		assertEquals(ncode.getNextCounter(), counter);
		
	}

}
