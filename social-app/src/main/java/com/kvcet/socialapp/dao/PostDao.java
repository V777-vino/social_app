package com.kvcet.socialapp.dao;

import java.util.ArrayList;

import com.kvcet.socialapp.model.Post;
import com.kvcet.socialapp.model.View;

public interface PostDao {
	void postMessage(Post post);

	ArrayList<View> viewAllPost();

}
