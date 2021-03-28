package com.amit.app.controller;

import static org.springframework.http.HttpStatus.OK;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.model.dto.TutorialDTO;
import com.amit.app.service.TutorialService;

@RestController
@RequestMapping(path = {"/v1.0"})
public class AppController {

	private TutorialService tutorialService;
	
	@Autowired
	public AppController(TutorialService tutorialService) {
		this.tutorialService = tutorialService;
	}
	
	@RequestMapping(path = {"/tutorials"}, method = {RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Map<String, Object>> getTutorials(@RequestParam(required = false, name = "title") String title,
			@RequestParam(defaultValue = "1", name = "pageNumber") int pageNumber, @RequestParam(defaultValue = "3", name = "pageSize") String pageSize) {
		
		Map<String, Object> paginatedMapData = this.tutorialService.retrievePaginatedTutorials(title, pageNumber, pageNumber);
		return new ResponseEntity<>(paginatedMapData, OK);
	}
	
	@RequestMapping(path = {"/tutorials/published"}, method = {RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Map<String, Object>> getPublishedTutorials(@RequestParam(defaultValue = "0", name = "pageNumber") int pageNumber,
			@RequestParam(defaultValue = "3", name = "pageSize") String pageSize) {
		
		Map<String, Object> paginatedMapData = this.tutorialService.retrievePaginatedPublishedTutorials(pageNumber, pageNumber);
		
		return new ResponseEntity<>(paginatedMapData, OK);
	}
	
	@RequestMapping(path = {"/tutorial"}, method = {RequestMethod.POST}, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<TutorialDTO> saveTutorialDetails(@RequestBody TutorialDTO tutorialDTO) {
		TutorialDTO storeTutorialDTODetails = this.tutorialService.storeTutorialDetails(tutorialDTO);
		return new ResponseEntity<TutorialDTO>(storeTutorialDTODetails, OK);
	}
}
