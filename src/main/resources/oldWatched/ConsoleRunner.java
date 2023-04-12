package oldWatched;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.exceptions.ValidationException;
import softuni.services.ExecutorService;
import softuni.services.UserService;


import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final ExecutorService executorService;

    @Autowired
    public ConsoleRunner(ExecutorService executorService) {
        this.executorService = executorService;
    }


    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        String commandData = scanner.nextLine();

        String result;

        try {
            result = executorService.execute(command, commandData);
        } catch (ValidationException exception) {
            result = exception.getMessage();
        }

        System.out.println(result);
    }
}
