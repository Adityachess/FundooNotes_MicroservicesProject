package com.fundoonotes.user.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	

		
		@Pattern(regexp = "^[1-9]{2}\\s{1}[0-9]{10}$", message = "phone Number is invalid")
		@NotBlank(message = "phone Number can not be null")
		private String mobileNumber;
		private String password;
	}


