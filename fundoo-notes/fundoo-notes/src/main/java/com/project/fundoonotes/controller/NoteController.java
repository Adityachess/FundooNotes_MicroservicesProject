package com.project.fundoonotes.controller;

import java.util.List;

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

import com.project.fundoonotes.dto.NoteDto;
import com.project.fundoonotes.model.Note;
import com.project.fundoonotes.model.Response;
import com.project.fundoonotes.service.NoteService;

@RestController
@RequestMapping("/note")
public class NoteController {
	
	@Autowired
	private NoteService noteService;

	/**
     * @return : note data
     */
	@GetMapping("/getall")
	public ResponseEntity<Response> getAllNotes( @RequestHeader String token) {
		List<Note> noteList = null;
		noteList = noteService.getAllNotes(token);
		Response respDTO = new Response("Get call success", noteList);
		return new ResponseEntity<Response>(respDTO, HttpStatus.OK);
	}
	
	 /**
     * @param : note id
     * @return : note data
     */
	@GetMapping("/get/{id}")
	public ResponseEntity<Response> getNotesById(@PathVariable("id") int id , @RequestHeader String token) {
		Note noteDetails = null;
		noteDetails = noteService.geNotesById(id, token);
		Response respDTO = new Response("Get call success for id:" + id, noteDetails);
		return new ResponseEntity<Response>(respDTO, HttpStatus.OK);
	}

	/**
     * @param NoteDto
     * @return : create note
     */
	@PostMapping("/create")
	public ResponseEntity<Response> createNotes( @RequestBody Note noteDto , @RequestHeader String token) {
		
		Note createNote = noteService.createNote(noteDto, token);  
		Response respDTO = new Response("created Note successfully", createNote);
		return new ResponseEntity<Response>(respDTO, HttpStatus.OK);
	}

	
	/**
     * @param : Note id ,NoteDto
     * @return : Updated note
     */
	@PutMapping("/update/{id}")
	public ResponseEntity<Response> updateNote(@PathVariable("id") int id,
			@RequestBody NoteDto noteDto , @RequestHeader String token) {
		Note createNote = null;
		createNote = noteService.updateNoteByID(id, noteDto, token);
		Response respDTO = new Response("Updated Note successfully", createNote);
		return new ResponseEntity<Response>(respDTO, HttpStatus.OK);
	}

	/**
     * @param id
     * @return : String after note deleted
     */

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> deleteNote(@PathVariable("id") int id , @RequestHeader String token) {
		noteService.deletebyID(id, token);
		Response respDTO = new Response("Deleted Note Successfully",
				"deleted NoteId is :" + id);
		return new ResponseEntity<Response>(respDTO, HttpStatus.OK);
	}

}