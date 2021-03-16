package pl.wsb.quiz.model;

import lombok.Builder;
import lombok.ToString;

@ToString
abstract public class AbstractQuiz {
    final String question;

    protected AbstractQuiz(String question) {
        this.question = question;
    }

    public abstract boolean isValidAnswer(String ... inputs);
}
