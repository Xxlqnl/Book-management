package controller;

import domain.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.BooksService;

import java.util.List;

@Controller
@RequestMapping(value = "book")
public class BooksController {
    @Autowired
    private BooksService booksService;

    //决定是user的哪个主页
    @RequestMapping(value = "index")
    public ModelAndView classly1(String classly){
        ModelAndView modelAndView = new ModelAndView();
        //根据图书类别获取相应的所有图书
        List<Books> booksList=booksService.findAllByClassly(classly);
        System.out.println(booksList);
        modelAndView.addObject("booksList",booksList);

        //决定接下来去哪个视图
        // 原有的
//        switch (classly){
//            case "儿童读物":modelAndView.setViewName("/Index/index.jsp");
//            case "青年读物":modelAndView.setViewName("/Index/index1.jsp");
//            case "科普百科":modelAndView.setViewName("/Index/index2.jsp");
//            case "卡通动漫":modelAndView.setViewName("/Index/index3.jsp");
//            case "名著宝藏":modelAndView.setViewName("/Index/index4.jsp");
//            break;
//        }
        modelAndView.setViewName("index.jsp");
//        modelAndView.setViewName("/book/index.jsp");

//        测试
//        modelAndView.setViewName("/WEB-INF/pages/accountList.jsp");
        return modelAndView;
    }

    //根据id查询图书
    @RequestMapping(value = "details")
    public ModelAndView findById(int id){
        Books book = booksService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("book","book");

        modelAndView.addObject("name",book.getName());
        modelAndView.addObject("img",book.getImg());
        modelAndView.addObject("price",book.getPrice());
        modelAndView.addObject("detail",book.getDetail());
        modelAndView.addObject("id",id);
        modelAndView.setViewName("/book/details.jsp");
        return modelAndView;
    }
}
