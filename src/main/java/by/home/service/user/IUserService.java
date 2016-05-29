package by.home.service.user;

import by.home.dto.AdministratorDTO;
import by.home.dto.NewUserDTO;
import by.home.dto.UserDTO;
import by.home.entity.Student;
import by.home.entity.User;

import java.util.List;

/**
 * Created by Darya on 28.04.16.
 */
public interface IUserService {

    public List<NewUserDTO> getAll();

    public UserDTO getUserInformation(String login);

    public List<AdministratorDTO> getAllAdministrators();

    public Student addUser(NewUserDTO newUserDTO);

    public void editUserInformation(NewUserDTO newUserDTO);
}
