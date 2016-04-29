package by.home.repository;

import by.home.entity.Student;
import by.home.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Darya on 29.04.16.
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByUserLogin(String login);

}
