package com.kvcet.socialapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;

import com.kvcet.socialapp.dao.PostDao;
import com.kvcet.socialapp.model.Post;
import com.kvcet.socialapp.model.View;
import com.kvcet.socialapp.service.PostService;
import com.kvcet.socialapp.service.impl.PostServiceImpl;
import com.kvcet.socialapp.util.ConnectionUtil;

public class PostDaoImpl implements PostDao {

	@Override
	public void postMessage(Post post) {
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO post(user_id,message) VALUES (?,?)");
			statement.setInt(1, post.getUserId());
			statement.setString(2, post.getMessage());

			if (statement.executeUpdate() == 1) {
				System.out.println("Message posted sucessfully");
			}
		} catch (Exception e) {

			System.err.println(e.getMessage());
		}

	}

	@Override
	public ArrayList<View> viewAllPost() {
		ArrayList<View> al = new ArrayList();
		try {

			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"SELECT post.user_id,user.user_name,post.message,user.created_date,post.posted_date FROM USER INNER JOIN post ON user.user_id = post.user_id");
			ResultSet rs = statement.executeQuery();
			View view = null;

			while (rs.next()) {
				view = new View();
				view.setUserId(rs.getInt("user_id"));
				view.setUserName(rs.getString("user_name"));
				view.setMessage(rs.getString("message"));

				view.setCreatedDate(Timestamp.valueOf(rs.getString("created_date")));
				view.setPostedDate(Timestamp.valueOf(rs.getString("posted_date")));

				al.add(view);
				PostService ps = new PostServiceImpl();
				ps.print(al);

			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return al;
	}

}
