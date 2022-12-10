package service.impl;

import domain.Admin;
import domain.User;
import mapper.AdminMapper;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AdminService;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin findByUserNameAndPasswd(String username, String password) {
        return adminMapper.findByUserNameAndPasswd(username,password);
    }

    //通过用户username修改用户密码
    @Override
    public void changePassword(String username, String password) {
        adminMapper.changePassword(username, password);
    }


    //查询以下是否已经有该用户名的用户（通过username查询是否已有记录）
    @Override
    public User findUserByUsername(String username) {
        return adminMapper.findUserByUsername(username);
    }

    //添加一个用户（通过username和password添加）
    @Override
    public void addUser(String username, String password) {
        adminMapper.addUser(username, password);
    }

    //删除用户，通过username，因为username唯一
    @Override
    public void deleteUser(String username) {
        adminMapper.deleteUser(username);
    }

    //图书管理：上传一本书
    @Override
    public void upBook(String img, String name, int price, String classly, String detail) {
        adminMapper.upBook(img, name, price, classly, detail);
    }

    //根据书名删除该书
    @Override
    public void deleteBook(String name) {
        adminMapper.deleteBook(name);
    }

    //    根据所选类别修改图书信息
    @Override
    public void modifyBookBySpecies(String species, String content,String img) {
        switch (species){
            case "name":adminMapper.modifyNameByImg(content,img);break;
            case "price":{
                              Integer content_integer = Integer.valueOf(content);
                              adminMapper.modifyPriceByImg(content_integer,img);
                              break;
                         }
            case "detail":adminMapper.modifyDetailByImg(content,img);break;
        }
    }

}
