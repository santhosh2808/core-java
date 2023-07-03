package in.santhoshdevendran.door_step.dao;

import in.santhoshdevendran.door_step.model.User;

public class UserDAO {
	
	public User[] findAll() {
		User[] userList = UserList.ListOfUsers;	
		return userList;
	}
	/**
	 * 
	 * @param newUser
	 */

public void create(User newUser) {
		
		
	User[]  arr = UserList.ListOfUsers;
		
		for (int i=0;i<arr.length;i++) {
			
			User user=arr[i];
			if (user == null) {
				arr[i]=newUser;
				break;
			}
			
		}
	}

public void update(User UpdateUser) {
	
	User[]  arr = UserList.ListOfUsers;
	
	for (int i=0;i<arr.length;i++) {
		User user=arr[i];
		
		if (user == null) {
	continue;
		}
		if(user.getId() == UpdateUser.getId()) {
			user.setFirstname(UpdateUser.getFirstname());
			user.setLastname(UpdateUser.getLastname());
		}
	}
	
}

public void delete(int id) {
	User[]  arr = UserList.ListOfUsers;
	
	for(int i=0;i<arr.length;i++) {
		
		User user=arr[i];
		if (user == null) {
			continue;
				}
		if(user.getId() == id) {
					
			user.setActive(false);		
				
	}
	}
	
}
	

}
