package in.santhoshdevendran.door_step.service;

import in.santhoshdevendran.door_step.dao.UserDAO;
//import in.santhoshdevendran.door_step.dao.UserList;
import in.santhoshdevendran.door_step.model.User;
import in.santhoshdevendran.door_step.validation.UserValidator;

public class UserService {

	public User[] getAll() {

		UserDAO userdao = new UserDAO();

		User[] UserList = userdao.findAll();

		for (int i = 0; i < UserList.length; i++) {
			System.out.println(UserList[i]);
		}
		return UserList;

	}

	public void create(User newUser) throws Exception{
		
		UserValidator.validate(newUser);

		UserDAO userDAO = new UserDAO();
		userDAO.create(newUser);

	}
	
	public void update() {
		
	
		User updatenewUser = new User();
		updatenewUser.setId(56789);
		updatenewUser.setFirstname("Santhosh");
		updatenewUser.setLastname("Devendren");
		updatenewUser.setEmail("sandy@gmail.com");
		updatenewUser.setPassword("Azxcv@123");
		updatenewUser.setActive(true);
		
		UserDAO userDAO = new UserDAO();
		userDAO.update(updatenewUser);
	}
	
	public void delete() {

		UserDAO userDAO = new UserDAO();
	
		userDAO.delete(12345);
		
	}	
	public void findById() {

		UserDAO userDAO = new UserDAO();
	
		userDAO.findById(12345);
		
	}	
	
	public void findByEmail() {

		UserDAO userDAO = new UserDAO();
	
		userDAO.findByEmail("santhosh@gmail.com");
		
	}

}
