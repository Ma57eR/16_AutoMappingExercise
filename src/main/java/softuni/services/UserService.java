package softuni.services;

import softuni.entities.User;

public interface UserService {

    User register();

    User login();

    void logout();
}
