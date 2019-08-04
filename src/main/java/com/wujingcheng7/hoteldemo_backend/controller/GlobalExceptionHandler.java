package com.wujingcheng7.hoteldemo_backend.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e, Model model,HttpServletRequest servletRequest){
        String wrong_url = servletRequest.getRequestURL().toString();
        String message = e.getMessage();
        System.out.println("异常地址："+wrong_url);
        System.out.println("异常信息："+message);
        model.addAttribute("wrong_url",wrong_url);
        model.addAttribute("message",message);
        return e.getMessage();
    }

}
