package service;

import domain.User;

public interface UserService {
    //查询是否有此用户名和密码相匹配的用户
    public User findByUserNameAndPasswd(String username, String password);
}
