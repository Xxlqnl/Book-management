package service;

import domain.Books;

import java.util.List;

public interface BooksService {
    //根据图书类别获取相应的所有图书
    public List<Books> findAllByClassly(String classly);

    //根据id查询图书
    public Books findById(int id);

    //查询所有图书
    public List<Books> findAll();

    //根据name查询图书
    public Books findByName(String name);

    //根据img查询图书
    public Books findByImg(String img);
}
