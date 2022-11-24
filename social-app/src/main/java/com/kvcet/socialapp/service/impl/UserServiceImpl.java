package com.kvcet.socialapp.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kvcet.socialapp.model.User;
import com.kvcet.socialapp.service.UserService;
import com.kvcet.socialapp.util.ConnectionUtil;

public class UserServiceImpl implements UserService {
	public int userIdCheck(int userId) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		Statement statement = connection.createStatement();
		String query = null;
		int uId = 0;
		int result = 0;
		try {
			query = "select user_id,password from user where user_id='" + userId + "'";
			ResultSet rs = statement.executeQuery(query);
			if (rs.next()) {
				uId = rs.getInt("user_id");
			}
			if (uId == userId) {
				result = result + 1;
			}

		} catch (SQLException e) {
			throw new Exception("This user not registered");
		}
		return result;

	}

	public int userDetailsCheck(User user) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		Statement statement = connection.createStatement();
		String query = null;
		String email = null;
		int result = 0;

		try {
			query = "SELECT user_email,PASSWORD FROM USER WHERE user_email = '" + user.getUserEmail() + "'";

			ResultSet rs = statement.executeQuery(query);
			if (rs.next()) {
				email = rs.getString("user_email");
			} else {
				result++;
			}
			if (email != null) {
				throw new Exception("This user already regitered");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public int registerUserValidation(User user) throws Exception {

		if (user.getUserName().isBlank() || user.getUserName().isBlank()) {
			throw new Exception("Name shoul'nt be empty or blank");
		}
		if (user.getMobileNo().toString().length() != 10) {
			throw new Exception("Enter a valid mobile number");
		}
		if (!user.getUserEmail().contains("@gmail.com")) {
			throw new Exception("Enter a valid mail");
		}
		if (!(user.getPassword().length() >= 5)) {
			throw new Exception("Enter a valid password");
		}
		if (user.getGender() != 'M' && user.getGender() != 'F') {
			throw new Exception("Enter 'M' or 'F'");
		}
		return 1;
	}

	public int updatePassword(String password, int userId) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		Statement statement = connection.createStatement();
		String query = null;
		int uId = 0;
		int result = 0;
		try {
			query = "select user_id,password from user where user_id='" + userId + "'";
			ResultSet rs = statement.executeQuery(query);
			if (rs.next()) {
				uId = rs.getInt("user_id");
			}
			if (uId == userId) {
				result = result + 1;
			}

		} catch (Exception e) {
			throw new Exception("This user not registered");
		}
		return result;

	}

}
