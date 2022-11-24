package com.kvcet.socialapp.service;

import com.kvcet.socialapp.model.User;

public interface UserService {

	public int registerUserValidation(User user) throws Exception;

	public int userIdCheck(int userId) throws Exception;

	public int userDetailsCheck(User user) throws Exception;

	public int updatePassword(String password, int userId) throws Exception;

}
