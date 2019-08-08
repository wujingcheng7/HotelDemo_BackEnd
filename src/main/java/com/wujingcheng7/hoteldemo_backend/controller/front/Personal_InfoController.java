package com.wujingcheng7.hoteldemo_backend.controller.front;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.wujingcheng7.hoteldemo_backend.domain.Account;
import com.wujingcheng7.hoteldemo_backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/personal_info")
public class Personal_InfoController {

    @Autowired
    AccountService accountService;
    @GetMapping("")
    public String personal_info(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        String user_tel = (String) session.getAttribute("user_tel");
        Account account = accountService.getUserByTel(user_tel);
        model.addAttribute("user_tel",user_tel);
        if (account.getUser_sex()==null||account.getUser_sex().equals(""))
            model.addAttribute("user_sex","请完善信息");
        else
            model.addAttribute("user_sex",account.getUser_sex());
        if (account.getUser_bankcard()==null||account.getUser_bankcard().equals(""))
            model.addAttribute("user_bankcard","请完善信息");
        else
            model.addAttribute("user_bankcard",account.getUser_bankcard());
        if (account.getUser_name()==null||account.getUser_name().equals(""))
            model.addAttribute("user_name","请完善信息");
        else
            model.addAttribute("user_name",account.getUser_name());
        return "/personal_info";
    }

    @GetMapping("/modify")
    public String personal_info_updatehtml(){return "/personal_info_modify";}
    @PostMapping("/modify")
    public String personal_info_update(HttpServletRequest request, @RequestParam("user_password") String user_password , @RequestParam("user_name") String user_name , @RequestParam("user_sex") String user_sex , @RequestParam("user_bankcard") String user_bankcard , Model model){
        HttpSession session = request.getSession();
        String user_tel = (String) session.getAttribute("user_tel");
        if (user_tel.equals("")||user_tel.equals("TEL"))
            return "redirect:/personal_info";
        if(!user_password.equals("password"))
            accountService.updatePassword(user_password,user_tel);
        if (!user_name.equals("name"))
            accountService.updateName(user_name,user_tel);
        if (!user_sex.equals("sex"))
            accountService.updateSex(user_sex,user_tel);
        if (!user_bankcard.equals("bankcard"))
            accountService.updateBankcard(user_bankcard,user_tel);
        return "redirect:/personal_info";
    }

    @GetMapping("/modifyPassword")
    public String modifyPasswordHtml(){
        return "modifyPassword";
    }

    @PostMapping("/modifyPassword")
    public String modifyPassword(HttpServletRequest request, Model model,@RequestParam("user_password") String user_password){
        HttpSession session = request.getSession();
        String user_tel = (String) session.getAttribute("user_tel");
        accountService.updatePassword(user_password,user_tel);
        return "/login";
    }
}
