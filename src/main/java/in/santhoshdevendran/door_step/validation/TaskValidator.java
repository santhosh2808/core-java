package in.santhoshdevendran.door_step.validation;

import in.santhoshdevendran.door_step.exception.ValidationException;
import in.santhoshdevendran.door_step.model.Task;
import in.santhoshdevendran.door_step.util.StringUtil;

public class TaskValidator {
public static void validate(Task newTask) throws ValidationException {
		
		if(newTask == null) {
			throw new ValidationException("Invalid Task Input");
		}

		StringUtil.rejectIfInvalidString(newTask.getTaskName(), "Taskname");
		StringUtil.rejectIfInvalidDate(newTask.getDueDate(), "Due Date");
		
		
		

	}

}
