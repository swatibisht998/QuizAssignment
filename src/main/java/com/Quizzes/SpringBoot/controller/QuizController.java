package com.Quizzes.SpringBoot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Quizzes.SpringBoot.entities.Quiz;
import com.Quizzes.SpringBoot.entities.QuizDTO;
import com.Quizzes.SpringBoot.entities.QuizResultDTO;
import com.Quizzes.SpringBoot.service.QuizService;

@RestController
@RequestMapping("/quizzes")
public class QuizController {
    private final QuizService quizService;
    
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
    
    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody QuizDTO quizDTO) {
        Quiz createdQuiz = quizService.createQuiz(quizDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuiz);
    }
    
    @GetMapping("/active")
    public ResponseEntity<List<Quiz>> getActiveQuiz() {
        List<Quiz> activeQuiz = quizService.getActiveQuiz();
        if (activeQuiz != null) {
            return ResponseEntity.ok(activeQuiz);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/result")
    public ResponseEntity<QuizResultDTO> getQuizResult(@PathVariable Long id) {
        QuizResultDTO quizResult = quizService.getQuizResult(id);
        if (quizResult != null) {
            return ResponseEntity.ok(quizResult);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        return ResponseEntity.ok(quizzes);
    }
}