package com.project.fundoonotes.dto;

import java.util.List;

import com.project.fundoonotes.model.Label;
import com.project.fundoonotes.model.Note;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateDto {

	private UserDto user;
	
	private List<Note> note;
	
	private List<Label> lable;
}
