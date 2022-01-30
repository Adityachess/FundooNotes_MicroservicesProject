package com.fundoonotes.user.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fundoonotes.user.dto.ResponseDTO;

/**
 * @ControllerAdvice : Creating Controller Advice to Handle Exceptions
 * @ExceptionHandler : Creating Exception Handler method to handle Exceptions Thrown
 */
@ControllerAdvice
public class ExceptionHandlerClass {
	private static final String message = " Exception while processing REST Request";

		@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handlerMethodArgumentNotValidException(
			MethodArgumentNotValidException methodArgumentNotValidException) {
		List<ObjectError> errorList = methodArgumentNotValidException.getBindingResult().getAllErrors();
		List<String> errMsg = errorList.stream().map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO(message, errMsg, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/**
	 * Method to handle custom AddressBookCustomException is Thrown
	 * 
	 * @param addressBookCustomException
	 * @return : ResponseEntity of ResponseDTO object of Custom exception
	 */
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ResponseDTO> handlerUserException(UserException user) {
		ResponseDTO responseDTO = new ResponseDTO(message, user.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/**
	 * method to handle Token is not entered by user
	 * @param exception
	 * @return : ResponseEntity of Exception
	 */
	@ExceptionHandler(MissingRequestHeaderException.class)
	public ResponseEntity<ResponseDTO> missingRequestHeaderException(MissingRequestHeaderException exception) {
		ResponseDTO responseDTO = new ResponseDTO(message, "Enter your Token", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
}
