package pl.wsb.quiz.service;
import pl.wsb.quiz.entity.User;

public interface UserService {
    void save(User user);
    User findById(long id);
}
