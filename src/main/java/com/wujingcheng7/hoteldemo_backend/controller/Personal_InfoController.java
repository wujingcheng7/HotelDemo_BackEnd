package com.wujingcheng7.hoteldemo_backend.controller;

import com.wujingcheng7.hoteldemo_backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/personal_info")
public class Personal_InfoController {

    @Autowired
    AccountService accountService;
    @GetMapping("/")
    public String getPage(){
        return "/personal_info";
    }

    @GetMapping("")
    public String getHtml(){
        return "/personal_info";
    }

    @PostMapping("")
    public Model personal_info_update(@RequestParam("user_tel") String user_tel,@RequestParam("user_password") String user_password ,@RequestParam("user_name") String user_name ,@RequestParam("user_sex") String user_sex ,@RequestParam("user_bankcard") String user_bankcard , Model model){
        if (user_tel.equals("TEL"))
            return model;
        if(!user_password.equals("password"))
            accountService.updatePassword(user_password,user_tel);
        if (!user_name.equals("name"))
            accountService.updateName(user_name,user_tel);
        if (!user_sex.equals("sex"))
            accountService.updateSex(user_sex,user_tel);
        if (!user_bankcard.equals("bankcard"))
            accountService.updateBankcard(user_bankcard,user_tel);
        return model;
    }

}
