package com.amit.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.app.model.dto.PostDTO;
import com.amit.app.model.managed.Post;
import com.amit.app.repository.PostRepository;
import com.amit.app.transformation.PostDTOToPostTransformer;
import com.amit.app.transformation.PostToPostDTOTransformer;

@Service
public class PostService {

	private PostRepository postRepository;
	private PostToPostDTOTransformer postToPostDTOTransformer;
	private PostDTOToPostTransformer postDTOToPostTransformer;
	
	@Autowired
	public PostService(PostRepository postRepository, PostToPostDTOTransformer postToPostDTOTransformer, PostDTOToPostTransformer postDTOToPostTransformer) {
		this.postRepository = postRepository;
		this.postToPostDTOTransformer = postToPostDTOTransformer;
		this.postDTOToPostTransformer = postDTOToPostTransformer;
	}
	
	public PostDTO savePost(PostDTO postDTO) {
		Post post = this.postDTOToPostTransformer.transform(postDTO);
		Post _post = this.postRepository.save(post);
		return this.postToPostDTOTransformer.transform(_post);
	}
	
	public PostDTO retrievePost(Long postId) {
		
		Optional<Post> _post = this.postRepository.findById(postId);
		
		return this.postToPostDTOTransformer.transform(_post.get());
	}
	
	public List<PostDTO> retrievePosts() {
		
		List<Post> _posts = this.postRepository.findAll();
		List<PostDTO> postDTOs = this.postToPostDTOTransformer.transform(_posts);
		
		return postDTOs;
	}
}
