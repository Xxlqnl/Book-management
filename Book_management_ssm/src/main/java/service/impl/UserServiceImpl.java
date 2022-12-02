package service.impl;

import domain.User;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUserNameAndPasswd(String username, String password) {
        return userMapper.findByUserNameAndPasswd(username,password);
    }
}
