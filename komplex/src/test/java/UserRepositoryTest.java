import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import komplex.UseRepository;
import komplex.User;

public class UserRepositoryTest {

	@Test
	public void saveUserTest() {
		
		
		User user = new User("belafsdasgd", true ,"adfasdgs");
		
		UseRepository repository = new UseRepository();
		repository.save(user);
		List<User> users = repository.findAll();
		
		Assert.assertEquals(user.getName(), users.get(0).getName());
		
	}
	
	@Test
	public void getByNeptunTest1() {
		
		final String neptun = "asdsdfdg";
		User user = new User("belafsdasgd", true ,neptun);
		
		UseRepository repository = new UseRepository();
		repository.save(user);
		List<User> users = repository.findAll();
		
		
		Assert.assertEquals(repository.getByNektunKod("fdsasdg").getNeptunkod() ,users.get(0).getNeptunkod());
		
	}
	
	
	@Test
	public void getByNeptunTest2() {
		
		final String neptun = "asdsdfdg";
		User user = new User("belafsdasgd", true ,neptun);
		
		UseRepository repository = new UseRepository();
		repository.save(user);
		List<User> users = repository.findAll();
		
		
		Assert.assertEquals(repository.getByNektunKod(neptun).getNeptunkod() ,users.get(0).getNeptunkod());
		
	}
	
	@Test
	public void findByEnabledIsTrueTest() {
		
		
		User user = new User("belafsdasgd", false ,"adsgasgsg");
		
		UseRepository repository = new UseRepository();
		repository.save(user);
	
		List<User> result = repository.findAll();
		repository.findByEnabledIsTrue();
		user.isEnabled();
		
		Assert.assertEquals(user.getName(), result.get(0).getName());
		
	}

}
