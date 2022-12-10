package service;

import domain.User;

import java.util.List;

public interface UserService {
    //查询是否有此用户名和密码相匹配的用户
    public User findByUserNameAndPasswd(String username, String password);

    //查询所有用户
    public List<User> findAll();
}
