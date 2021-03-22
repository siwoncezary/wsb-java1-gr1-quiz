package pl.wsb.quiz.repository;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wsb.quiz.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
}
