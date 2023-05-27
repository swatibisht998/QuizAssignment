package com.Quizzes.SpringBoot.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Quizzes.SpringBoot.entities.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
	List<Quiz> findByStartDateBeforeAndEndDateAfter(LocalDateTime startDate, LocalDateTime endDate);

    List<Quiz> findByStatus(String status);
}
