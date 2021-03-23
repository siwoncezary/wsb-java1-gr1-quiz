package pl.wsb.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.wsb.quiz.entity.UserAnswer;
import pl.wsb.quiz.repository.AnswerRepository;
import pl.wsb.quiz.repository.QuizRepository;
import pl.wsb.quiz.repository.UserRepository;

@RestController
public class AnswerController {
    final AnswerRepository answerRepository;
    final UserRepository userRepository;
    final QuizRepository quizRepository;

    @Autowired
    public AnswerController(AnswerRepository answerRepository, UserRepository userRepository, QuizRepository quizRepository) {
        this.answerRepository = answerRepository;
        this.userRepository = userRepository;
        this.quizRepository = quizRepository;
    }

    @PostMapping("/answer")
    public String answer(@RequestParam long user_id, @RequestParam long quiz_id, String answer){
        //answerRepository.save(new UserAnswer(0, answer, quizRepository.findById(quiz_id).get(), userRepository.findById(user_id).get()));
        return "Answer";
    }
}
