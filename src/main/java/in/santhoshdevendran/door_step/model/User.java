package in.santhoshdevendran.door_step.model;

public class User {

	String firstname;
	String lastname;
	String email;
	String password;
	int id;
	boolean isActive = true ;

	
	public String getFirstname() {
		return firstname;
	}

	public  void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	

	@Override
	public String toString() {
		return "User Detils  Name = " + firstname +" "+ lastname + ", Email = " + email + ", Password = " + password
				+ ", User id = " + id + ", isActive = " + isActive;
	}
	

	public String fullName() {
		return firstname.concat(" ").concat(lastname);
	}

}
