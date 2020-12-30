package wh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wh.mapper.AccountMapper;
import wh.req.GetAccountReq;
import wh.req.GetAccountRes;

import java.util.List;


/**
 * @author froid
 * @date 2020/8/25 21:33
 * 解决经常忘记密码的问题
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
