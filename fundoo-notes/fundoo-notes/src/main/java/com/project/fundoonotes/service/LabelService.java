package com.project.fundoonotes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.fundoonotes.dto.LabelDto;
import com.project.fundoonotes.model.Label;
import com.project.fundoonotes.repo.LabelRepository;

@Service
public class LabelService implements ILabelService {

	@Autowired
	private LabelRepository labelRepository;

	@Override
	public Label updateLabel(int id, LabelDto labelDto, String token) {
		Label label = labelRepository.getById(id);
		label.updateLabel(labelDto);
		return labelRepository.save(label);

	}

	@Override
	public void deleteLabelbyID(int id, String token) {
		labelRepository.deleteById(id);
	}

	@Override
	public List<Label> getAllLabels(String token) {
		return labelRepository.findAll();
	}

	@Override
	public Label geLabelById(int id, String token) {
		return labelRepository.findById(id).get();
	}

	@Override
	public Label creatLabel(Label labelDto, String token) {

		return labelRepository.save(labelDto);
	}

}
