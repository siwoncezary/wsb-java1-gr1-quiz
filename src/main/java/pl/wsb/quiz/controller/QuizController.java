package pl.wsb.quiz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.wsb.quiz.entity.Quiz;
import pl.wsb.quiz.model.SimpleQuiz;
import pl.wsb.quiz.service.QuizService;
import pl.wsb.quiz.service.QuizServiceJpa;

import java.util.Optional;

@RestController
public class QuizController {
    final QuizService quizService;

    public QuizController(QuizServiceJpa quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/quiz/{id}")
    public String quiz(@PathVariable int id) {
        Optional<Quiz> optionalQuiz = quizService.findById(id);
        return optionalQuiz.isPresent() ? optionalQuiz.get().toString() : "Brak takiego quizu!";
    }

    @GetMapping("/quiz")
    public String answerForQuiz(@RequestParam String category){
        return quizService.findByCategory(category).toString();
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
