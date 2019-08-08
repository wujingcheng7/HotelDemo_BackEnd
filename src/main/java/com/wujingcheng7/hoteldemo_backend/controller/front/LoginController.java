package com.wujingcheng7.hoteldemo_backend.controller.front;

import com.wujingcheng7.hoteldemo_backend.config.Result;
import com.wujingcheng7.hoteldemo_backend.domain.Account;
import com.wujingcheng7.hoteldemo_backend.domain.UserQuestion;
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
        Result result = accountService.UserLogin(user_tel,user_password);
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

    @GetMapping("/findPassword/verifyAccount")
    public String findPassword(HttpServletRequest request, Model model){
        String user_tel = request.getParameter("user_tel");
        Account account = accountService.getUserByTel(user_tel);
        if (account==null) {
            model.addAttribute("verify", "该手机号不存在");
            return "/login";
        }
        else
            return "redirect:/findPassword/verify";
    }

    @GetMapping("/findPassword/verified")
    public String verifyQuestion(HttpServletRequest request, Model model){
        String user_tel = request.getParameter("user_tel");
        String userQuestion = accountService.getUserQuestion(user_tel);
        model.addAttribute("question",userQuestion);
        return "UserQuestion";//问答界面
    }

    @PostMapping("/findPassword/verified")
    public String verifyAnswer(HttpServletRequest request, Model model){
        String user_tel = request.getParameter("user_tel");
        String user_answer_now = request.getParameter("user_answer_now");//用户输入的答案
        Boolean isRight = accountService.isRight(user_tel,user_answer_now);
        if (isRight) {
            return "redirect:/modifyPassword";//修改密码
        }
        else {
            model.addAttribute("answer", "答案错误");
            return "/findPassword/verified";//跳回答案界面
        }
    }
}
