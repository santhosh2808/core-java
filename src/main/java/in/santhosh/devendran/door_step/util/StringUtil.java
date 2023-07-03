package in.santhosh.devendran.door_step.util;

import in.santhoshdevendran.door_step.exception.ValidationException;

public class StringUtil {

	public static void rejectInvalidString(String input, String inputName) throws ValidationException {
		if(input == null|| "".equals(input.trim())) {
			throw new ValidationException(inputName.concat(" cannot be null or empty"));
		}	
	}
	
	public static boolean isValidString(String input) {
		if(input == null|| "".equals(input.trim())) {
			return false;
		}
		return true;
	}
	public static boolean isInvalidString(String input) {
		if(input == null|| "".equals(input.trim())) {
			return true;
		}
		return false;
	}
}
