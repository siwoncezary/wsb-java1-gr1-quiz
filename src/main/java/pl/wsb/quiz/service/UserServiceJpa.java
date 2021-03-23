package pl.wsb.quiz.service;

import org.springframework.stereotype.Service;
import pl.wsb.quiz.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class UserServiceJpa implements UserService {
    @PersistenceContext
    final private EntityManager em;

    public UserServiceJpa(EntityManager em) {
        this.em = em;
    }

    @Transactional
    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public User findById(long id) {
        return em.find(User.class, id);
    }
}
