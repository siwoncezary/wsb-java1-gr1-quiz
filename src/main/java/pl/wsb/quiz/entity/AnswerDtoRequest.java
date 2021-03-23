package pl.wsb.quiz.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDtoRequest {
    private long id;
    private String[] answers;

    public String answersToString(){
        StringBuffer sb = new StringBuffer();
        for(String option:answers){
            sb.append(option+"\n");
        }
        return sb.toString();
    }
}
