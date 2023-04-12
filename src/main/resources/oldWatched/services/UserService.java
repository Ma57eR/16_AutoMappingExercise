package softuni.services;

import softuni.entities.users.LoginUserDTO;
import softuni.entities.users.RegisterDTO;
import softuni.entities.users.User;

import java.util.Optional;

public interface UserService {


    User register(RegisterDTO registerData);

    Optional<User> login(LoginUserDTO loginData);

    User getLoggedUser();

    void logout();
}
