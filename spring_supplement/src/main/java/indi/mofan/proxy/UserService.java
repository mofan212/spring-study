package indi.mofan.proxy;

/**
 * @author mofan
 * @date 2021/10/10 14:32
 */
public interface UserService {
    /**
     * 用户注册
     *
     * @param user 注册的用户信息
     */
    void register(User user);

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 用户密码
     * @return 是否登录成功
     */
    boolean login(String username, String password);
}
