package in.santhoshdevendran.door_step.model;

public class User extends UserEntity {

	public User(int id, String firstName, String lastName, String email, String password, boolean isActive) {

		super.setId(id);
		super.setActive(isActive);
		super.setEmail(email);
		super.setFirstname(firstName);
		super.setLastname(lastName);
		super.setPassword(password);
		
	}
	public User() {
		
	}

	

}
