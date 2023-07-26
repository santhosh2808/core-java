package in.santhoshdevendran.door_step;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import in.santhoshdevendran.door_step.service.TaskService;

public class TestDeleteTask {

	@Test
	public void testUpdateUserWithValidData(){
		TaskService taskService = new TaskService();

		assertDoesNotThrow(() -> {
			taskService.delete(1);
		});

	}
}
