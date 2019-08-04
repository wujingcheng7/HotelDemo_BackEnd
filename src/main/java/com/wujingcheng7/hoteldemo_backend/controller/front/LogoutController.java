package com.wujingcheng7.hoteldemo_backend.controller.front;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/logout")
public class LogoutController {
    @GetMapping("")
    public String Logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();//清除session
        return "/login";
    }
}
