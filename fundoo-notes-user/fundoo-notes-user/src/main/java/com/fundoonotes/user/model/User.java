package com.fundoonotes.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fundoonotes.user.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_details")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long userId;

	@Pattern(regexp = "^[1-9]{2}\\s{1}[0-9]{10}$", message = "phone Number is invalid")
	@NotBlank(message = "phone Number can not be null")	
	public String mobileNumber;
	
	public String password;

	public void updateUser(UserDto requestDto) {
	  this.mobileNumber= requestDto.getMobileNumber();
	  this.password=requestDto.getPassword();

	}
	
	public User (UserDto requestDto) {
		this.updateUser(requestDto);
	}
}
