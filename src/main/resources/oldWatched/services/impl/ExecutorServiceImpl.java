package softuni.services.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.users.LoginUserDTO;
import softuni.entities.users.RegisterDTO;
import softuni.entities.users.User;
import softuni.entities.users.UserBasicInfoDTO;
import softuni.services.ExecutorService;
import softuni.services.UserService;

@Service
public class ExecutorServiceImpl implements ExecutorService {

    private final UserService userService;

    private final Gson gson;

    //private final ModelMapper modelMapper;

    @Autowired
    public ExecutorServiceImpl(UserService userService, Gson gson ) {
        this.userService = userService;
        //this.modelMapper = modelMapper;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }


    @Override
    public String execute(String commandName, String commandData) {


        String commandOutput = switch (commandName) {
//            case REGISTER_USER_COMMAND -> registerUser(commandData);
//            case LOGIN_USER_COMMAND -> loginUser(commandData);
//            case LOGOUT_USER_COMMAND -> logoutUser(commandData);
//            case ADD_GAME_COMMAND -> addGame();
            default -> "unknown command";
        };

        return this.gson.toJson(commandOutput);

    }

    private String addGame() {
        User loggedUser = this.userService.getLoggedUser();

        if (!loggedUser.isAdmin()) {
      //      throw new
        }
        return null;
    }


    private String logoutUser(String[] commandParts) {
        User loggedUser = this.userService.getLoggedUser();

        this.userService.logout();
        return String.format("User %s successfully logged out.",
                loggedUser.getFullName());
    }

//    private String loginUser(String[] commandParts) {
//        LoginUserDTO loginData = new LoginUserDTO(commandParts);
//
//        Optional<User> user = userService.login(loginData);
//
//        if (user.isPresent()) {
//
//            return String.format("%s was logged in",
//                    user.get().getFullName());
//        } else {
//            return "Wrong credentials";
//        }
//    }

    private UserBasicInfoDTO registerUser(String commandData) {
        RegisterDTO registerData = this.gson.fromJson(commandData, RegisterDTO.class);
        registerData.validate();
        User user = userService.register(registerData);

        //return this.modelMapper.map(user, UserBasicInfoDTO.class);
        return null;
    }
}
