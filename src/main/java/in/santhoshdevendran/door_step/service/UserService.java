package in.santhoshdevendran.door_step.service;

import java.util.List;

import in.santhoshdevendran.door_step.dao.UserDAO;
import in.santhoshdevendran.door_step.exception.ValidationException;
import in.santhoshdevendran.door_step.model.User;
import in.santhoshdevendran.door_step.validation.UserValidator;

public class UserService {
	UserDAO userdao = new UserDAO();

	public void create(User user) throws Exception {

		UserValidator.validate(user);

		userdao.create(user);

	}

	public int count() {
		return userdao.count();

	}

	public void update(int newId, User newUser) throws ValidationException {

		UserValidator.validate(newUser);

		userdao.update(newId, newUser);

	}
	
	public void delete(int Id) {

		userdao.delete(Id);

	}

	public User findById(int newId) {

		return userdao.findById(newId);

	}

	public void findByEmail(String Email) {

		userdao.findByEmail(Email);

	}

	public List<User> getAll() {

		return userdao.findAll();

	}

}