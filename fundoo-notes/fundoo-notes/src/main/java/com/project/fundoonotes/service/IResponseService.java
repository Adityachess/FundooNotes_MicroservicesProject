package com.project.fundoonotes.service;

import com.project.fundoonotes.dto.ResponseTemplateDto;

public interface IResponseService {

	ResponseTemplateDto getLablesAndNotesWithUser(int id, String token);

}
