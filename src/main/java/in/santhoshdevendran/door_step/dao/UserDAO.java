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
	
			

		} catch (SQLException e) {
			 e.printStackTrace();
			if (e.getMessage().contains("Duplicate entry")) {
				throw new RuntimeException("Duplicate constraint");
			} else {
				System.out.println(e.getMessage());
				throw new RuntimeException(e);
			}
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
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		User user = null;

		try {
			String query = "SELECT * FROM users  WHERE is_active = 1 and email = ? ";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, userEmail);
			rs = ps.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstname(rs.getString("first_name"));
				user.setLastname(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setActive(rs.getBoolean("is_active"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return user;
	}

	@Override
	public void delete(int newId) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "UPDATE users SET is_active = false Where id = ? and is_active = true ";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			
			ps.setInt(1,newId);

			ps.executeUpdate();

			System.out.println("User Successfully Deleted :)");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps);
		}


	}

	@Override
	public int count() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;

		List<User> userList = new ArrayList<User>();
		try {
			String query = "SELECT * FROM users Where is_active = 1";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return count;
	}

	@Override
	public void update(int id, User newUser) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "UPDATE users SET first_name = ?,last_name = ? Where id = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, newUser.getFirstname());
			ps.setString(2, newUser.getLastname());
			ps.setInt(3,id);

			ps.executeUpdate();

			System.out.println("User Successfully Updated :)");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps);
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
