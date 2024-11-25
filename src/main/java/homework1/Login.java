package homework1;

import java.util.List;

public class Login implements LoginOperation {

    private List<User> users;

    public Login(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("登录成功！");
                return true;
            }
        }
        System.out.println("登录失败！用户名或密码错误。");
        return false;
    }
}