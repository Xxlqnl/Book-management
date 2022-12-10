package service;

import domain.Shopping;

import java.util.List;

public interface ShoppingService {
    //根据书的id将订单数量存储到数据库中
    public void addByBookId(int id,int number,String username);


    //根据username去相应的购物车：获取user对应的所有订单
    public List<Shopping> showByUsername(String username);


    //根据书的id修改购物车内书的数量
    public void changeBookNumber(String username,String name ,int number);
}
