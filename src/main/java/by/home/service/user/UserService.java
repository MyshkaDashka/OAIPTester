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
import org.springframework.util.StringUtils;

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
    public List<NewUserDTO> getAll() {
        List<User> users = userRepository.findAll();
        List<NewUserDTO> userDTOs = new ArrayList<>();
        users.stream().forEach(u -> userDTOs.add(new NewUserDTO(u.getLogin(),
                u.getPassword(), getLastNameUser(u), getNameUser(u), getFatherNameUser(u),
                u.getRole(), getEmailUser(u))));
        return userDTOs;
    }

    private String getNameUser(User user) {
        StringBuilder name = new StringBuilder();
        if (Objects.nonNull(user)) {
            switch (user.getRole()) {
                case student:
                    Student student = studentRepository.findByUserLogin(user.getLogin());
                    name.append(student.getName());
                    break;
                case teacher:
                    Teacher teacher = teacherRepository.findByUserLogin(user.getLogin());
                    name.append(teacher.getName());
                    break;
                case admin:
                    Administrator administrator = administratorRepository.findByUserLogin(user.getLogin());
                    name.append(administrator.getName());
                    break;
                default:
                    break;
            }
        }
        return name.toString();
    }

    private String getLastNameUser(User user) {
        StringBuilder name = new StringBuilder();
        if (Objects.nonNull(user)) {
            switch (user.getRole()) {
                case student:
                    Student student = studentRepository.findByUserLogin(user.getLogin());
                    name.append(student.getLastName());
                    break;
                case teacher:
                    Teacher teacher = teacherRepository.findByUserLogin(user.getLogin());
                    name.append(teacher.getLastName());
                    break;
                case admin:
                    Administrator administrator = administratorRepository.findByUserLogin(user.getLogin());
                    name.append(administrator.getLastName());
                    break;
                default:
                    break;
            }
        }
        return name.toString();
    }

    private String getFatherNameUser(User user) {
        StringBuilder name = new StringBuilder();
        if (Objects.nonNull(user)) {
            switch (user.getRole()) {
                case student:
                    Student student = studentRepository.findByUserLogin(user.getLogin());
                    name.append(student.getFatherName());
                    break;
                case teacher:
                    Teacher teacher = teacherRepository.findByUserLogin(user.getLogin());
                    name.append(teacher.getFatherName());
                    break;
                case admin:
                    Administrator administrator = administratorRepository.findByUserLogin(user.getLogin());
                    name.append(administrator.getFatherName());
                    break;
                default:
                    break;
            }
        }
        return name.toString();
    }

    private String getEmailUser(User user) {
        StringBuilder email = new StringBuilder();
        if (Objects.nonNull(user)) {
            switch (user.getRole()) {
                case student:
                    Student student = studentRepository.findByUserLogin(user.getLogin());
                    email.append(student.getEmail());
                    break;
                case teacher:
                    Teacher teacher = teacherRepository.findByUserLogin(user.getLogin());
                    email.append(teacher.getEmail());
                    break;
                case admin:
                    Administrator administrator = administratorRepository.findByUserLogin(user.getLogin());
                    email.append(administrator.getEmail());
                    break;
                default:
                    break;
            }
        }
        return email.toString();
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
    public Student addUser(NewUserDTO newUserDTO) {
        Student student = new Student();
        student.setUser(saveUser(newUserDTO.getLogin(), newUserDTO.getPassword()));
        student.setEmail(newUserDTO.getEmail());
        student.setName(newUserDTO.getName());
        student.setFatherName(newUserDTO.getFatherName());
        student.setLastName(newUserDTO.getLastName());
        return studentRepository.save(student);
    }

    @Transactional
    private User saveUser(String login, String password) {
        User newUser = new User();
        newUser.setLogin(login);
        newUser.setPassword(password);
        newUser.setRole(Role.student);
        return userRepository.save(newUser);
    }

    @Transactional
    public void editUserInformation(NewUserDTO newUserDTO) {
        User user = userRepository.findByLogin(newUserDTO.getLogin());
        if (Objects.nonNull(user)) {
            switch (user.getRole()) {
                case student:
                    Student student = studentRepository.findByUserLogin(newUserDTO.getLogin());
                    student.setLastName(newUserDTO.getLastName());
                    student.setFatherName(newUserDTO.getFatherName());
                    student.setName(newUserDTO.getName());
                    student.setEmail(newUserDTO.getEmail());
                    student.setGroup(newUserDTO.getGroup());
                    student.setPhoneNumber(newUserDTO.getPhoneNumber());
                    studentRepository.save(student);
                    break;
                case teacher:
                    Teacher teacher = teacherRepository.findByUserLogin(newUserDTO.getLogin());
                    teacher.setLastName(newUserDTO.getLastName());
                    teacher.setName(newUserDTO.getName());
                    teacher.setFatherName(newUserDTO.getFatherName());
                    teacher.setEmail(newUserDTO.getEmail());
                    teacher.setPhoneNumber(newUserDTO.getPhoneNumber());
                    teacher.setCabinet(newUserDTO.getCabinet());
                    teacher.setPosition(newUserDTO.getPosition());
                    teacherRepository.save(teacher);
                    break;
                case admin:
                    Administrator administrator = administratorRepository.findByUserLogin(newUserDTO.getLogin());
                    administrator.setLastName(newUserDTO.getLastName());
                    administrator.setName(newUserDTO.getName());
                    administrator.setFatherName(newUserDTO.getFatherName());
                    administrator.setPhoneNumber(newUserDTO.getPhoneNumber());
                    administrator.setEmail(newUserDTO.getEmail());
                    administrator.setCabinet(newUserDTO.getCabinet());
                    administratorRepository.save(administrator);
                    break;
                default:
                    break;
            }
        }

    }

}
