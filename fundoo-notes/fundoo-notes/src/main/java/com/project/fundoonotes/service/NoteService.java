package com.project.fundoonotes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fundoonotes.dto.NoteDto;
import com.project.fundoonotes.model.Note;
import com.project.fundoonotes.repo.NoteRepository;

@Service
public class NoteService implements INoteService {

	@Autowired
	private NoteRepository noteRepository;

	@Override
	public Note updateNoteByID(int id, NoteDto noteDto, String token) {
		Note note = this.geNotesById(id, token);
		note.updateNote(noteDto);
		return noteRepository.save(note);
	}

		@Override
	public void deletebyID(int id , String token) {
		noteRepository.deleteById(id);
	}

		@Override
	public List<Note> getAllNotes( String token) {
		return noteRepository.findAll();
	}

	@Override
	public Note geNotesById(int id, String token) {
		return noteRepository.findById(id).get();
	}

	@Override
	public Note createNote(Note noteDto , String token) {

		return noteRepository.save(noteDto);
	}

}
