package service.impl;

import domain.Books;
import domain.Shopping;
import mapper.BooksMapper;
import mapper.ShoppingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ShoppingService;

import java.util.List;

@Service("shoppingService")
public class ShoppingServiceImpl implements ShoppingService {
    @Autowired
    private ShoppingMapper shoppingMapper;
    @Autowired
    private BooksMapper booksMapper;


    //根据书的id将订单数量存储到数据库中
    @Override
    public void addByBookId(int id, int number,String username) {
        Books books = booksMapper.findById(id);
        String img=books.getImg();
        String name=books.getName();
        int price=books.getPrice();
//        判断以下购物车里是否已有相应数据
        Shopping shoppingByUsernameAndName = shoppingMapper.findShoppingByUsernameAndName(username, name);
        if(shoppingByUsernameAndName!=null){
            int number_new=number+shoppingByUsernameAndName.getNumber();
            shoppingMapper.updateByBookId(username,name,number_new);
        }else {
            shoppingMapper.addByBookId(img,username,name,number,price);
        }
    }



    //根据username去相应的购物车：获取user对应的所有订单
    @Override
    public List<Shopping> showByUsername(String username) {
        return shoppingMapper.showByUsername(username);
    }

//    //根据书的id修改购物车内书的数量
    @Override
    public void changeBookNumber(String username,String name, int number) {
        if(number!=0){
            shoppingMapper.updateByBookId(username,name,number);
        }else{
            //删除该项
            shoppingMapper.deleteByName(username,name);
        }

    }
}
