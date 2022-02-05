package indi.mofan.proxy;

/**
 * UserServiceImpl 的代理类
 *
 * @author mofan
 * @date 2021/10/10 14:37
 * @see UserServiceImpl
 */
public class UserServiceProxy implements UserService {
    private UserServiceImpl userService = new UserServiceImpl();

    @Override
    public void register(User user) {
        System.out.println("--- log ---");
        userService.register(user);
    }

    @Override
    public boolean login(String username, String password) {
        System.out.println("--- log ---");
        return userService.login(username, password);
    }
}
