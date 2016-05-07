package by.home.service.report;

import by.home.dto.ReportDTO;

import java.util.List;

/**
 * Created by Darya on 29.04.16.
 */
public interface IReportService {

    public List<ReportDTO> getAllReports(String login);
}
