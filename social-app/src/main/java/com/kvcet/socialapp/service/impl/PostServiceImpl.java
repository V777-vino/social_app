package com.kvcet.socialapp.service.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.kvcet.socialapp.model.Post;
import com.kvcet.socialapp.model.View;
import com.kvcet.socialapp.service.PostService;

public class PostServiceImpl implements PostService {
	public void print(ArrayList<View> view) throws IOException {
		try {
			for (View v : view) {
				String allPost = "user name=" + v.getUserName() + ", message=" + v.getMessage() + ", createdDate="
						+ v.getCreatedDate() + ", postedDate=" + v.getPostedDate() + ", user id=" + v.getUserId();
				FileWriter writer = new FileWriter("View.txt");
				writer.write(allPost + System.lineSeparator());
				System.out.println(allPost);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int postMessageValidation(Post post) throws Exception {
		if (post.getUserId() <= 0) {
			throw new Exception("User id should not be negative or zero");
		}
		if (post.getMessage().isEmpty() || post.getMessage().isBlank()) {
			throw new Exception("Message hould not be empty or blank");
		}

		return 1;
	}

}
