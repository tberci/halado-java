import static org.mockito.Mockito.*;

import org.junit.Test;

public class UserControllerTest {

	
	
	@Test
	public void saveTest() {
		NeptunCodeGenerator neptun = mock(NeptunCodeGenerator.class);
		UserService userService = mock(UserService.class);
		UserController uc = new UserController(userService, neptun);
		UserDto ud = mock(UserDto.class); 
		
		
		uc.save(ud);
		
		
		verify(ud, times(1)).getName();
		
	}

}
