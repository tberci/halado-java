import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class LengthValidatorTest {

	
	@Test
	public void isValidLengthTest1() {
		User user = new User("askraasa", true, "adsdgdggg1");
		
		LengthValidator valid = new LengthValidator();
		
		
		assertTrue(valid.isValid(user));
		
		
	}
	
	
	@Test
	public void isValidLengthTest2() {   //elbukik
		User user = new User("aska", true, "adsdgdggg1");
		
		LengthValidator valid = new LengthValidator();
		
		
		assertTrue(valid.isValid(user));
		
		
	}
	
	
	
	
}
