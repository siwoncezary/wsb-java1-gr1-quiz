package pl.wsb.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wsb.quiz.entity.Quiz;
import pl.wsb.quiz.repository.QuizRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceJpa implements QuizService{
    final QuizRepository quizRepository;

    @Autowired
    public QuizServiceJpa(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
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
}
