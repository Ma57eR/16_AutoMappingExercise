package softuni.services;

public interface ExecutorService {
    String REGISTER_USER_COMMAND = "RegisterUser";
    String LOGIN_USER_COMMAND = "LoginUser";
    String LOGOUT_USER_COMMAND = "Logout";
    String ADD_GAME_COMMAND = "AddGame";

    String execute(String command, String commandData) ;

    String REGISTER_USER_JSON = """
    RegisterUser|<email>|<password>|<confirmPassword>|<fullName>
    {

        "email": "pesho22@mail.com",
        "password": "1234567",
        "confirmPassword": "1234567",
        "fullName": "Pesho 123"
    }
""";

    String LOGIN_USER_JSON = """
    LoginUser|<email>|<password>
    {

        "email": "pesho22@mail.com",
        "password": "Pesho 123"
    }
""";
}
