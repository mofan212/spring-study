package indi.mofan.proxy;

/**
 * @author mofan
 * @date 2021/10/10 14:34
 */
public class UserServiceImpl implements UserService {
    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register 业务运算 +  DAO 调用");
    }

    @Override
    public boolean login(String username, String password) {
        System.out.println("UserServiceImpl.login");
        return false;
    }
}
