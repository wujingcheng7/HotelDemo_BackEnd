package com.wujingcheng7.hoteldemo_backend.controller;

import com.wujingcheng7.hoteldemo_backend.config.Result;
import com.wujingcheng7.hoteldemo_backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login_backend")
public class LoginBackEndController {
    @Autowired
    private AccountService accountService;

    @GetMapping("")
    public String html(){
        return "/login_backend";
    }

    @PostMapping("")
    public String AdminLogin(HttpServletRequest request, Model model){
        String hotel_admin_id = (String)request.getAttribute("hotel_admin_id");
        String hotel_id = (String)request.getAttribute("hotel_id");
        String hotel_admin_psw = (String)request.getAttribute("hotel_admin_psw");
        Result result = accountService.AdminLogin(hotel_admin_id,hotel_admin_psw);
        if(result.isSuccess()) {
            HttpSession session = request.getSession();
            session.setAttribute("isLogin",1);
            session.setAttribute("hotel_admin_id",hotel_admin_id);
            return "redirect:/bookinfo_backend";
        }
        else {
            model.addAttribute("msg","用户名或密码错误");
            return "/login_backend";
        }
    }

}
