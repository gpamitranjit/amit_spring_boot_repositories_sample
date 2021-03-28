package com.amit.app.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.amit.app.model.dto.TutorialDTO;
import com.amit.app.model.repository.Tutorial;
import com.amit.app.repository.TutorialRepository;
import com.amit.app.transformation.TutorialDTOTOTutorialTransformer;
import com.amit.app.transformation.TutorialToTutorialDTOTransformer;

@Service
public class TutorialService {

	private TutorialToTutorialDTOTransformer tutorialToTutorialDTOTransformer;
	private TutorialDTOTOTutorialTransformer tutorialDTOToTutorialTransformer;
	private TutorialRepository tutorialRepository;
	
	@Autowired
	public TutorialService(TutorialToTutorialDTOTransformer tutorialToTutorialDTOTransformer, TutorialDTOTOTutorialTransformer tutorialDTOToTutorialTransformer, TutorialRepository tutorialRepository) {
		this.tutorialToTutorialDTOTransformer = tutorialToTutorialDTOTransformer;
		this.tutorialDTOToTutorialTransformer = tutorialDTOToTutorialTransformer;
		this.tutorialRepository = tutorialRepository;
	}
	
	public TutorialDTO retrieveTutorialDTOById(Long tutorialId) {
		Optional<Tutorial> optionalTutorial = this.tutorialRepository.findById(tutorialId);
		return tutorialToTutorialDTOTransformer.transform(optionalTutorial.get());
	}
	
	public TutorialDTO storeTutorialDetails(TutorialDTO tutorialDTO) {
		Tutorial savedTutorialObj = this.tutorialRepository.save(this.tutorialDTOToTutorialTransformer.transform(tutorialDTO));
		return this.tutorialToTutorialDTOTransformer.transform(savedTutorialObj);
	}
	
	public Map<String, Object> retrievePaginatedTutorials(String title, int pageNumber, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Tutorial> pageTutorials;
		
		if (title == null || title.isEmpty()) {
			pageTutorials = this.tutorialRepository.findAll(pageable);
		}else {
			pageTutorials = this.tutorialRepository.findByTitleContaining(title, pageable);
		}
		
		return this.transformToMapData(pageTutorials);
	}
	
	public Map<String, Object> retrievePaginatedPublishedTutorials(int pageNumber, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Tutorial> pageTutorials = this.tutorialRepository.findByPublished(true, pageable);
		
		return this.transformToMapData(pageTutorials);
	}
	
	public Map<String, Object> transformToMapData(Page<Tutorial> pageTutorial) {
		Map<String, Object> tutorialsDTOMap = new HashMap<>();
		tutorialsDTOMap.put("tutorials", pageTutorial.getContent());
		tutorialsDTOMap.put("totalItems", pageTutorial.getTotalElements());
		tutorialsDTOMap.put("currentPage", pageTutorial.getNumber());
		tutorialsDTOMap.put("totalPages", pageTutorial.getTotalPages());
		return tutorialsDTOMap;
	}
}
