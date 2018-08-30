package com.example.micro4;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findByTopic(String topic);

	List<Task> findByTopicOrderByIdDesc(String topic);

	@Query("SELECT t FROM Task t WHERE t.topic like %:word%")
	List<Task> findByTopicContainWord(@Param("word") String word);
}
