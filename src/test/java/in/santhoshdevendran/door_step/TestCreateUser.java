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
	public void testCreateUserWithinValidDataInput() {
		UserService userService = new UserService();

		Exception exception = assertThrows(Exception.class, () -> {
			userService.create(null);
		});
		String exceptedMessage = "invalid user input";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));

	}

}
