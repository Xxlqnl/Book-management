package controller;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login")
    //登录验证
    public ModelAndView userLoginCheck(String username, String password, HttpSession session){
        System.out.println(2222);
        //查询是否有此用户名和密码相匹配的用户
        User user = userService.findByUserNameAndPasswd(username, password);
        ModelAndView modelAndView = new ModelAndView();
        if(user!=null){
            System.out.println(11111);
            //说明登录成功，将user存储到session中
            session.setAttribute("user",user);
            modelAndView.addObject("classly","儿童读物");
            modelAndView.setViewName("/Index/index.jsp");
            return modelAndView;
        }
        System.out.println("fdsafdsfse");
        modelAndView.setViewName("/Login/login.jsp");
        return modelAndView;
    }
}
