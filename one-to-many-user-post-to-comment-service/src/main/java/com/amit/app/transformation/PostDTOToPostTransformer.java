package com.amit.app.transformation;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.amit.app.model.dto.PostDTO;
import com.amit.app.model.managed.Comments;
import com.amit.app.model.managed.Post;

@Service
public class PostDTOToPostTransformer implements TypeSafeTransformer<PostDTO, Post> {

	@Override
	public Post transform(PostDTO postDTO) {
		if(postDTO == null) {
			return null;
		}
		Post post = new Post();
		post.setTitle(postDTO.getTitle());
		if(postDTO.getComments() == null || postDTO.getComments().isEmpty())
			postDTO.setComments(Collections.emptyList());
		else {
			List<Comments> comments = postDTO.getComments().stream()
					.map(commentDTO -> new Comments(commentDTO.getReview()))
					.collect(Collectors.toList());
			post.setComments(comments);
		}		
		return post;
	}
}
