package com.wujingcheng7.hoteldemo_backend.controller;

import com.wujingcheng7.hoteldemo_backend.domain.Account;
import com.wujingcheng7.hoteldemo_backend.service.AccountService;
import com.wujingcheng7.hoteldemo_backend.config.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private AccountService accountService;
    /*
    * 注册
    * */
    @GetMapping("")
    public String RegisterHtml(){return "/register";}
    @PostMapping("")
    public String Register(@RequestParam("user_tel") String user_tel, @RequestParam("user_password") String user_password,@RequestParam("confirm_password") String confirm_password){
        if (!user_password.equals(confirm_password))
            return "两次密码不一致";
        Account account = new Account();
        account.setUser_tel(user_tel);
        account.setUser_password(user_password);
        account.toString();
        accountService.regist(account);
        return "/login";
    }
}
