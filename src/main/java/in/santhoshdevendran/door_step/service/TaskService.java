package in.santhoshdevendran.door_step.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import in.santhoshdevendran.door_step.dao.TaskDAO;
import in.santhoshdevendran.door_step.model.Task;
import in.santhoshdevendran.door_step.validation.TaskValidator;
import in.santhoshdevendran.door_step.validation.UserValidator;

public class TaskService {

	
	public Task[] getAll() {

		TaskDAO taskdao = new TaskDAO();

		Task[] taskList = taskdao.findAllTask();

		for (int i = 0; i < taskList.length; i++) {
			System.out.println(taskList[i]);
		}
		return taskList;

	}
	
	public static LocalDate convertToDate(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {
			LocalDate localDate = LocalDate.parse(dateString, formatter);
			return localDate;
		} catch (Exception e) {
			System.out.println("Invalid date format!");
			return null;
		}
	}


	public void create(Task newTask) throws Exception{
		
		TaskValidator.validate(newTask);

		TaskDAO taskdao = new TaskDAO();
		taskdao.create(newTask);

	}
	
	public void update() {
		
	
		Task updatenewTask = new Task();
		updatenewTask.setId(56789);
		updatenewTask.setName("work");
		updatenewTask.setDueDate(null);
		updatenewTask.setActive(true);
		
		TaskDAO taskdao = new TaskDAO();
		taskdao.update(updatenewTask);
	}
	
	public void delete() {

		TaskDAO taskdao = new TaskDAO();
	
		taskdao.delete(12345);
		
	}	
	public void findById() {

		TaskDAO taskdao = new TaskDAO();
	
		taskdao.findById(12345);
		
	}



}
