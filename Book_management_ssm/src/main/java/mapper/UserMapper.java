package mapper;

import domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //查询是否有此用户名和密码相匹配的用户
    public User findByUserNameAndPasswd(@Param(value = "username") String username,@Param(value = "password") String password);

    //查询所有用户
    public List<User> findAll();
}
