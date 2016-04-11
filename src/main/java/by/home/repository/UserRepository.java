package by.home.repository;

/**
 * Created by Darya on 30.03.16.
 */
import by.home.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByLogin(String login);

}