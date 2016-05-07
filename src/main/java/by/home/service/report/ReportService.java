package by.home.service.report;

import by.home.dto.ReportDTO;
import by.home.entity.Report;
import by.home.entity.Student;
import by.home.entity.User;
import by.home.repository.ReportRepository;
import by.home.repository.StudentRepository;
import by.home.repository.UserRepository;
import by.home.service.report.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Darya on 29.04.16.
 */
@Service
public class ReportService implements IReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public List<ReportDTO> getAllReports(String login) {
        List<ReportDTO> reportDTOs = new ArrayList<>();
        User user = userRepository.findByLogin(login);
        if (Objects.nonNull(user)) {
            Student student = studentRepository.findByUserLogin(login);
            if (Objects.nonNull(student)) {
                List<Report> reports = reportRepository.findByStudentId(student.getId());
                reports.stream().forEach(report -> reportDTOs.add(new ReportDTO(report.getMark(), report.getAttemptCount(),
                        report.getLastAttemptDate(), report.getTest().getTitle())));
            }
        }
        return reportDTOs;
    }

}
