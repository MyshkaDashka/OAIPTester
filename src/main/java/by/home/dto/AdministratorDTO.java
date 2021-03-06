package by.home.dto;

/**
 * Created by Darya on 29.04.16.
 */
public class AdministratorDTO extends UserDTO {

    private String name;

    private String lastName;

    private String fatherName;

    private String cabinet;

    private String email;

    private String phoneNumber;

    public AdministratorDTO(){}

    public AdministratorDTO(String name, String lastName, String fatherName, String cabinet, String email, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.cabinet = cabinet;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getCabinet() {
        return cabinet;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
