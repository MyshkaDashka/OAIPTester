package by.home.service;

import by.home.dto.UserDTO;
import by.home.entity.Student;

import java.util.List;

/**
 * Created by Darya on 28.04.16.
 */
public interface IUserService {

    public List<UserDTO> getAll();

    public UserDTO getUserInformation(String login);
}
