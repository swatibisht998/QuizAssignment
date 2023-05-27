package com.Quizzes.SpringBoot.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Quizzes.SpringBoot.entities.Quiz;
import com.Quizzes.SpringBoot.entities.QuizDTO;
import com.Quizzes.SpringBoot.entities.QuizResultDTO;
import com.Quizzes.SpringBoot.repository.QuizRepository;

@Service
public class QuizService {
	
	    private final QuizRepository quizRepository;
	    
	    public QuizService(QuizRepository quizRepository) {
	        this.quizRepository = quizRepository;
	    }
	    
	    public Quiz createQuiz(QuizDTO quizDTO) {
	        Quiz quiz = new Quiz();
	        quiz.setQuestion(quizDTO.getQuestion());
	        quiz.setOptions(quizDTO.getOptions());
	        quiz.setRightAnswer(quizDTO.getRightAnswer());
	        quiz.setStartDate(quizDTO.getStartDate());
	        quiz.setEndDate(quizDTO.getEndDate());
	        quiz.setStatus("inactive");
	        
	        return quizRepository.save(quiz);
	    }
	    
	    public List<Quiz> getActiveQuiz() {
	        LocalDateTime now = LocalDateTime.now();
	        List<Quiz> activeQuiz = quizRepository.findByStartDateBeforeAndEndDateAfter(now, now);
	        return activeQuiz != null ? activeQuiz : Collections.emptyList();
	    }
	    
	    public QuizResultDTO getQuizResult(Long id) {
	        Quiz quiz = quizRepository.findById(id).orElse(null);
	        if (quiz != null && quiz.getEndDate().plusMinutes(5).isBefore(LocalDateTime.now())) {
	            QuizResultDTO resultDTO = new QuizResultDTO();
	            resultDTO.setRightAnswer(quiz.getRightAnswer());
	            return resultDTO;
	        }
	        return null;
	    }
	    
	    public List<Quiz> getAllQuizzes() {
	        return quizRepository.findAll();
	    }
}
