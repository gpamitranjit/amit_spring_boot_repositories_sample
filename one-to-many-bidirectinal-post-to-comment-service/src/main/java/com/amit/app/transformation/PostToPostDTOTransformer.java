package com.amit.app.transformation;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.amit.app.model.dto.PostDTO;
import com.amit.app.model.managed.Post;

@Service
public class PostToPostDTOTransformer implements TypeSafeTransformer<Post, PostDTO> {

	@Override
	public PostDTO transform(Post post) {
		
		if(post == null) {
			return null;
		}

		PostDTO postDTO = new PostDTO();
		postDTO.setId(post.getId());
		postDTO.setTitle(post.getTitle());
		postDTO.setComments(Collections.emptyList());
		
		return postDTO;
	}

	@Override
	public List<PostDTO> transform(List<Post> posts) {
		
		return posts.stream()
				.map(post -> new PostDTO(post.getId(), post.getTitle()))
				.collect(Collectors.toList());
	}
}
