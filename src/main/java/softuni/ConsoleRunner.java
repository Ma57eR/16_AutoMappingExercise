package softuni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.services.UserService;


import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final String REGISTER_USER_COMMAND = "RegisterUser";
    private final String LOGIN_USER_COMMAND = "LoginUser";
    private final String LOGOUT_USER_COMMAND = "Logout";

    private final UserService userService;

    @Autowired
    public ConsoleRunner(UserService userService) {
        this.userService = userService;
    }

    private String execute(String commandLine) {
        String[] commandParts = commandLine.split("\\|");

        String commandName = commandParts[0];

//        String commandOutput = switch (commandName) {
//            case REGISTER_USER_COMMAND -> userService.register();
//            case LOGIN_USER_COMMAND -> userService.login();
//            case LOGOUT_USER_COMMAND -> userService.logout();
//            default -> "unknown command";
//        };
//
//        return commandOutput;
        return "koko";

    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        System.out.println(execute(command));
    }
}
