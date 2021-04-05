package com.amit.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.model.managed.Tutorial;
import com.amit.app.repository.TutorialRepository;

@RestController
@RequestMapping(path = {"v1.0"})
public class TutorialController {

	private TutorialRepository tutorialRepository;
	
	@Autowired
	public TutorialController(TutorialRepository tutorialRepository) {
		this.tutorialRepository = tutorialRepository;
	}
	
	@RequestMapping(path = {"/tutorial"}, method = RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_VALUE)
	public Tutorial storeTutorial(@RequestBody Tutorial tutorial) {
		return this.tutorialRepository.save(tutorial);
	}
	
	@RequestMapping(path = {"/tutorials/tutorial/{title}"}, method = RequestMethod.GET, produces =  MediaType.APPLICATION_JSON_VALUE)
	public List<Tutorial> findTutorialsContainingTitle(@PathVariable("title") String title) {
		
		return this.tutorialRepository.findByTitleContaining(title);
	}
}
