package by.home.service.user;

import by.home.dto.*;
import by.home.entity.*;
import by.home.enums.Role;
import by.home.repository.AdministratorRepository;
import by.home.repository.StudentRepository;
import by.home.repository.TeacherRepository;
import by.home.repository.UserRepository;
import by.home.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();
        users.stream().forEach(u -> userDTOs.add(new UserDTO(u.getLogin(), u.getRole())));
        return userDTOs;
    }

    @Transactional
    public UserDTO getUserInformation(String login) {
        UserDTO userDTO = null;
        User user = userRepository.findByLogin(login);
        if (Objects.nonNull(user)) {
            switch (user.getRole()) {
                case student:
                    Student student = studentRepository.findByUserLogin(login);
                    userDTO = new StudentDTO(student.getName(), student.getLastName(), student.getFatherName(),
                            student.getGroup(), student.getEmail(), student.getPhoneNumber());
                    break;
                case teacher:
                    Teacher teacher = teacherRepository.findByUserLogin(login);
                    userDTO = new TeacherDTO(teacher.getName(), teacher.getLastName(), teacher.getFatherName(),
                            teacher.getCabinet(), teacher.getEmail(), teacher.getPhoneNumber(), teacher.getPosition());
                    break;
                case admin:
                    Administrator administrator = administratorRepository.findByUserLogin(login);
                    userDTO = new AdministratorDTO(administrator.getName(), administrator.getLastName(),
                            administrator.getFatherName(),
                            administrator.getCabinet(), administrator.getEmail(), administrator.getPhoneNumber());
                    break;
                default:
                    break;
            }
            userDTO.setLogin(login);
            userDTO.setRole(user.getRole());
        }
        return userDTO;
    }

    @Transactional
    public List<AdministratorDTO> getAllAdministrators() {
        List<Administrator> administrators = administratorRepository.findAll();
        List<AdministratorDTO> administratorDTOs = new ArrayList<>();
        administrators.stream().forEach(administrator -> administratorDTOs.add(new AdministratorDTO(administrator.getName(),
                administrator.getLastName(), administrator.getFatherName(), administrator.getCabinet(),
                administrator.getEmail(), administrator.getPhoneNumber())));
        return administratorDTOs;
    }


    @Transactional
    public Student addUser(NewUserDTO newUserDTO){
        Student student = new Student();
        student.setUser(saveUser(newUserDTO.getLogin(), newUserDTO.getPassword()));
        student.setEmail(newUserDTO.getEmail());
        student.setName(newUserDTO.getName());
        student.setFatherName(newUserDTO.getFatherName());
        student.setLastName(newUserDTO.getLastName());
        return studentRepository.save(student);
    }

    @Transactional
    private User saveUser(String login, String password){
        User newUser = new User();
        newUser.setLogin(login);
        newUser.setPassword(password);
        newUser.setRole(Role.student);
        return userRepository.save(newUser);
    }

    public void editUserInformation(NewUserDTO newUserDTO){


    }

}
