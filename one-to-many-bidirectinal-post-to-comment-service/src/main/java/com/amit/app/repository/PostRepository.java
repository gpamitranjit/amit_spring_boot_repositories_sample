package com.amit.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amit.app.model.managed.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
