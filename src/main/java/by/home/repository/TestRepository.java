package by.home.repository;

import by.home.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Darya on 06.05.16.
 */
public interface TestRepository extends JpaRepository<Test, Integer> {

}
