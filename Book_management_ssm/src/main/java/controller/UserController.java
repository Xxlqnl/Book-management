package controller;

import domain.Admin;
import domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.AdminService;
import service.UserService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;


    @RequestMapping(value = "/loginCheck")
    //user登录验证
    public ModelAndView userLoginCheck(@Param(value = "username") String username, String password, HttpSession session){

        //查询user是否有此用户名和密码相匹配的用户
        User user= userService.findByUserNameAndPasswd(username, password);
        //将user存储到session中
        session.setAttribute("user",user);

        ModelAndView modelAndView = new ModelAndView();
        if(user!=null){

            modelAndView.addObject("classly","儿童读物");
            modelAndView.setViewName("redirect:/book/index");
        }else {
            modelAndView.addObject("msg","账号或密码输入错误，请重试");
            modelAndView.setViewName("/Login/login.jsp");
        }
        return modelAndView;
    }



    //管理跳转到注册页面
    @RequestMapping(value = "registered")
    public String registered(){
        return "/Login/login2.jsp";
    }

    //退出登录：管理跳转到登录页面
    @RequestMapping(value = "/login")
    public String login(HttpSession session){
//        session.setAttribute("user",null);
//        session.setAttribute("admin",null);
        return "/Login/login.jsp";
    }
}
