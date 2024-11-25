package homework1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Register register = new Register();
        register.register("user1", "pass1");

        List<User> users = register.getUsers();

        Login login = new Login(users);
        login.login("user1", "pass1");
        login.login("user2", "pass2");
    }
}