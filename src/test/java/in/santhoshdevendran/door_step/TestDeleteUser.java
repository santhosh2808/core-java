package in.santhoshdevendran.door_step;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import in.santhoshdevendran.door_step.service.UserService;

import org.junit.jupiter.api.Test;

public class TestDeleteUser {

	@Test
	public void testUpdateUserWithValidData(){
		UserService userService = new UserService();

		assertDoesNotThrow(() -> {
			userService.delete(2);
		});

	}
}
