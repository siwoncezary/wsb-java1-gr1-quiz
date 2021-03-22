package pl.wsb.quiz.service;

import pl.wsb.quiz.entity.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizService {
    Optional<Quiz> findById(long id);
    List<Quiz> findAll();
    List<Quiz> findByCategory(String category);
}
