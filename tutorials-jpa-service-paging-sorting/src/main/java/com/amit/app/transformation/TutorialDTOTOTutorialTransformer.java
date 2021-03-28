package com.amit.app.transformation;

import org.springframework.stereotype.Service;

import com.amit.app.model.dto.TutorialDTO;
import com.amit.app.model.repository.Tutorial;

@Service
public class TutorialDTOTOTutorialTransformer implements TypeSafeTranformer<TutorialDTO, Tutorial> {
	@Override
	public Tutorial transform(TutorialDTO tutorialDTO) {
		if (tutorialDTO == null) {
			return null;
		}
		Tutorial tutorial = new Tutorial();
		tutorial.setId(tutorialDTO.getId());
		tutorial.setTitle(tutorialDTO.getTitle());
		tutorial.setDescription(tutorialDTO.getDescription());
		tutorial.setPublished(tutorialDTO.isPublished());
		return tutorial;
	}
}
