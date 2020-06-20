import static org.junit.Assert.*;

import org.junit.Test;

import komplex.SpaceValidator;
import komplex.User;

public class SpaceValidatorTest {

	@Test
	public void isValidSpaceTest1() {   //branch 1
		User user = new User("askrasa", true, "adsdgdggg1");
		
		SpaceValidator valid = new SpaceValidator();
		
		
		
		assertTrue(valid.isValid(user));
		
		
	}
	
	@Test
	public void isValidSpaceTest2() { //branch 2   //elbukik
		User user = new User("askr asa", true, "adsdgdggg1");
		
		SpaceValidator valid = new SpaceValidator();
		
		
		
		assertTrue(valid.isValid(user));
		
		
	}

}
