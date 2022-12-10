package service;

import domain.Admin;
import domain.User;

public interface AdminService {
    //查询是否有此用户名和密码相匹配的用户
    public Admin findByUserNameAndPasswd(String username, String password);

    //通过用户username修改用户密码
    public void changePassword(String username,String password);


    //查询以下是否已经有该用户名的用户（通过username查询是否已有记录）
    public User findUserByUsername(String username);


    //添加一个用户（通过username和password添加）
    public void addUser(String username,String password);

    //删除用户，通过username，因为username唯一
    public  void deleteUser(String username);

    //图书管理：上传一本书
    public void upBook(String img,String name,int price,String classly,String detail);

    //根据书名删除该书
    public void deleteBook(String name);

    //    根据所选类别修改图书信息
    public void modifyBookBySpecies(String species,String content,String img);
}
