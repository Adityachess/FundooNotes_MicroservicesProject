package com.fundoonotes.user.service;

import com.fundoonotes.user.dto.UserDto;
import com.fundoonotes.user.model.User;

public interface IUserService {
	
	User updateUser(Long id, UserDto requestDto);
	void deletebyID(Long id , String token);

	String generateToken(User user);
	User createUser(User user);
	User loginUser(long id,String token);
	User getUser(long id);

}
