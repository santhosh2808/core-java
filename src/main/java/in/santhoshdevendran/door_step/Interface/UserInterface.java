package in.santhoshdevendran.door_step.Interface;

import in.santhoshdevendran.door_step.model.User;

public interface UserInterface extends Base<User>{
	
	public abstract User findByEmail(String email);
	
	public abstract int count();
	
	

}
