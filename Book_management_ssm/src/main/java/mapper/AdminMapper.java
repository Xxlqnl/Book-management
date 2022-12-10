package mapper;

import domain.Admin;
import domain.User;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    //查询是否有此用户名和密码相匹配的用户
    public Admin findByUserNameAndPasswd(@Param(value = "username") String username, @Param(value = "password") String password);

    //通过用户username修改用户密码
    public void changePassword(@Param(value = "username")String username,@Param(value = "password")String password);


    //查询以下是否已经有该用户名的用户（通过username查询是否已有记录）
    public User findUserByUsername(String username);

    //添加一个用户（通过username和password添加）
    public void addUser(@Param(value = "username") String username, @Param(value = "password") String password);


    //删除用户，通过username，因为username唯一
    public  void deleteUser(String username);

    //图书管理：上传一本书
    public void upBook(@Param(value = "img") String img,@Param(value = "name")String name,@Param(value = "price")int price,@Param(value = "classly")String classly,@Param(value = "detail")String detail);

    //根据书名删除该书
    public void deleteBook(String name);

    //    根据所选类别(name)修改图书信息
    public void modifyNameByImg(@Param(value = "content")String content,@Param(value = "img")String img);
    //    根据所选类别(name)修改图书信息
    public void modifyPriceByImg(@Param(value = "content")int content,@Param(value = "img")String img);
    //    根据所选类别(name)修改图书信息
    public void modifyDetailByImg(@Param(value = "content")String content,@Param(value = "img")String img);
}
