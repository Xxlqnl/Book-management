package mapper;

import domain.Books;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface BooksMapper {
    //根据图书类别获取相应的所有图书
    public List<Books> findAllByClassly(@Param(value = "classly") String classly);

    //根据id查询图书
    public Books findById(int id);

    //查询所有图书
    public List<Books> findAll();

    //根据id查询图书
    public Books findByName(String name);

    //根据img查询图书
    public Books findByImg(String img);
}
