package com.wujingcheng7.hoteldemo_backend.controller;
import com.wujingcheng7.hoteldemo_backend.domain.Account;
import com.wujingcheng7.hoteldemo_backend.service.AccountService;
import com.wujingcheng7.hoteldemo_backend.config.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    /*
    * 注册
    * */
    @RequestMapping(value = "/regist", method = { RequestMethod.GET, RequestMethod.POST })
    public Result regist(Account account){
        return accountService.regist(account);
    }

    /*
    * 登录
    * */
    @RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
    public Result login(Account account){
        return accountService.login(account);
    }
    @RequestMapping("/test")
    public void test(){;}
}
