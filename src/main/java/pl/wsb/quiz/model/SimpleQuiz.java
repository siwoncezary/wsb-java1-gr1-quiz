package pl.wsb.quiz.model;

import lombok.Builder;
import lombok.Data;

@Data
public class SimpleQuiz {
    final String question;
    final String answer1;
    final String answer2;
    final String answer3;
    final String answer4;
    final int valid;

    public static Builder builder(){
        return Builder.builder();
    }
    public static class Builder{
        String question;
        String answer1;
        String answer2;
        String answer3;
        String answer4;
        int valid;
        private Builder(){

        }
        private static Builder builder(){
            return new Builder();
        }

        public Builder question(String question){
            this.question = question;
            return this;
        }

        public Builder answer1(String answer1){
            this.answer1 = answer1;
            return this;
        }

        public SimpleQuiz build(){
            return  new SimpleQuiz(question, answer1,"" ,"","",1);
        }
    }
}
