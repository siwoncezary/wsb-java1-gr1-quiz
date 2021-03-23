package pl.wsb.quiz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wsb.quiz.entity.Quiz;
import pl.wsb.quiz.entity.QuizDtoRequest;
import pl.wsb.quiz.exercises.QuizDto;
import pl.wsb.quiz.model.SimpleQuiz;
import pl.wsb.quiz.service.QuizService;
import pl.wsb.quiz.service.QuizServiceJpa;

import java.util.Arrays;
import java.util.Optional;

@Controller
public class QuizController {
    final QuizService quizService;

    public QuizController(QuizServiceJpa quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/fill")
    public String addQuiz(){
        return "quiz-form";
    }

    @GetMapping("/quiz/{id}")
    public String quiz(@PathVariable int id) {
        Optional<Quiz> optionalQuiz = quizService.findById(id);
        return optionalQuiz.isPresent() ? optionalQuiz.get().toString() : "Brak takiego quizu!";
    }

    @GetMapping("/quizzes")
    public String quizzes(){
        return quizService.findAll().toString();
    }

    @GetMapping("/answer")
    public String answer(@RequestParam long id, Model model){
        Optional<Quiz> optionalQuiz = quizService.findById(id);
        if (!optionalQuiz.isPresent()){
            return "error";
        }
        Quiz quiz = optionalQuiz.get();
        model.addAttribute("id", quiz.getId());
        model.addAttribute("question", quiz.getQuestion());
        model.addAttribute("options", quiz.getOptions().split("\n"));
        return "answer-form";

    }

    @GetMapping("/quiz/json")
    public ResponseEntity<SimpleQuiz> quizJson() {
        return ResponseEntity.of(
                Optional.of(
                        SimpleQuiz.builder()
                                .question("Kiedy powstała Java")
                                .answer1("2000")
                                .build()
                )
        );
    }

    @PostMapping("/quiz")
    public String saveNewQuiz(QuizDtoRequest dto){
        Quiz quiz = Quiz.builder().question(dto.getQuestion())
                .options(dto.optionsToString())
                .answers(dto.answersToString())
                .build();
        quizService.save(quiz);
        return dto.toString();
    }
}
