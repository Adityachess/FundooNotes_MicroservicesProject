package com.fundoonotes.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundoonotes.user.dto.UserDto;
import com.fundoonotes.user.dto.ResponseDTO;
import com.fundoonotes.user.model.User;
import com.fundoonotes.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
     * @param User
     * @return : ResponseEntity of registered user-
     */
	@PostMapping("/register")
	public ResponseEntity<ResponseDTO> registerUser(@Valid @RequestBody User user) {
		User userDetailUser = userService.createUser(user);
		ResponseDTO responseDTO = new ResponseDTO("Create Call Success ", userDetailUser, HttpStatus.CREATED);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
	}

	/**
     * API for generate token of user
     * @param User number and password
     * @return : jwt token
     */
	@PostMapping("/token")
	public ResponseEntity<ResponseDTO> loginUser(@RequestBody User user) {
		String userDetailUser = userService.generateToken(user);
		ResponseDTO responseDTO = new ResponseDTO("Create Call Success ", userDetailUser, HttpStatus.ACCEPTED);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.ACCEPTED);

	}
	
	/**
     * API for getting user of user
     * @param User
     * @return : user number and pass
     */
	@GetMapping("/get/{id}")
	public User getUser(@PathVariable("id") long id) {
		User userDetailUser = userService.getUser(id);
		ResponseDTO responseDTO = new ResponseDTO("Get User data", userDetailUser, HttpStatus.ACCEPTED);
		return userDetailUser;
	}

	/**
     * API for update of user
     * @param User id , requestDTo
     * @return : Updated User data
     */
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateUser(@Valid @PathVariable("id") long id , @RequestBody UserDto requestDto) {
		User user = userService.updateUser(id, requestDto);
		ResponseDTO responseDTO = new ResponseDTO("Create Call Success ", user, HttpStatus.CREATED);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
	}

	/**
     * @param User
     * @return : String after user deleted
     */
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("id") Long id , @RequestHeader String token) {
		userService.deletebyID(id, token);
		ResponseDTO responseDTO = new ResponseDTO("Deleted id successfully ", id, HttpStatus.CREATED);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);

	}
}