package com.project.fundoonotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fundoonotes.dto.ResponseTemplateDto;
import com.project.fundoonotes.service.ResponseService;

@RestController
@RequestMapping("/service")
public class ResponseController {
	
	@Autowired
	private ResponseService ResponseService;
	
	/**
     * API for getting all data of particular user
     * @return : all data
     */
	@GetMapping("/getalldata/{id}")
	public ResponseTemplateDto getLablesAndNotesByUser(@PathVariable("id") int userId, @RequestHeader String token) {
		
		return ResponseService.getLablesAndNotesWithUser(userId, token);
	}
}
