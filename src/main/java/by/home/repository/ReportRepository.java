package by.home.repository;

import by.home.entity.Administrator;
import by.home.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Darya on 07.05.16.
 */
public interface ReportRepository extends JpaRepository<Report, Integer> {

    List<Report> findByStudentId(Integer integer);
}
