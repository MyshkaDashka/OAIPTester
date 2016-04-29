package by.home.repository;

import by.home.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Darya on 29.04.16.
 */
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    Teacher findByUserLogin(String login);
}
