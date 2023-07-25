package in.santhoshdevendran.door_step.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.santhoshdevendran.door_step.model.Task;
import in.santhoshdevendran.door_step.Interface.TaskInterface;

public class TaskDAO implements TaskInterface {

	public void create(Task newTask) {

		List<Task> taskList1 = TaskList.taskList;

		boolean taskExists = false;

		Iterator<Task> iterator = taskList1.iterator();
		while (iterator.hasNext()) {
			Task existingTask = iterator.next();
			if (existingTask == null) {
				iterator.remove();
				taskList1.add(newTask);
				taskExists = true;
				break;
			}
		}

		if (!taskExists) {
			taskList1.add(newTask);
		}

	}

	public void delete(int id) {

		List<Task> taskList2 = TaskList.taskList;

		Iterator<Task> iterator = taskList2.iterator();
		while (iterator.hasNext()) {
			Task existingTask = iterator.next();
			if (existingTask.getTaskID() == id) {
				existingTask.setActive(false);
				break;
			}
		}

	}

	public Task findById(int taskId) {
		List<Task> taskList4 = TaskList.taskList;
		Task matchedTask = null;

		for (Task newTask : taskList4) {
			Task task = newTask;
			if (task.getTaskID() == taskId) {
				matchedTask = task;
				break;
			}
		}
		System.out.println(matchedTask);
		return matchedTask;
	}

	@Override
	public void update(int id, Task t) {
		List<Task> taskList2 = TaskList.taskList;
		Iterator<Task> iterator = taskList2.iterator();
		while (iterator.hasNext()) {
			Task existingTask = iterator.next();
			if (existingTask.getTaskID() == id) {
				iterator.remove();
				taskList2.add(t);
				break;
			}
		}

	}

	@Override
	public int count() {

		int count = 0;
		List<Task> taskList2 = TaskList.taskList;
		Iterator<Task> iterator = taskList2.iterator();
		while (iterator.hasNext()) {
			Task existingTask = iterator.next();
			if (existingTask != null) {

				count++;
			}
		}
		return count;
	}

	public List<Task> findAll() {

		return TaskList.taskList;
	}

}