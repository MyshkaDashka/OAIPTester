package by.home.dto;

/**
 * Created by Darya on 29.04.16.
 */
public class StudentDTO extends UserDTO {

    private String name;

    private String lastName;

    private String fatherName;

    private String group;

    private String email;

    private String phoneNumber;

    public StudentDTO(){
    }

    public StudentDTO(String name,String lastName, String fatherName, String group, String email, String phoneNumber){
        this.name = name;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.group = group;
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
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
