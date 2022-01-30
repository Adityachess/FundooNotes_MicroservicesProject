package com.project.fundoonotes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Data : Using Lombok to Generate getters and setters
 * @NoArgsConstructor : Generating No Argument Constructor using Lombok
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
	
	private String message;
	private Object data;
}
