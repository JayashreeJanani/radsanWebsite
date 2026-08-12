package com.radsan.dto;

public class FAQRequestDTO {
	
	private String question;
    private String answer;

    public FAQRequestDTO() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
