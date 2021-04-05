package com.amit.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.amit.app.model.managed.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

	@Query("select t from #{#entityName} t where t.title like %?#{escape([0])}% escape ?#{escapeCharacter()}")
	public List<Tutorial> findByTitleContaining(@Param("title") String title);
}
