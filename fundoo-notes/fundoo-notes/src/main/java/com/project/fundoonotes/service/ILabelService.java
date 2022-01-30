package com.project.fundoonotes.service;

import java.util.List;

import com.project.fundoonotes.dto.LabelDto;
import com.project.fundoonotes.dto.ResponseTemplateDto;
import com.project.fundoonotes.model.Label;

public interface ILabelService {

	Label creatLabel(Label labelDto, String token);

	List<Label> getAllLabels(String token);

	Label geLabelById(int id, String token);

	void deleteLabelbyID(int id, String token);

	Label updateLabel(int id, LabelDto labelDto, String token);

}
