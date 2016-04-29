package by.home.repository;

import by.home.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Darya on 29.04.16.
 */
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {

    Administrator findByUserName(String name);

}
