package softuni.entities.users;


import softuni.exceptions.ValidationException;

public class RegisterDTO {
    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;




    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void validate() {
        // when ok
        int indexOfAt = email.indexOf("@");
        int indexOfDot = email.lastIndexOf(".");
        if (indexOfAt < 0 || indexOfDot < 0 || indexOfDot < indexOfAt) {
            throw new ValidationException("Email must contains @ and .");
        }

        if (!password.equals(confirmPassword)) {
            throw new ValidationException("Password must match!");
        }

    }
}
