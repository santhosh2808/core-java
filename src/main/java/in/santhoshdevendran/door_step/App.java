package in.santhoshdevendran.door_step;

import java.time.LocalDate;

import in.santhoshdevendran.door_step.model.User;
import in.santhoshdevendran.door_step.model.Task;
import in.santhoshdevendran.door_step.service.TaskService;
import in.santhoshdevendran.door_step.service.UserService;

public class App {

	public static void main(String[] args) {

		UserService newService = new UserService();

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("//////////////////////   User   ////////////////////////////////");

		try {
			User newUser = new User(101, "santhosh", "devendran", "sandy@gmail.com", "Asdf@123", true);
			User newUser1 = new User(102, "Vignesh", "Ramachandran", "srvignesh@google.com", "SRV@123", true);
			User newUser2 = new User(103, "Maruthan", "Alagar", "amaruthan@apple.com", "AsdfGhjkl", true);

			// User Creation
			System.out.print("User Creation   = ");
			newService.create(newUser);
			System.out.println(newService.getAll());

			// Update User
			System.out.print("User Update   =  ");
			newService.update(101, newUser1);
			System.out.println(newService.getAll());

			// Delete User
			System.out.print("User Delete   =  ");
			newService.delete(102);
			System.out.println(newService.getAll());

			// Find By Id
			System.out.print("User Find By Id   =  ");
			newService.create(newUser2);
			newService.findById(103);

			// Find By Email
			System.out.print("User Find By Email   =  ");
			newService.findByEmail("amaruthan@apple.com");

			// Get All Method
			System.out.print("Get All Method  =  ");
			newService.create(newUser);
			System.out.println(newService.getAll());

			// Users Count
			System.out.print("Users Count  =  ");
			System.out.println(newService.count());

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("//////////////////////   Task   ////////////////////////////////");

		TaskService taskService = new TaskService();

		try {
			String userInput = "29/07/2023";
			LocalDate convertedDate = TaskService.convertToDate(userInput);
			String userInput1 = "25/08/2023";
			LocalDate convertedDate1 = TaskService.convertToDate(userInput1);
			String userInput2 = "27/09/2023";
			LocalDate convertedDate2 = TaskService.convertToDate(userInput2);

			Task newTask1 = new Task(1, "Open the Door", convertedDate, true);
			Task newTask2 = new Task(2, "Close the Door", convertedDate1, true);
			Task newTask3 = new Task(3, "Go! Eat Sleep Code :)", convertedDate2, true);

			// Task Creation
			System.out.print("Task Creation   = ");
			taskService.create(newTask1);
			System.out.println(taskService.getAll());

			// Task Update
			System.out.print("Task Update   =  ");
			taskService.update(1, newTask2);
			System.out.println(taskService.getAll());

			// Delete Task
			System.out.print("Task Delete   =  ");
			taskService.delete(2);
			System.out.println(taskService.getAll());

			// Find By Id
			System.out.print("Task Find By Id   =  ");
			taskService.create(newTask1);
			taskService.findById(1);

			// Get all Method
			System.out.print("Get All Method  =  ");
			taskService.create(newTask3);
			System.out.println(taskService.getAll());

			// Task Count
			System.out.print("Task Count  =  ");
			System.out.println(taskService.count());

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
