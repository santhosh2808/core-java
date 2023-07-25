package in.santhoshdevendran.door_step.model;

public abstract class UserEntity implements Comparable<UserEntity> {

	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private int id;
	private boolean isActive;
	

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
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
		return "User Detils Name : " + this.getFirstname() + " " + this.getLastname() + ", Email : " + this.getEmail() + ", Password : " + this.getPassword()
				+ ", User id : " + this.getId()+ ", isActive : " + this.isActive();
	}

	public int compareTo(UserEntity o) {
		if (this.getId() == o.getId()) {
			return 0;
		} else {
			if (this.getId() < (o.getId())) {
				return -1;
			} else {
				return 1;
			}
		}
	}

	public String fullName() {
		return firstname.concat(" ").concat(lastname);
	}

}
