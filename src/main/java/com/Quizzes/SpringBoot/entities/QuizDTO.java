package com.Quizzes.SpringBoot.entities;

import java.time.LocalDateTime;
import java.util.List;

public class QuizDTO {
	    private String question;
	    private List<String> options;
	    private int rightAnswer;
	    private LocalDateTime startDate;
	    private LocalDateTime endDate;
		public String getQuestion() {
			return question;
		}
		public void setQuestion(String question) {
			this.question = question;
		}
		public List<String> getOptions() {
			return options;
		}
		public void setOptions(List<String> options) {
			this.options = options;
		}
		public int getRightAnswer() {
			return rightAnswer;
		}
		public void setRightAnswer(int rightAnswer) {
			this.rightAnswer = rightAnswer;
		}
		public LocalDateTime getStartDate() {
			return startDate;
		}
		public void setStartDate(LocalDateTime startDate) {
			this.startDate = startDate;
		}
		public LocalDateTime getEndDate() {
			return endDate;
		}
		public void setEndDate(LocalDateTime endDate) {
			this.endDate = endDate;
		}
	    
}
