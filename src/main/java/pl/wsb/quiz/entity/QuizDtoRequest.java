package pl.wsb.quiz.entity;

import lombok.Data;

@Data
public class QuizDtoRequest {
    private String question;
    private String[] options;
    private int[] answers;
}
