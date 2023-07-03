package in.santhoshdevendran.door_step;

import in.santhoshdevendran.door_step.model.User;
import in.santhoshdevendran.door_step.service.UserService;

public class App {

	public static void main(String[] args) {
		try {
			UserService userService = new UserService();

			User newUser = new User();
			newUser.setId(56789);
			newUser.setFirstname("Santhosh");
			newUser.setLastname("Devendren");
			newUser.setEmail("sandy@gmail.com");
			newUser.setPassword("Azxcv@123");
			newUser.setActive(true);

			userService.create(newUser);

			userService.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
