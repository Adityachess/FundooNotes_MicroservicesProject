package com.fundoonotes.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fundoonotes.user.dto.UserDto;
import com.fundoonotes.user.exception.UserException;
import com.fundoonotes.user.model.User;
import com.fundoonotes.user.repository.UserRepository;
import com.fundoonotes.user.util.JwtTokenUtil;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	/**
	 * @param User
	 * @return : String after user deleted
	 */

	@Override
	public void deletebyID(Long id, String token) {
		userRepository.deleteById(id);
	}

	/**
	 * API for update of user
	 * 
	 * @param User id , requestDTo
	 * @return : Updated User data
	 */
	@Override
	public User updateUser(Long id, UserDto requestDto) {
		User user = userRepository.findById(id).get();
		user.updateUser(requestDto);
		return userRepository.save(user);

	}

	@Override
	public String generateToken(User user) {
		Optional<User> userOptional = userRepository.getDetails(user.getMobileNumber(), user.getPassword());
		if (userOptional.isPresent()) {

			return jwtTokenUtil.generateToken(user.getMobileNumber());
		} else {
			throw new UserException("User Not Found");
		}
	}

	@Override
	public User loginUser(long id, String token) {

		if (jwtTokenUtil.isValidToken(token)) {
			return userRepository.findByUserId(id);
		} else
			throw new UserException("Not Valid Token");
	}

	/**
	 * API for getting user of user
	 * 
	 * @param User
	 * @return : user number and pass
	 */

	@Override
	public User getUser(long id) {

		return userRepository.findByUserId(id);

	}
}
