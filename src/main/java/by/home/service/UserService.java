package by.home.service;

import by.home.dto.UserDTO;
import by.home.entity.User;
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
public class UserService {

    @Autowired
    private UserRepository userRepository;

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
}
