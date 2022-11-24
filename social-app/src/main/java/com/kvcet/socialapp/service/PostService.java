package com.kvcet.socialapp.service;

import java.io.IOException;
import java.util.ArrayList;

import com.kvcet.socialapp.model.Post;
import com.kvcet.socialapp.model.View;

public interface PostService {
	int postMessageValidation(Post post) throws Exception;

	void print(ArrayList<View> view) throws IOException;

}
