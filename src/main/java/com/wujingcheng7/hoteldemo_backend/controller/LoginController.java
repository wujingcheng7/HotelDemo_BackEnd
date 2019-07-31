package com.wujingcheng7.hoteldemo_backend.controller;

import com.wujingcheng7.hoteldemo_backend.config.Result;
import com.wujingcheng7.hoteldemo_backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


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
    public String login(HttpServletRequest request, Model model){
        String user_tel = request.getParameter("user_tel");
        String user_password = request.getParameter("user_password");
        Result result = accountService.login(user_tel,user_password);
        if(result.isSuccess()) {
            HttpSession session = request.getSession();
            session.setAttribute("isLogin",1);
            session.setAttribute("user_tel",user_tel);
            session.setAttribute("user_name",result.getDetail());
            return "redirect:/index";
        }
        else {
            model.addAttribute("msg","用户名或密码错误");
            return "/login";
        }
    }
}
