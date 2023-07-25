package in.santhoshdevendran.door_step;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import in.santhoshdevendran.door_step.exception.ValidationException;
import in.santhoshdevendran.door_step.model.User;
import in.santhoshdevendran.door_step.service.UserService;

public class TestGetAllUser {

	
	@Test
	public void getAllUser() {
		UserService userService = new UserService();

		List<User> users = userService.getAll();
	
		System.out.print(users);

	}
	
	@Test
	public void findById() {
		UserService userService = new UserService();
		
	System.out.println(userService.findById(1));
		
	}
	
	
//	@Test
//	
//	public void create() {
//		UserService userService = new UserService();
//
//	User newUser = new User();
//	//newUser.setId(56789);
//	newUser.setFirstname("Santhosh");
//	newUser.setLastname("Devendren");
//	newUser.setEmail("sandy@gmail.com");
//	newUser.setPassword("Azxcv@123");
//	//newUser.setActive(true);
//
//	assertDoesNotThrow(() -> {
//		userService.create(newUser);
//
//	});
//	}
	
	
	

}
