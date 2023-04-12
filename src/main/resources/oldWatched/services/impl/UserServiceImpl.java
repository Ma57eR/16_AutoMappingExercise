package softuni.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.entities.users.LoginUserDTO;
import softuni.entities.users.RegisterDTO;
import softuni.entities.users.User;
import softuni.repositories.UserRepository;
import softuni.services.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private User currentUser;

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.currentUser = null;
        this.userRepository = userRepository;
    }


    @Override

    public User register(RegisterDTO registerData) {

        ModelMapper mapper = new ModelMapper();

        User toRegister = mapper.map(registerData, User.class);

        long userCount = this.userRepository.count();
        if (userCount == 0) {
            toRegister.setAdmin(true);
        }
        return this.userRepository.save(toRegister);
    }

    @Override
    public Optional<User> login(LoginUserDTO loginData) {
        Optional<User> user = this.userRepository.findByEmailAndPassword(
                loginData.getEmail(),
                loginData.getPassword());

        user.ifPresent(value -> this.currentUser = value);

        return user;

    }

    @Override
    public User getLoggedUser() {
        return this.currentUser;
    }

    public User getCurrentLoggedUser() {
        return this.currentUser;
    }

    @Override
    public void logout() {
        this.currentUser = null;

    }
}
