package in.santhoshdevendran.door_step;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.santhoshdevendran.door_step.model.User;
import in.santhoshdevendran.door_step.service.UserService;

public class TestCreateUser {

	@Test
	public void testCreateUserWithValidDataInput() {
		UserService userService = new UserService();

		User newUser = new User();
		newUser.setId(56789);
		newUser.setFirstname("Santhosh");
		newUser.setLastname("Devendren");
		newUser.setEmail("sandy@gmail.com");
		newUser.setPassword("Azxcv@123");
		newUser.setActive(true);

		assertDoesNotThrow(() -> {
			userService.create(newUser);

		});

	}

	@Test

	public void testCreateUserWithInvalidData() {
		UserService userService = new UserService();
		Exception exception = assertThrows(Exception.class, () -> {
			userService.create(null);
		});
		String expectedMessage = "invalid user input";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test

	public void testCreateUserWithEmailNull() {
		UserService userService = new UserService();
		Exception exception = assertThrows(Exception.class, () -> {

			User newUser = new User();
			newUser.setId(12345);
			newUser.setFirstname("Santhosh");
			newUser.setLastname("devendran");
			newUser.setEmail(null);
			newUser.setPassword("Asdf@123");
			newUser.setActive(true);

			userService.create(newUser);
		});
		String expectedMessage = "Email Cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test

	public void testCreateUserWithEmailEmpty() {
		UserService userService = new UserService();
		Exception exception = assertThrows(Exception.class, () -> {

			User newUser = new User();
			newUser.setId(12345);
			newUser.setFirstname("Santhosh");
			newUser.setLastname("devendran");
			newUser.setEmail("");
			newUser.setPassword("Asdf@123");
			newUser.setActive(true);

			userService.create(newUser);
		});
		String expectedMessage = "Email Cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

}
