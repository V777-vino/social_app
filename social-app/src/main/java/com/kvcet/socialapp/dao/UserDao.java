package com.kvcet.socialapp.dao;

import com.kvcet.socialapp.model.User;

public interface UserDao {
	
	void insertUser(User user);

	void deleteUser(int userId);

	void updatePassword(String password, int userId);

	public int login(String email, String password) throws Exception;

}
