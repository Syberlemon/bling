package com.wh.bling.controller;

import com.wh.bling.mapper.AccountMapper;
import com.wh.bling.req.GetAccountReq;
import com.wh.bling.req.GetAccountRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author froid
 * @date 2020/8/25 21:33
 */
@RestController
public class AccountController {
    @Autowired
    private AccountMapper accountMapper;

    @RequestMapping("/getAccount")
    public List<GetAccountRes> getAccount(GetAccountReq req) {
        return accountMapper.getAccounts(req);
    }
}
