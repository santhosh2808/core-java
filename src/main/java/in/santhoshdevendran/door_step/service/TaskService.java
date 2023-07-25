package in.santhoshdevendran.door_step.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.time.format.DateTimeFormatter;

import in.santhoshdevendran.door_step.dao.TaskDAO;
import in.santhoshdevendran.door_step.model.Task;
import in.santhoshdevendran.door_step.validation.TaskValidator;
import in.santhoshdevendran.door_step.validation.UserValidator;
import in.santhoshdevendran.door_step.exception.ValidationException;
public class TaskService {
	TaskDAO taskDAO = new TaskDAO();

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

	public void create(Task task) throws Exception {

		TaskValidator.validate(task);

		taskDAO.create(task);

	}

	public void update(int id, Task updatedTask) throws ValidationException {

		TaskValidator.validate(updatedTask);

		taskDAO.update(id, updatedTask);

	}

	public void delete(int id) {

		taskDAO.delete(id);

	}

	public void findById(int id) {

		taskDAO.findById(id);

	}

	public int count() {
		return taskDAO.count();

	}

	public List<Task> getAll() {

		List<Task> TaskList = taskDAO.findAll();

		return TaskList;

	}


}
