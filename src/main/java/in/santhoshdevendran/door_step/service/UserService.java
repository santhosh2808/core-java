package in.santhoshdevendran.door_step.service;

import in.santhoshdevendran.door_step.dao.UserDAO;
import in.santhoshdevendran.door_step.model.User;

public class UserService {

	public User[] getAll() {

		UserDAO userdao = new UserDAO();

		User[] UserList = userdao.findAll();

		System.out.println(UserList[0]);

		return UserList;

	}

	public void create() {

		User newUser = new User();
		newUser.setId(56789);
		newUser.setFirstname("Santhosh");
		newUser.setLastname("Devendren");
		newUser.setEmail("sandy@gmail.com");
		newUser.setPassword("Azxcv@123");
		newUser.setActive(true);

		UserDAO userDAO = new UserDAO();
		userDAO.create(newUser);
	}

}
