package by.home.service.test;

import by.home.dto.TestDTO;
import by.home.entity.Test;
import by.home.repository.TestRepository;
import by.home.service.test.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darya on 29.04.16.
 */
@Service
public class TestService implements ITestService {

    @Autowired
    private TestRepository testRepository;

    @Transactional
    public List<TestDTO> getAllTests() {
        List<Test> tests = testRepository.findAll();
        List<TestDTO> testDTOs = new ArrayList<>();
        tests.stream().forEach(t -> testDTOs.add(new TestDTO(t.getTitle(),t.getCreateDate(),t.getUpdateDate())));
        return testDTOs;
    }
}
