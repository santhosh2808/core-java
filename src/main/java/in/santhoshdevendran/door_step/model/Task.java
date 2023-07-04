package in.santhoshdevendran.door_step.model;

import java.time.LocalDate;

public class Task {
	
	String name;
	int     id;
	LocalDate dueDate;
	boolean isActive;
	
	public String getName() {
		return name;
	}

	public  void setName(String name) {
		this.name = name;
	}
	
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
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
		return "task Detils  Name = "+ name +", task id = " + id + ", isActive = " + isActive +", Duedate : "+dueDate;
	}
}
