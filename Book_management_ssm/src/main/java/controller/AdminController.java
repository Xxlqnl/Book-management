package controller;

import domain.Admin;
import domain.Books;
import domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.AdminService;
import service.BooksService;
import service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller()
@RequestMapping(value = "admin")
public class AdminController {


    @Autowired
    private AdminService adminService;
    @Autowired
    private BooksService booksService;
    @Autowired
    private UserService userService;


    //admin登录验证
    @RequestMapping(value = "/loginCheck")
    public ModelAndView userLoginCheck(@Param(value = "username") String username, String password, HttpSession session){
        //查询admin是否有此用户名和密码相匹配的用户
        Admin admin = adminService.findByUserNameAndPasswd(username, password);
        //将admin存储到session中
        session.setAttribute("admin",admin);

        ModelAndView modelAndView = new ModelAndView();

        if(admin!=null){
            modelAndView.setViewName("redirect:/admin/index");
        }else {
            modelAndView.addObject("msg","账号或密码输入错误，请重试");
            modelAndView.setViewName("/Login/login.jsp");}
        return modelAndView;
    }

    //管理跳转到登录页面
    @RequestMapping(value = "/login")
    public String login(){
        return "/Login/adlogin.jsp";
    }


    //管理跳转到管理员的adindex.jsp(图书后台管理)
    @RequestMapping(value = "index")
    public ModelAndView toadindex(){
        //查询所有的书
        List<Books> booksList = booksService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("booksList",booksList);
        modelAndView.setViewName("/Administrators/adindex.jsp");
        return modelAndView;
    }


    //管理：跳转到user.jsp（用户管理）
    @RequestMapping(value = "userManagement")
    public ModelAndView userManagement(){
        //查询所有用户
        List<User> userList = userService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("/Administrators/user.jsp");
        return modelAndView;
    }


    //通过用户username修改用户密码
    @RequestMapping(value = "changePassword")
    public ModelAndView changePassword(String username,String new_password){
        System.out.println("66666666");


        //根据username修改password
        adminService.changePassword(username,new_password);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/userManagement");

        return modelAndView;
    }


    //注册用户
    @RequestMapping(value = "userRegistered")
    public ModelAndView addUser(String username,String password){
        //先检验以下是否已经有这个用户名的用户
        User user = adminService.findUserByUsername(username);
        ModelAndView modelAndView = new ModelAndView();
        if (user!=null){
            modelAndView.addObject("msg","该用户名已存在");
        }else {
            adminService.addUser(username,password);
            modelAndView.addObject("msg","注册成功");
        }
        modelAndView.setViewName("/Login/login2.jsp");
        return modelAndView;
    }


    //删除用户，通过username，因为username唯一
    @RequestMapping(value = "deleteUser")
    public String deleteUser(String username){
        adminService.deleteUser(username);
        return "/admin/userManagement";
    }

    //管理：跳转图书上架页面（addbook.jsp）
    @RequestMapping(value = "addBook")
    public ModelAndView addBook(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/Administrators/addbook.jsp");
        return modelAndView;
    }

//上传图书
    @RequestMapping(value = "upBook")
    public ModelAndView upBook(String name, String price, String classly, String detail, MultipartFile img)throws IOException {

//        String img_Path = servletContext.getInitParameter("imgPath");
        String originalFilename = img.getOriginalFilename();
        img.transferTo(new File("F:\\Github_code\\Book_Management\\Book_management_ssm\\src\\main\\webapp\\img\\"+originalFilename));
//        img.transferTo(new File(img_Path+originalFilename));
        String img_really="img\\"+originalFilename;
        Integer price_really = Integer.valueOf(price);
        adminService.upBook(img_really,name,price_really,classly,detail);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","上传成功");
        modelAndView.setViewName("/admin/addBook");
        return modelAndView;
    }

    //图书管理：就是图书的详情及其更改操作，跳转到addetails.jsp页面
    @RequestMapping(value = "bookManagement")
    public ModelAndView bookManagement(String  name){
        Books book = booksService.findByName(name);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("book",book);
        modelAndView.setViewName("/Administrators/addetails.jsp");
        return modelAndView;

    }


    //图书管理，根据书名删除该书
    @RequestMapping(value = "deletBook")
    public String deleteBook(String name){
        adminService.deleteBook(name);
        return "/admin/index";
    }

//    根据所选类别修改图书信息
    @RequestMapping(value = "modify")
    public ModelAndView modifyBookBySpecies(String species,String content,String img){
        adminService.modifyBookBySpecies(species, content,img);
        //根据img查询所有信息
        Books book = booksService.findByImg(img);
        String name = book.getName();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name",name);
        modelAndView.setViewName("redirect:/admin/bookManagement");
        return modelAndView;
    }
}
