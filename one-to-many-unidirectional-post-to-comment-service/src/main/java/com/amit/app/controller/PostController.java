package com.amit.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.model.dto.PostDTO;
import com.amit.app.service.PostService;

@RestController
@RequestMapping(path = "/v1.0")
public class PostController {

	private PostService postService;
	
	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@RequestMapping(path = "/post", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PostDTO> savePost(@RequestBody PostDTO postDTO) {
		PostDTO _postDTO = this.postService.savePost(postDTO);
		return ResponseEntity.ok(_postDTO);
	}
	
	@RequestMapping(path = "/posts/{postId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PostDTO> retrievePost(@PathVariable("postId") Long postId) {
		
		PostDTO post = this.postService.retrievePost(postId);
		
		return ResponseEntity.ok(post);
	}

	@RequestMapping(path = "/posts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PostDTO>> retrieveAllPosts() {
		
		List<PostDTO> posts = this.postService.retrievePosts();
		
		
		return ResponseEntity.ok(posts);
	}
}
