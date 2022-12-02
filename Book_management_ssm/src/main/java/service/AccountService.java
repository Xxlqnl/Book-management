package service;

import domain.Account;

import java.util.List;

public interface AccountService {
    //    保存
    public void save(Account account);
    //    查询所有
    public List<Account> findAll();
}
