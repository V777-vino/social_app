package com.kvcet.socialapp.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kvcet.socialapp.dao.UserDao;
import com.kvcet.socialapp.model.User;
import com.kvcet.socialapp.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {

	public void insertUser(User user) {
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO USER(user_name,user_email,mobile_no,PASSWORD,gender,dob)VALUES(?,?,?,?,?,?);");
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getUserEmail());
			statement.setString(3, user.getMobileNo().toString());
			statement.setString(4, user.getPassword());
			statement.setString(5, user.getGender().toString());
			statement.setString(6, user.getDob().toString());

			if (statement.executeUpdate() == 1) {
				System.out.println("User details added");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void deleteUser(int userId) {
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM USER WHERE user_id = ?");
			statement.setInt(1, userId);

			if (statement.executeUpdate() == 1) {
				System.out.println("The user detail deleted");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public void updatePassword(String password, int userId) {
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement statement = connection.prepareStatement("UPDATE USER SET PASSWORD =? WHERE user_id =?");
			statement.setString(1, password);
			statement.setInt(2, userId);
			if (statement.executeUpdate() == 1) {
				System.out.println("The user password updated");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public int login(String email, String password) throws Exception {
		String name1 = null;
		String email1 = null;
		String password1 = null;

		Connection connection = ConnectionUtil.getConnection();
		Statement statement = connection.createStatement();
		String query = "SELECT user_name,user_email,PASSWORD FROM USER WHERE user_email = '" + email
				+ "' AND PASSWORD ='" + password + "'";
		ResultSet rs = statement.executeQuery(query);
		while (rs.next()) {
			name1 = rs.getString("user_name");
			email1 = rs.getString("user_email");
			password1 = rs.getString("password");
		}
		int result = 0;

		if (name1 == null) {
			result = 0;

		} else if (email1 == null) {
			result = 0;
		} else if (password1.equals(password)) {
			result = 1;
		} else {
			result = -1;
		}
		return result;

	}
}
