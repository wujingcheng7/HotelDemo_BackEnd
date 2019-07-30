package com.wujingcheng7.hoteldemo_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personal-info")
public class Personal_InfoController {

    @GetMapping("")
    public String personal_info(){
        return "/personal_info";
    }

}
