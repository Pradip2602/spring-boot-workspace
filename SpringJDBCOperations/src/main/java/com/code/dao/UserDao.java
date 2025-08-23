package com.code.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.code.entity.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// ----------- Insert User into database ------------//

	public boolean insertUser(User user) {
		boolean status = false;
		try {
			String INSERT_QUERY = "INSERT INTO userdata (user_name,email,gender,mobile_no) VALUES (?,?,?,?)";
			int insertCount = jdbcTemplate.update(INSERT_QUERY, user.getName(), user.getEmail(), user.getGender(),
					user.getMobileNo());

			if (insertCount > 0) {
				status = true;
			} else {
				status = false;
			}

		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;
	}

	// ----------- Insert User into database ------------//

	public boolean updateUser(User user) {
		boolean updateStatus = false;

		try {

//			String UPDATE_QUERY = "update into userdata SET usernamme=?,email=?,gender=?,mobile_no=?";
			String UPDATE_QUERY = "update userdata SET user_name=?,email=?,gender=? where mobile_no=?";

			int updatedRows = jdbcTemplate.update(UPDATE_QUERY, user.getName(), user.getEmail(), user.getGender(),
					user.getMobileNo());

			if (updatedRows > 0) {

				System.out.println("row updated block");
				updateStatus = true;

			} else {
				System.out.println("row updated else block");
				updateStatus = false;
			}

		} catch (Exception e) {
			System.out.println("update catch block");
			updateStatus = false;
			e.printStackTrace();
		}
		return updateStatus;
	}

	// -----------DELETE QUERY OPERATION---------------//

	public boolean deleterUser(String mobileNo) {
		boolean deleteStatus = false;

		try {

			String DELETE_QUERY = "delete from userdata where mobile_no = ? ";

			int deletedRows = jdbcTemplate.update(DELETE_QUERY, mobileNo);

			if (deletedRows > 0) {

				deleteStatus = true;

			} else {
				deleteStatus = false;
			}

		} catch (Exception e) {
			deleteStatus = false;
			e.printStackTrace();
		}

		return deleteStatus;
	}

	// -----------GET USER BY MOBILENO OPERATION---------------//

	public User getUserByMobileNo(String mobileNo) {
		User user = null;
		try {

			String GETUSER_QUERY = "select * from userdata WHERE mobile_no= ?";

			user = jdbcTemplate.queryForObject(GETUSER_QUERY, new UserRowMapper(), mobileNo);

			if (user != null) {

				System.out.println(user);

			}

		} catch (Exception e) {
			System.out.println("No user found with given mobile number");
		}

		return user;
	}

	// -----------GET ALL USERS BY MOBILENO OPERATION---------------//

	public List<User> getAllUser() {

		List<User> userList = null;

		try {
			String GETUSER_QUERY = "select * from userdata";

			userList = jdbcTemplate.query(GETUSER_QUERY, new UserRowMapper());

			if (userList != null) {

				System.out.println("//-----------------USER LIST ------------------//");
				displayUser(userList);

			}
		} catch (Exception e) {
			System.out.println("No user found with given mobile number");
		}

		return userList;
	}

	private static void displayUser(List<User> userList) {

		ListIterator<User> itr = userList.listIterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	public static final class UserRowMapper implements org.springframework.jdbc.core.RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {

			User user = new User();
			user.setName(rs.getString("user_name"));
			user.setEmail(rs.getString("email"));
			user.setGender(rs.getString("gender"));
			user.setMobileNo(rs.getString("mobile_no"));

			return user;
		}

	}
}
