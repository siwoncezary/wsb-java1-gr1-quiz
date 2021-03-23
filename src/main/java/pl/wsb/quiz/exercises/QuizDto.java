package pl.wsb.quiz.exercises;

import lombok.Data;

@Data
public class QuizDto {
    String question;
    String[] options;
    int[] answers;
}
