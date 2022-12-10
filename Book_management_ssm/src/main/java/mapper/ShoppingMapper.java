package mapper;

import domain.Shopping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShoppingMapper {
//    根据用户名以及书名，查询一下购物车里是否已有相应记录
    public Shopping findShoppingByUsernameAndName(@Param(value = "username") String username, @Param(value = "name") String name);

    //根据书的id将订单数量存储到数据库中
    public void addByBookId(@Param(value = "img") String img,@Param(value = "username") String username,@Param(value = "name") String name,@Param(value = "number") int number,@Param(value = "price") int price);

//    根据书的id将订单数量存入数据库，库中有相应的数据
    public void updateByBookId(@Param(value = "username") String username,@Param(value = "name")String name,@Param(value = "number") int number);

    //根据username去相应的购物车：获取user对应的所有订单
    public List<Shopping> showByUsername(@Param(value = "username") String username);

    //根据username,name删除订单
    public void deleteByName(@Param(value = "username") String username,@Param(value = "name") String name);
}
