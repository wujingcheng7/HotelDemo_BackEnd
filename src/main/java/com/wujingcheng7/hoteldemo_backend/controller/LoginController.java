package com.wujingcheng7.hoteldemo_backend.controller;

import com.wujingcheng7.hoteldemo_backend.config.Result;
import com.wujingcheng7.hoteldemo_backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private AccountService accountService;
    /*
     * 登录
     * */
    @GetMapping("")
    public String LoginHtml(){return "/login";}
    @PostMapping("")
    public String login(@RequestParam("user_tel") String user_tel, @RequestParam("user_password") String user_password){
        Result result;
        result = accountService.login(user_tel,user_password);
        if(result.isSuccess())
            return "redirect:/index";
        else
            return "用户名或密码错误";
    }
}
