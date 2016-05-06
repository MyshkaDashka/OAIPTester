package by.home.controller;

import by.home.dto.TestDTO;
import by.home.service.test.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Objects;

/**
 * Created by Darya on 06.05.16.
 */
@RestController
public class TestController {

    @Autowired
    private ITestService testService;

    @RequestMapping(method = RequestMethod.GET, value = "/tests")
    public List<TestDTO> getAllTests() {
        return testService.getAllTests();
    }

}
