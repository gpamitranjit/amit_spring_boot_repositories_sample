package com.amit.app.transformation;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.amit.app.model.dto.TutorialDTO;
import com.amit.app.model.repository.Tutorial;

@Service
public class TutorialToTutorialDTOTransformer implements TypeSafeTranformer<Tutorial, TutorialDTO> {

	@Override
	public TutorialDTO transform(Tutorial tutorial) {
		if(tutorial == null) {
			return null;
		} 
		TutorialDTO tutorialDTO = new TutorialDTO();
		tutorialDTO.setId(tutorial.getId());
		tutorialDTO.setTitle(tutorial.getTitle());
		tutorialDTO.setDescription(tutorial.getDescription());
		tutorialDTO.setPublished(tutorial.isPublished());
		return tutorialDTO;
	}

	@Override
	public List<TutorialDTO> transform(List<Tutorial> tutorials) {
		if (tutorials == null) {
			return Collections.emptyList();
		}
		return tutorials.stream()
				.map(tutorial -> new TutorialDTO(tutorial.getId(), tutorial.getTitle(), tutorial.getDescription(), tutorial.isPublished()))
				.collect(Collectors.toList());
	}
}
