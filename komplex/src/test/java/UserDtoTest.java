import static org.junit.Assert.*;

import org.junit.Test;

public class UserDtoTest {

	@Test
	public void getNameTest() {
		
		String name = "asd";
		UserDto dto = new UserDto(name);
		
		
		assertEquals(dto.getName(), name );
	}

	
	@Test
	public void setNameTest() {
		
		String name = "krokl";
		UserDto dto = new UserDto("adsg");
		dto.setName(name);
		
		assertEquals(dto.getName(), name );
	}

}
