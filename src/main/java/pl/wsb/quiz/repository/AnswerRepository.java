package pl.wsb.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsb.quiz.entity.UserAnswer;

@Repository
public interface AnswerRepository extends JpaRepository<UserAnswer, Long> {
}
