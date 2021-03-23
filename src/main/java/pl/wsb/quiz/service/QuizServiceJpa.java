package pl.wsb.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wsb.quiz.entity.Quiz;
import pl.wsb.quiz.entity.User;
import pl.wsb.quiz.entity.UserAnswer;
import pl.wsb.quiz.repository.AnswerRepository;
import pl.wsb.quiz.repository.QuizRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceJpa implements QuizService{
    final QuizRepository quizRepository;
    final UserService userService;
    final AnswerRepository answerRepository;
    @Autowired
    public QuizServiceJpa(QuizRepository quizRepository, UserService userService, AnswerRepository answerRepository) {
        this.quizRepository = quizRepository;
        this.userService = userService;
        this.answerRepository = answerRepository;
    }

    @Override
    public Optional<Quiz> findById(long id) {
        return quizRepository.findById(id);
    }

    @Override
    public List<Quiz> findAll() {
        return quizRepository.findAll();
    }

    @Override
    public List<Quiz> findByCategory(String category) {
        return quizRepository.findByCategory(category);
    }

    @Override
    public boolean saveAnswer(long quizId, long userId, String answers) {
        User user = userService.findById(userId);
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        if (user != null && quiz.isPresent()){
            UserAnswer answer = UserAnswer.builder().user(user)
                    .quiz(quiz.get())
                    .answers(answers)
                    .build();
            answerRepository.save(answer);
            return isValidAnswer(quiz.get(), answers);
        }
        return false;
    }

    @Override
    public void save(Quiz quiz) {
        quizRepository.save(quiz);
    }

    private boolean isValidAnswer(Quiz quiz, String answers){
        String[] valid = quiz.getAnswers().split("\n");
        String[] userAnswers = answers.split("\n");
        return Arrays.compare(valid, userAnswers) == 0;

    }
}
