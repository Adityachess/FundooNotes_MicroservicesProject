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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.project.fundoonotes.dto.LabelDto;
import com.project.fundoonotes.dto.ResponseTemplateDto;
import com.project.fundoonotes.model.Label;
import com.project.fundoonotes.model.Response;
import com.project.fundoonotes.service.LabelService;

@RestController
@RequestMapping("/label")
public class LableController {
	
	@Autowired
	private LabelService labelService;
	
	/**
     * @param : label
     * @return : All labels
     */
	@GetMapping("/getall")
	public ResponseEntity<Response> getAllLabels(@RequestHeader String token) {
		List<Label> labelList = null;
		 labelList = labelService.getAllLabels(token);
		Response respDTO = new Response("Get call success",  labelList);
		return new ResponseEntity<Response>(respDTO, HttpStatus.OK);
	}

	 /**
     * @param label id
     * @return : label
     */
	@GetMapping("/get/{id}")
	public ResponseEntity<Response> getLabelById(@PathVariable("id") int id, @RequestHeader String token) {
		Label label = null;
		label = labelService.geLabelById(id, token);
		Response respDTO = new Response("Get call success for id:" + id, label);
		return new ResponseEntity<Response>(respDTO, HttpStatus.OK);
	}

	/**
     * @param labelDto
     * @return : label create
     */
	@PostMapping("/create")
	public ResponseEntity<Response> createLabel(@RequestBody Label labelDto, @RequestHeader String token) {
		Label createLabel = null;
		createLabel = labelService.creatLabel(labelDto, token);
		Response respDTO = new Response("created Label successfully", createLabel);
		return new ResponseEntity<Response>(respDTO, HttpStatus.OK);
	}

	/**
     * @param label id ,LabelDto
     * @return : updated label
     */
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Response> updateLabel(@PathVariable("id") int id,
			@RequestBody LabelDto labelDto, @RequestHeader String token) {
		Label createLabel = null;
		createLabel = labelService.updateLabel(id, labelDto, token);
		Response respDTO = new Response("Updated Label successfully", createLabel);
		return new ResponseEntity<Response>(respDTO, HttpStatus.OK);
	}

	/**
     * @param id
     * @return : Response Entity of Deleted label id
     */
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Response> deleteLabel(@PathVariable("id") int id, @RequestHeader String token) {
		labelService.deleteLabelbyID(id, token);
		Response respDTO = new Response("Deleted Label Successfully",
				"deleted labelId is :" + id);
		return new ResponseEntity<Response>(respDTO, HttpStatus.OK);
	}

	

}
