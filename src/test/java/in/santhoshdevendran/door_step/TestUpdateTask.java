package in.santhoshdevendran.door_step;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import in.santhoshdevendran.door_step.service.TaskService;
import in.santhoshdevendran.door_step.model.Task;
public class TestUpdateTask {

	@Test
	public void testUpdateUserWithValidData(){
		TaskService taskService = new TaskService();

		Task newTask = new Task();

		String userInput = "27/07/2023";

		newTask.setTaskName("Open the Door");
		LocalDate convertedDate = TaskService.convertToDate(userInput);
		newTask.setDueDate(convertedDate);

		assertDoesNotThrow(() -> {
			taskService.update(1,newTask );
		});

	}
}
