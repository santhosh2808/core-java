package in.santhoshdevendran.door_step.dao;

import in.santhoshdevendran.door_step.model.Task;


public class TaskDAO {

	public Task[] findAllTask() {
		Task[] taskList = TaskList.ListOfTask;
		return taskList;

	}

	public void create(Task newTask) {

		Task[] arr = TaskList.ListOfTask;

		for (int i = 0; i < arr.length; i++) {

			Task task = arr[i];
			if (task == null) {
				arr[i] = newTask;
				break;
			}

		}

	}
	
	
	public void update(Task updatetask) {
		
		Task[] arr = TaskList.ListOfTask;
		
		for (int i=0;i<arr.length;i++) {
			Task task = arr[i];
			
			if (task == null) {
		continue;
			}
			if(task.getId() == updatetask.getId()) {
				task.setName(updatetask.getName());
				task.setDueDate(updatetask.getDueDate());
			}
		}
		
	}


	public void delete(int id) {

		Task[] arr = TaskList.ListOfTask;

		for (int i = 0; i < arr.length; i++) {
			Task task = arr[i];

			if (task == null) {
				continue;
			}
			if (task.getId() == id) {
				task.setActive(false);

			}

		}

	}



		public Task findById(int taskId) {
			Task[] arr = TaskList.ListOfTask;
			Task matchedTask = null;

			for (int i = 0; i < arr.length; i++) {
				Task task = arr[i];
				if (task.getId() == taskId) {
					matchedTask = task;
					break;
				}
			}
			System.out.println(matchedTask);
			return matchedTask;
		}

}
