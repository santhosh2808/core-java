package in.santhoshdevendran.door_step.validation;

import in.santhoshdevendran.door_step.exception.ValidationException;
import in.santhoshdevendran.door_step.model.Task;
import in.santhoshdevendran.door_step.util.StringUtil;

public class TaskValidator {
	
	public static void validate(Task task) throws ValidationException {
		
		if(task == null) {
			throw new ValidationException("Invalid Task Input");
		}

		StringUtil.rejectInvalidString(task.getName(), "Taskname");
		StringUtil.rejectIfInvalidDate(task.getDueDate(), "Due Date");

}
}
