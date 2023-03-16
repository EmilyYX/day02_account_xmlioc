package com.yanxia.study.test;


import com.yanxia.study.domain.Account;
import com.yanxia.study.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

/**
 * 使用Junit单元测试配置
 */
public class AccountServiceTest {
    @Test
    public void testFindAll() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        List<Account> accountList = as.findAllAccount();
        for(Account account: accountList){
            System.out.println(account);
        }
    }
    @Test
    public void testFindAcById(int i) throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        Account account = as.findAccountById("1");
        System.out.println(account);
    }
    @Test
    public void testUpdateAc() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        Account account = new Account();
        account.setId(1);
        account.setMoney(Float.valueOf(2000));
        as.updateAccount(account);
    }
}
