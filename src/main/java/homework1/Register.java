package homework1;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Register implements RegisterOperation {

    private List<User> users = new ArrayList<>();

    @Override
    public void register(String username, String password) {
        User user = new User(username, password);
        users.add(user);
        System.out.println("注册成功！");
    }

    public List<User> getUsers() {
        return users;
    }
}
