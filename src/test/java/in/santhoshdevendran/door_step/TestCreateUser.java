package in.santhoshdevendran.door_step;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.santhoshdevendran.door_step.exception.ValidationException;
import in.santhoshdevendran.door_step.model.User;
import in.santhoshdevendran.door_step.service.UserService;

public class TestCreateUser {

	@Test
	public void testCreateUserWithValidDataInput() {
		UserService userService = new UserService();

		User newUser = new User();
		//newUser.setId(56789);
		newUser.setFirstname("Santhosh");
		newUser.setLastname("Devendren");
		newUser.setEmail("sandy1@gmail.com");
		newUser.setPassword("Azxcv@123");
		//newUser.setActive(true);

		assertDoesNotThrow(() -> {
			userService.create(newUser);

		});

	}

	@Test

	public void testCreateUserWithInvalidData() {
		UserService userService = new UserService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(null);
		});
		String expectedMessage = "invalid user input";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test

	public void testCreateUserWithEmailNull() {
		UserService userService = new UserService();
		Exception exception = assertThrows(ValidationException.class, () -> {

			User newUser = new User();
			newUser.setId(12345);
			newUser.setFirstname("Santhosh");
			newUser.setLastname("devendran");
			newUser.setEmail(null);
			newUser.setPassword("Asdfs@123");
			newUser.setActive(true);

			userService.create(newUser);
		});
		String expectedMessage = "email cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test

	public void testCreateUserWithEmailEmpty() {
		UserService userService = new UserService();
		Exception exception = assertThrows(ValidationException.class, () -> {

			User newUser = new User();
			newUser.setId(12345);
			newUser.setFirstname("Santhosh");
			newUser.setLastname("devendran");
			newUser.setEmail("");
			newUser.setPassword("Asdfg@123");
			newUser.setActive(true);

			userService.create(newUser);
		});
		String expectedMessage = "email cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	
	@Test

	public void testCreateUserWithExistingEmail() {
		UserService userService = new UserService();
		Exception exception = assertThrows(RuntimeException.class, () -> {

			User newUser = new User();
			newUser.setFirstname("Santhosh");
			newUser.setLastname("devendran");
			newUser.setEmail("sandyq@gmail.com");
			newUser.setPassword("Asdf@123");
			
			userService.create(newUser);
		});
		String expectedMessage = "Duplicate constraint";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	
	
	@Test

	public void testCreateUserWithPasswordEmpty() {
		UserService userService = new UserService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			User newUser = new User();
			newUser.setId(12345);
			newUser.setFirstname("Santhosh");
			newUser.setLastname("devendran");
			newUser.setEmail("sandyw@gmail.com");
			newUser.setPassword("");
			newUser.setActive(true);
			userService.create(newUser);
		});
		String expectedMessage = "Password cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	
@Test

	public void testCreateUserWithPasswordNull() {
		UserService userService = new UserService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			User newUser = new User();
			newUser.setId(12345);
			newUser.setFirstname("Santhosh");
			newUser.setLastname("devendran");
			newUser.setEmail("sandye@gmail.com");
			newUser.setPassword(null);
			newUser.setActive(true);
			userService.create(newUser);
		});
		String expectedMessage = "Password cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
@Test

	public void testCreateUserWithFirstnameEmpty() {
		UserService userService = new UserService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			User newUser = new User();
			newUser.setId(12345);
			newUser.setFirstname("");
			newUser.setLastname("devendran");
			newUser.setEmail("sandyr@gmail.com");
			newUser.setPassword("asdf@123");
			newUser.setActive(true);
			userService.create(newUser);
		});
		String expectedMessage = "Firstname cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	
	
	
	
@Test

	public void testCreateUserWithFirstnameNull() {
		UserService userService = new UserService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			User newUser = new User();
			newUser.setId(12345);
			newUser.setFirstname(null);
			newUser.setLastname("devendran");
			newUser.setEmail("sandyt@gmail.com");
			newUser.setPassword("asdf@123");
			newUser.setActive(true);
			userService.create(newUser);
		});
		String expectedMessage = "Firstname cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

}
