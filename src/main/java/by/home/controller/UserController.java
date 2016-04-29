package by.home.controller;

import by.home.dto.UserDTO;
import by.home.entity.Student;
import by.home.service.IUserService;
import by.home.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(method = RequestMethod.GET, value = "/current")
    public UserDTO getCurrent(Principal principal) {
        UserDTO user = null;
        if (Objects.nonNull(principal)) {
            user = userService.getUser(principal.getName());
        }
        return user;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/profile")
    public UserDTO getUserInformation(Principal principal) {
        UserDTO user = null;
        if (Objects.nonNull(principal)) {
            user = userService.getUserInformation(principal.getName());
        }
        return user;
    }

}
