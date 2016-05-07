package by.home.controller;

import by.home.dto.AdministratorDTO;
import by.home.dto.NewUserDTO;
import by.home.dto.UserDTO;
import by.home.entity.User;
import by.home.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Objects;

/**
 * Created by Darya on 17.04.16.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDTO> getAll() {
        return userService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/profile")
    public UserDTO getUserInformation(Principal principal) {
        UserDTO user = null;
        if (Objects.nonNull(principal)) {
            user = userService.getUserInformation(principal.getName());
        }
        return user;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/admins")
    public List<AdministratorDTO> getAllAdministrators() {
        return userService.getAllAdministrators();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/registration")
    public void addNewUser(@RequestBody NewUserDTO newUserDTO) {
        userService.addUser(newUserDTO);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit")
    public void editUserInformation(@RequestBody NewUserDTO newUserDTO) {
        userService.editUserInformation(newUserDTO);
    }



}
