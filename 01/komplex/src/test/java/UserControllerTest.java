import static org.mockito.Mockito.*;

import org.junit.Test;

import komplex.NeptunCodeGenerator;
import komplex.UserController;
import komplex.UserDto;
import komplex.UserService;

public class UserControllerTest {

	
	
	@Test
	public void saveTest() {
		NeptunCodeGenerator neptun = mock(NeptunCodeGenerator.class);
		UserService userService = mock(UserService.class);
		UserController userController = new UserController(userService, neptun);
		UserDto userDto = mock(UserDto.class); 
		
		
		userController.save(userDto);
		
		
		verify(userDto, times(1)).getName();
		
	}

}
