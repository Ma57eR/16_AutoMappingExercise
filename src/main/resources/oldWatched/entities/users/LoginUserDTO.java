package softuni.entities.users;

import softuni.exceptions.ValidationException;

public class LoginUserDTO {

    private String email;
    private String password;


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

