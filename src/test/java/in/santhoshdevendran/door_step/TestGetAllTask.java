package in.santhoshdevendran.door_step;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import in.santhoshdevendran.door_step.model.Task;
import in.santhoshdevendran.door_step.service.TaskService;

public class TestGetAllTask {

	
	@Test
	public void findById() {
		TaskService taskService = new TaskService();
		
		Task finalTask = taskService.findById(1);
		System.out.println(finalTask);
		
	}
	@Test
	public void getAllTasks() {
		TaskService taskService = new TaskService();
		System.out.println(taskService.getAll());

	}

	@Test
	public void findByDate() {
		TaskService taskService = new TaskService();
		String userInput2 = "27/07/2023";
		LocalDate convertedDate2 = TaskService.convertToDate(userInput2);
		List<Task> finalTask = taskService.getByDate(convertedDate2);
		System.out.println(finalTask);
		
	}
	@Test
	public void counting() {
		TaskService taskService = new TaskService();
		
		
		System.out.println(taskService.count());
		
	}
}
