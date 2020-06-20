import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import komplex.LengthValidator;
import komplex.SpaceValidator;
import komplex.User;
import komplex.UserModify;
import komplex.UserServiceImpl;
import komplex.Validator;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImplTest {
	


@Mock
List<Validator> validators;


@Before public void initMocks() {
    MockitoAnnotations.initMocks(this);
    
}

	@Test
	public void saveTest() {

		validators = new ArrayList<>();
		UserModify um = mock(UserModify.class);
		LengthValidator lv = mock(LengthValidator.class);
		SpaceValidator sp = mock(SpaceValidator.class);
		User user = new User("belafsdasgd", true ,"adfasdgs");
		validators.add(sp);
		validators.add(lv);
		
		when(validators.get(0).isValid(user)).thenReturn(true);
		when(validators.get(1).isValid(user)).thenReturn(true);
		
		UserServiceImpl service = new UserServiceImpl(um, validators);
		
		service.save(user);
		verify(um, times(1)).save(user);
	}
	
	
	@Test
	public void isValidTest() {

		validators = new ArrayList<>();
		
		LengthValidator lv = mock(LengthValidator.class);
		SpaceValidator sp = mock(SpaceValidator.class);
		User user = new User("dfhsdfdh", true ,"adfasdgs");
		validators.add(sp);
		validators.add(lv);
		
		when(validators.get(0).isValid(user)).thenReturn(true);
		
		assertTrue(validators.get(0).isValid(user));
		
		
		when(validators.get(1).isValid(user)).thenReturn(true);
		
		assertTrue(validators.get(1).isValid(user));
		
		

		
		
	
	}
	
	

}
