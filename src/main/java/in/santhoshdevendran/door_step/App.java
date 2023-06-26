package in.santhoshdevendran.door_step;


import in.santhoshdevendran.door_step.service.UserService;


public class App {

	 public static void main(String[] args) {
		 UserService userService = new UserService();
		 userService.create();
		 userService.getAll();
		 

	 }

}
