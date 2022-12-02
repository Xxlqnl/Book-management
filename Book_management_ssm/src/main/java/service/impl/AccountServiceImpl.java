package service.impl;

import domain.Account;
import mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements service.AccountService {
//    以下是原始整合
//    @Override
//    public void save(Account account) {
//        try {
//            InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//            SqlSession sqlSession = sqlSessionFactory.openSession();
//            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
//            mapper.save(account);
//            sqlSession.commit();
//            sqlSession.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
//
//    @Override
//    public List<Account> findAll() {
//        try {
//            InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//            SqlSession sqlSession = sqlSessionFactory.openSession();
//            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
//            List<Account> accountList = mapper.findAll();
//            sqlSession.commit();
//            sqlSession.close();
//            return accountList;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }


//    升级版

    @Autowired
    private  AccountMapper accountMapper;



    @Override
    public void save(Account account) {
        accountMapper.save(account);
    }

    @Override
    public List<Account> findAll() {

        return accountMapper.findAll();
    }
}
