package by.home.dto;

import by.home.enums.Role;


public class UserDTO {

    private String login;

    private Role role;

    public UserDTO() {
    }

    public UserDTO(String login, Role role) {
        this.login = login;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
