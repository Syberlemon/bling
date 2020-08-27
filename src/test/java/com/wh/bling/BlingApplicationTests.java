package com.wh.bling;

import com.wh.bling.controller.AccountController;
import com.wh.bling.req.GetAccountReq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlingApplicationTests {

    @Autowired
    private AccountController accountController;

    @Test
    public void test(){
        GetAccountReq req = new GetAccountReq();
        req.setName("qq");
        System.out.println(accountController.getAccount(req));
    }

}
