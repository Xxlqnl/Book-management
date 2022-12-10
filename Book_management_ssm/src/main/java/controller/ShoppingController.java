package controller;

import domain.Shopping;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.ShoppingService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "shopping")
public class ShoppingController {


    @Autowired
    private ShoppingService shoppingService;

    //根据书的id将订单数量存储到数据库中
   @RequestMapping(value = "add")
    public ModelAndView addByBookId(int id, int number, HttpSession session){
       User user = (User)session.getAttribute("user");
       String username = user.getUsername();
//       System.out.println(username);
       shoppingService.addByBookId(id,number,username);
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.setViewName("/book/shoppingorbuy.jsp");
       return modelAndView;
   }



   //根据username去相应的购物车：获取user对应的所有订单
    @RequestMapping(value = "shoppingCat")
    public ModelAndView showByUsername(HttpSession session){
        User user = (User)session.getAttribute("user");
        String username = user.getUsername();
        List<Shopping> shoppingList = shoppingService.showByUsername(username);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("shoppingList",shoppingList);
        modelAndView.setViewName("/book/shopping.jsp");
        return modelAndView;
    }


    //管理：跳转到支付页面
    @RequestMapping(value = "pay")
    public ModelAndView topay(HttpSession session){
//        int priceAll =(int) session.getAttribute("priceAll");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("priceAll",session.getAttribute("priceAll"));
        modelAndView.setViewName("/book/pay.jsp");
        return modelAndView;
    }


    //根据书的id修改购物车内书的数量
    @RequestMapping(value = "book_num")
    public String changeBookNumber(String name,int num_new,HttpSession session){
        System.out.println(name);
        User user =(User) session.getAttribute("user");
        String uesrname=user.getUsername();
        shoppingService.changeBookNumber(uesrname,name,num_new);
        return "/shopping/shoppingCat";
    }
}
