package com.wujingcheng7.hoteldemo_backend.controller;

import com.wujingcheng7.hoteldemo_backend.config.Result;
import com.wujingcheng7.hoteldemo_backend.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
    @GetMapping("")
    public String AccountHtml(){return "/account";}

    public String AccountModify(Account account){
        Result result = new Result();
return "h";
    }
}
