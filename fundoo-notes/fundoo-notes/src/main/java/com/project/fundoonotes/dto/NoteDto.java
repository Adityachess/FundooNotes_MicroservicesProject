package com.project.fundoonotes.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDto {

	private int id;
	private String title;
	private String Description;
	private LocalDate createdDate;
	private LocalDate modifiedDate;
	private long userId;
}
