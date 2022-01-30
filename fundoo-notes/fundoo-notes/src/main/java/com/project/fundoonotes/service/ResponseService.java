package com.project.fundoonotes.service;

import java.util.List;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.fundoonotes.dto.ResponseTemplateDto;
import com.project.fundoonotes.dto.UserDto;
import com.project.fundoonotes.model.Label;
import com.project.fundoonotes.model.Note;
import com.project.fundoonotes.repo.LabelRepository;
import com.project.fundoonotes.repo.NoteRepository;

/**
* @Service : creating service layer
* @Autowired : enabling automatic dependency Injection
* @Override : Overriding implemented methods from interface
*/
@Service
public class ResponseService implements IResponseService{

	 /**
     * Autowiring LabelRepository and NoteRepository to Dependency injection to save in DB
     */
	@Autowired
	private LabelRepository labelRepository;

	@Autowired
	private NoteRepository noteRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public ResponseTemplateDto getLablesAndNotesWithUser(int userId , String token) {
		ResponseTemplateDto responseTemplateDto = new ResponseTemplateDto();
		
		UserDto userData=restTemplate.getForObject("http://localhost:8002/user/get/"+userId, UserDto.class);
		
		List<Label> labelList = labelRepository.findByUserId(userId); 
		List<Note> notesList = noteRepo.findByUserId(userId);
		
		responseTemplateDto.setUser(userData);
		responseTemplateDto.setLable(labelList);
		responseTemplateDto.setNote(notesList);
		return responseTemplateDto;
	}

	

}
