package pl.wsb.quiz.model;

import lombok.Builder;
import lombok.ToString;

import java.util.List;

@ToString
public class MultiChoiceQuiz extends AbstractQuiz{
    private List<String> answers;
    private List<String> validAnswers;

    @Builder
    public MultiChoiceQuiz(String question, List<String> answers, List<String> validAnswers) {
        super(question);
        this.answers = answers;
        this.validAnswers = validAnswers;
    }

    protected MultiChoiceQuiz(String question) {
        super(question);
    }

    @Override
    public boolean isValidAnswer(String... inputs) {
        for(String userAnswer: inputs){
            if (!validAnswers.contains(userAnswer)){
                return false;
            }
        }
        return validAnswers.size() == inputs.length;
    }
}
