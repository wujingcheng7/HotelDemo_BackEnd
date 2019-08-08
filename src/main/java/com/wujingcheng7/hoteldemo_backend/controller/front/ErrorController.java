package com.wujingcheng7.hoteldemo_backend.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
    @GetMapping("/error")
    public String errorPage(){
return "index";
    }
}
