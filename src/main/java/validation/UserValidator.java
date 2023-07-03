package validation;

import in.santhoshdevendran.door_step.model.User;

public class UserValidator {

	public static void validate(User user) throws Exception {
		if(user==null) {
			throw new Exception("invalid user input");
		}
		
		if (user.getEmail()==null || "".equals(user.getEmail().trim())) {
			throw new Exception("email cannot be null or empty");
		}
		if (user.getPassword()==null || "".equals(user.getPassword().trim())) {
			throw new Exception("password cannot be null or empty");
		}
		if (user.getFirstname()==null || "".equals(user.getFirstname().trim())) {
			throw new Exception("Firstname cannot be null or empty");
		}
	}
	
}
