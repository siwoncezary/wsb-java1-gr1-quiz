package pl.wsb.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsb.quiz.entity.AnswerDtoRequest;
import pl.wsb.quiz.entity.Quiz;
import pl.wsb.quiz.entity.UserAnswer;
import pl.wsb.quiz.repository.AnswerRepository;
import pl.wsb.quiz.repository.QuizRepository;
import pl.wsb.quiz.repository.UserRepository;
import pl.wsb.quiz.service.QuizService;

import java.util.Optional;

@RestController
public class AnswerController {
    final AnswerRepository answerRepository;
    final UserRepository userRepository;
    final QuizRepository quizRepository;
    final QuizService quizService;

    @Autowired
    public AnswerController(AnswerRepository answerRepository, UserRepository userRepository, QuizRepository quizRepository, QuizService quizService) {
        this.answerRepository = answerRepository;
        this.userRepository = userRepository;
        this.quizRepository = quizRepository;
        this.quizService = quizService;
    }

    @PostMapping("/answer")
    public String answer(AnswerDtoRequest dto){
//        Optional<Quiz> optionalQuiz = quizRepository.findById(dto.getId());
//        if (!optionalQuiz.isPresent()){
//            return "error";
//        }
//        Quiz quiz = optionalQuiz.get();
//        UserAnswer userAnswer = UserAnswer.builder().answers(dto.answersToString()).quiz(quiz).user(null).build();
//        answerRepository.save(userAnswer);
//        return userAnswer.toString();
          return quizService.saveAnswer(dto.getId(), 1, dto.answersToString()) ? "Poprawna odpowiedź:)": "Niepoprawna!!!";
    }
}
