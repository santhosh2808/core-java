package in.santhoshdevendran.door_step.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.santhoshdevendran.door_step.model.Task;
import in.santhoshdevendran.door_step.service.TaskService;
import in.santhoshdevendran.door_step.util.ConnectionUtil;
import in.santhoshdevendran.door_step.Interface.TaskInterface;

public class TaskDAO implements TaskInterface {
	


	 public void create(Task newTask) {
	        Connection con = null;
	        PreparedStatement ps = null;

	        try {
	            String query = "INSERT INTO tasks (task_name, dueDate) VALUES (?, ?);";
	            con = ConnectionUtil.getConnection();
	            ps = con.prepareStatement(query);
	            ps.setString(1, newTask.getTaskName());
	            java.util.Date dueDateUtil = TaskService.convertDate(newTask.getDueDate());
	            java.sql.Date dueDateSql = new java.sql.Date(dueDateUtil.getTime());

	            ps.setDate(2, dueDateSql);

	            ps.executeUpdate();

	            System.out.println("Task Successfully Created :)");

	        } catch (SQLException e) {
	            	e.printStackTrace();
	                System.out.println(e.getMessage());
	                throw new RuntimeException(e);
	        } finally {
	            ConnectionUtil.close(con, ps);
	        }
	    }

	public void delete(int id) {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "UPDATE tasks SET is_active = false Where id = ? and is_active = true";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			
			ps.setInt(1,id);

			ps.executeUpdate();

			System.out.println("Tasks Successfully Deleted :)");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}

	}

	public Task findById(int taskId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Task newTask = null;

		try {
			String query = "SELECT * FROM tasks  WHERE is_active = 1 and id = ? ";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, taskId);
			rs = ps.executeQuery();
			

			if (rs.next()) {
				newTask = new Task();
				newTask.setTaskID(rs.getInt("id"));
				newTask.setTaskName(rs.getString("name"));
				LocalDate date = TaskService.convertSqlDateToLocalDate(rs.getDate("due_date"));
				newTask.setDueDate(date);
				newTask.setActive(rs.getBoolean("is_active"));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return newTask;
	}


	public void update(int id, Task t) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "UPDATE tasks SET task_name = ?,duedate = ? Where id = ? and is_active = 1";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, t.getTaskName());
			 java.util.Date dueDateUtil = TaskService.convertDate(t.getDueDate());
	            java.sql.Date dueDateSql = new java.sql.Date(dueDateUtil.getTime());

	            ps.setDate(2, dueDateSql);
			ps.setInt(3,id);

			ps.executeUpdate();

			System.out.println("Task Successfully Updated :)");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps);
		}

		
	}


	


	public int count() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;

		
		try {
			String query = "SELECT * FROM tasks Where is_active = 1";
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

	public List<Task> findAll() {

		//return TaskList.taskList;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Task> taskList = new ArrayList<Task>();
		try {
			String query = "SELECT * FROM tasks Where is_active = 1";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				Task newTask = new Task();
				newTask.setTaskID(rs.getInt("id"));
				newTask.setTaskName(rs.getString("name"));
				LocalDate date = TaskService.convertSqlDateToLocalDate(rs.getDate("due_date"));
				newTask.setDueDate(date);
				newTask.setActive(rs.getBoolean("is_active"));
				
				taskList.add(newTask);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return taskList;
	}
	
	public List<Task> findByDate(LocalDate date){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Task> taskList = new ArrayList<Task>();
		try {
			String query = "SELECT * FROM tasks Where is_active = 1 and duedate = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			 java.util.Date dueDateUtil = TaskService.convertDate(date);
	            java.sql.Date dueDateSql = new java.sql.Date(dueDateUtil.getTime());
			
			ps.setDate(1, dueDateSql);
			rs = ps.executeQuery();

			if (rs.next()) {
				Task newTask = new Task();
				newTask.setTaskID(rs.getInt("id"));
				newTask.setTaskName(rs.getString("name"));
				LocalDate lastDate = TaskService.convertSqlDateToLocalDate(rs.getDate("due_date"));
				newTask.setDueDate(lastDate);
				newTask.setActive(rs.getBoolean("is_active"));
				
				taskList.add(newTask);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return taskList;
		
		
	}
}