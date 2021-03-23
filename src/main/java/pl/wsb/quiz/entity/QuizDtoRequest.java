package pl.wsb.quiz.entity;

import lombok.Data;

@Data
public class QuizDtoRequest {
    private String question;
    private String[] options;
    private int[] answers;

    public String optionsToString(){
        StringBuffer sb = new StringBuffer();
        for(String option:options){
            sb.append(option+"\n");
        }
        return sb.toString();
    }

    public String answersToString(){
        StringBuffer sb = new StringBuffer();
        for(int answer: answers){
            sb.append(options[answer]+"\n");
        }
        return sb.toString();
    }
}
