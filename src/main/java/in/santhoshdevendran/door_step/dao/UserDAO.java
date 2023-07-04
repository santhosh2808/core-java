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

	User[] userList2 = UserList.ListOfUsers;

	for (int i = 0; i < userList2.length; i++) {
		User user1 = userList2[i];

		if (user1 == null) {
			continue;
		}
		if (user1.getId() == id) {
			user1.setActive(false);

		}

	}

}



	public User findById(int userId) {
		User[] userList3 = UserList.ListOfUsers;
		User matchedUser = null;

		for (int i = 0; i < userList3.length; i++) {
			User user = userList3[i];
			if (user.getId() == userId) {
				matchedUser = user;
				break;
			}
		}
		System.out.println(matchedUser);
		return matchedUser;
	}
	
	
	public User findByEmail(String userEmail) {
		User[] userList4 = UserList.ListOfUsers;
		User userMatch = null;

		for (int i = 0; i < userList4.length; i++) {
			User user = userList4[i];
			
			if(user==null) {
				System.out.println("User Details is Not There");
				break;
			}
			if (user.getEmail().equals(userEmail)) {
				userMatch = user;
				break;
			}
		}
		System.out.println(userMatch);
		return userMatch;
	}
	
	

}
