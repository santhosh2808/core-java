package in.santhoshdevendran.door_step.dao;

import in.santhoshdevendran.door_step.model.User;

public class UserDAO {
	
	public User[] findAll() {
		User[] userList = UserList.ListOfUsers;	
		return userList;
	}
	

public void create(User newUser) {
		
		UserList.ListOfUsers[0] = newUser;
	}
}
