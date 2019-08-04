package com.wujingcheng7.hoteldemo_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

//@Controller
@RequestMapping("/error")
public class ExceptionController {
    @GetMapping("/error")
    public String getHtml(Model model, HttpServletRequest servletRequest,Exception e){
        String wrong_url = servletRequest.getRequestURL().toString();
        String message = e.getMessage();
        model.addAttribute("wrong_url",wrong_url);
        model.addAttribute("message",message);
        return "/error";
    }

}
