package pl.wsb.quiz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.wsb.quiz.model.AbstractQuiz;
import pl.wsb.quiz.model.MultiChoiceQuiz;
import pl.wsb.quiz.model.OpenQuiz;
import pl.wsb.quiz.model.SimpleQuiz;

import java.util.List;
import java.util.Optional;

@RestController
public class QuizController {
    AbstractQuiz quiz;

    @GetMapping("/quiz/{id}")
    public String quiz(@PathVariable int id) {
        if (id == 1) {
            quiz = MultiChoiceQuiz.builder()
                    .question("Kiedy powstała Java?")
                    .answers(List.of("1998", "2000", "1993", "2005"))
                    .validAnswers(List.of("1993"))
                    .build();
        }
        if (id == 2){
            quiz = OpenQuiz.builder()
                    .question("Podaj operator tworzenia obiektów")
                    .validAnswer("new")
                    .build();
        }
        return quiz.toString();
    }

    @GetMapping("/quiz/answer")
    public String answerForQuiz(@RequestParam String answer){
        return quiz.isValidAnswer(answer.split(" ")) ? "Ok": "Zla odpowiedź";
    }

    @GetMapping("/quiz/json")
    public ResponseEntity<SimpleQuiz> quizJson() {
        return ResponseEntity.of(
                Optional.of(
                        SimpleQuiz.builder()
                                .question("Kiedy powstała Java")
                                .answer1("2000")
                                .answer2("1998")
                                .answer3("1993")
                                .valid(3)
                                .build()
                )
        );
    }
}
