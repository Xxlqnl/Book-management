package mapper;

import domain.Account;

import java.util.List;

public interface AccountMapper {
//    保存
    public void save(Account account);
//    查询所有
    public List<Account> findAll();
}
