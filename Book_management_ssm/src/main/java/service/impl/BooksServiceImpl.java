package service.impl;

import domain.Books;
import mapper.BooksMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BooksService;

import java.util.List;

@Service("booksService")
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksMapper booksMapper;


    //根据图书类别获取相应的所有图书
    @Override
    public List<Books> findAllByClassly(String classly) {
        return booksMapper.findAllByClassly(classly);
    }
    //根据id查询图书
    public Books findById(int id){
        return booksMapper.findById(id);
    }

    //查询所有图书
    public List<Books> findAll(){
       return booksMapper.findAll();
    }

    //根据name查询图书
    @Override
    public Books findByName(String name) {
        return booksMapper.findByName(name);
    }

    //根据img查询图书
    @Override
    public Books findByImg(String img) {
        return booksMapper.findByImg(img);
    }
}
