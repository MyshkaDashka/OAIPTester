package by.home.controller;

import by.home.dto.ReportDTO;
import by.home.service.report.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Darya on 07.05.16.
 */
@RestController
@RequestMapping(value = "/report")
public class ReportController {

    @Autowired
    private IReportService reportService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ReportDTO> getAllReportsForUser(Principal principal){
        List<ReportDTO> reportDTOs = new ArrayList<>();
        if(Objects.nonNull(principal)){
            reportDTOs = reportService.getAllReports(principal.getName());
        }
        return reportDTOs;
    }

}
