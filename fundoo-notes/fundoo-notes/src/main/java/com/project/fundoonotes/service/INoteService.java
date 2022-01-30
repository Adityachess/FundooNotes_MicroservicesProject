package com.project.fundoonotes.service;

import java.util.List;

import com.project.fundoonotes.dto.NoteDto;
import com.project.fundoonotes.model.Note;

public interface INoteService {

	Note geNotesById(int id , String token);

	List<Note> getAllNotes( String token);

	void deletebyID(int id , String token);

	Note createNote(Note noteDto , String token);

	Note updateNoteByID(int id, NoteDto noteDto , String token);

}
