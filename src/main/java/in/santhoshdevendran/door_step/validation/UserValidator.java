package in.santhoshdevendran.door_step.validation;



import in.santhoshdevendran.door_step.exception.ValidationException;
import in.santhoshdevendran.door_step.model.User;
import in.santhoshdevendran.door_step.util.StringUtil;

public class UserValidator {

	public static void validate(User newUser) throws ValidationException {

		if (newUser == null) {
			throw new ValidationException("invalid user input");
		}

		StringUtil.rejectIfInvalidString(newUser.getEmail(), "Email");
		StringUtil.rejectIfInvalidString(newUser.getPassword(), "Password");
		StringUtil.rejectIfInvalidString(newUser.getFirstname(), "Firstname");

	}

}
