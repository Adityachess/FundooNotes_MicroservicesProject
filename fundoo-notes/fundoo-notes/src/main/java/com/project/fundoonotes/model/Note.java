package com.project.fundoonotes.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.fundoonotes.dto.NoteDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "note_data")
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int userId;
	private String title;
	private String description;
//	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date createdDate;
	private Date modifiedDate;

	public Note(NoteDto note) {
		this.updateNote(note);
	}

	public void updateNote(NoteDto noteDto) {
		this.title = noteDto.getTitle();
		this.description = noteDto.getDescription();
		this.createdDate = new Date();
		this.modifiedDate = new Date();
	}

}
