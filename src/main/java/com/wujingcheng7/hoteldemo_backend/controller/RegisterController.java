package com.wujingcheng7.hoteldemo_backend.controller;
import com.wujingcheng7.hoteldemo_backend.domain.Account;
import com.wujingcheng7.hoteldemo_backend.service.AccountService;
import com.wujingcheng7.hoteldemo_backend.config.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    public Result Register(HttpServletRequest request){
        Account account = new Account();
        String user_tel = request.getParameter("user_tel");
        String user_password = request.getParameter("user_password");
        account.setUser_tel(user_tel);
        account.setUser_password(user_password);
        account.toString();
        return accountService.regist(account);
    }
}
