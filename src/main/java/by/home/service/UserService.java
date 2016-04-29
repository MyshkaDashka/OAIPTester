package by.home.service;

import by.home.dto.AdministratorDTO;
import by.home.dto.StudentDTO;
import by.home.dto.TeacherDTO;
import by.home.dto.UserDTO;
import by.home.entity.*;
import by.home.repository.AdministratorRepository;
import by.home.repository.StudentRepository;
import by.home.repository.TeacherRepository;
import by.home.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * Created by Darya on 17.04.16.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();
        users.stream().forEach(u -> userDTOs.add(new UserDTO(u.getLogin(), u.getRole())));

        return userDTOs;
    }

    public UserDTO getUser(String login) {
        UserDTO userDTO = null;
        User user = userRepository.findByLogin(login);
        if (Objects.nonNull(user)) {
            userDTO = new UserDTO();
            userDTO.setLogin(user.getLogin());
            userDTO.setRole(user.getRole());
        }
        return userDTO;
    }


    public UserDTO getUserInformation(String login) {
        UserDTO userDTO = null;
        User user = userRepository.findByLogin(login);
        if (Objects.nonNull(user)) {
            switch (user.getRole()) {
                case student:
                    Student student = studentRepository.findByUserName(login);
                    userDTO = new StudentDTO(student.getName(),student.getLastName(), student.getFatherName(),
                            student.getGroup(),student.getEmail(),student.getPhoneNumber());
                    break;
                case teacher:
                    Teacher teacher = teacherRepository.findByUserName(login);
                    userDTO = new TeacherDTO(teacher.getName(),teacher.getLastName(),teacher.getFatherName(),
                            teacher.getCabinet(),teacher.getEmail(),teacher.getPhoneNumber(),teacher.getPosition());
                    break;
                case admin:
                    Administrator administrator = administratorRepository.findByUserName(login);
                    userDTO = new AdministratorDTO(administrator.getName(),administrator.getLastName(),administrator.getFatherName(),
                            administrator.getCabinet(),administrator.getEmail(),administrator.getPhoneNumber());
                    break;
                default:
                    break;
            }
        }
        return userDTO;

    }

}
