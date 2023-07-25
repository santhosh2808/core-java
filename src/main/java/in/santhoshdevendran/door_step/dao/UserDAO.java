package in.santhoshdevendran.door_step.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import in.santhoshdevendran.door_step.Interface.UserInterface;
import in.santhoshdevendran.door_step.model.User;
import in.santhoshdevendran.door_step.util.ConnectionUtil;

public class UserDAO implements UserInterface {

	@Override
	public void create(User user) {

		
		Connection con = null;
		PreparedStatement ps = null;
		

		try {
			String query = "INSERT INTO users (first_name, last_name, email, password) VALUES (?, ?, ?, ?);";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1,user.getFirstname() );
			ps.setString(2,user.getLastname() );
			ps.setString(3,user.getEmail() );
			ps.setString(4,user.getPassword() );
			ps.executeUpdate();
	
			

		}catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(con, ps);
		}

	
	}

	public User findById(int userId) {
		Connection con = null;
		PreparedStatement ps = null;
		User user = null;
		ResultSet rs = null;

		try {
			String query = "SELECT * FROM users WHERE is_active=1 AND id = ? ";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);			
			ps.setInt(1, userId);
			rs = ps.executeQuery();
	

			if (rs.next()) {

				user = new User();

				user.setId(rs.getInt("id"));
				user.setFirstname(rs.getString("first_name"));
				user.setLastname(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setActive(rs.getBoolean("is_active"));
				user.setPassword(rs.getString("password"));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return user;

	}

	public User findByEmail(String userEmail) {
		List<User> userList = UserList.ListOfUsers;
		User userMatch = null;

		for (User newUser : userList) {
			User user = newUser;

			if (user == null) {
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

	@Override
	public void delete(int newId) {
		List<User> userList2 = UserList.ListOfUsers;
		for (User newUser : userList2) {
			User user1 = newUser;

			if (user1 == null) {
				continue;
			}
			if (user1.getId() == newId) {
				user1.setActive(false);

			}

		}

	}

	@Override
	public int count() {
		List<User> userList3 = UserList.ListOfUsers;
		int count = 0;
		for (User newUser : userList3) {
			User user1 = newUser;
			count++;
		}
		return count;
	}

	@Override
	public void update(int id, User newUser) {
		List<User> userList = UserList.ListOfUsers;

		Iterator<User> iterator = userList.iterator();
		while (iterator.hasNext()) {
			User existingUser = iterator.next();
			if (existingUser.getId() == id) {
				iterator.remove();
				userList.add(newUser);
				break;
			}
		}
	}

	public List<User> findAll() throws RuntimeException {
		// return UserList.ListOfUsers;
		Connection con = null;
		PreparedStatement ps = null;
		List<User> userList = new ArrayList<>();
		ResultSet rs = null;

		try {
			String query = "SELECT * FROM users WHERE is_active = 1";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);

			rs = ps.executeQuery(query);

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstname(rs.getString("first_name"));
				user.setLastname(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setActive(rs.getBoolean("is_active"));
				user.setPassword(rs.getString("password"));

				userList.add(user);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return userList;

	}

}
