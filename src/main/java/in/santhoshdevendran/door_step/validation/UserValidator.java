package in.santhoshdevendran.door_step.validation;



import in.santhoshdevendran.door_step.exception.ValidationException;
import in.santhoshdevendran.door_step.model.User;
import in.santhoshdevendran.door_step.util.StringUtil;

public class UserValidator {

	public static void validate(User user) throws ValidationException {
	
		if(user==null) {
			throw new ValidationException("invalid user input");
		}
		
		StringUtil.rejectInvalidString(user.getEmail(), "email");
		StringUtil.rejectInvalidString(user.getPassword(), "Password");
		StringUtil.rejectInvalidString(user.getFirstname(), "Firstname");
		
	
		
		
//		if (user.getEmail()==null || "".equals(user.getEmail().trim())) {
//			throw new ValidationException("email cannot be null or empty");
//		}
//		if (user.getPassword()==null || "".equals(user.getPassword().trim())) {
//			throw new ValidationException("password cannot be null or empty");
//		}
//		if (user.getFirstname()==null || "".equals(user.getFirstname().trim())) {
//			throw new ValidationException("Firstname cannot be null or empty");
//		}
//		if (user.getEmail()==null || "".equals(user.getEmail().trim())) {
//			throw new ValidationException("email cannot be null or empty");
//		}
	}
	
}
