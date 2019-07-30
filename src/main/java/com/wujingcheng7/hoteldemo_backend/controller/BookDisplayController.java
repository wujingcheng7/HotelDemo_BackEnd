package com.wujingcheng7.hoteldemo_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book_diaplay")
public class BookDisplayController {
    @GetMapping("")
    public String book_display(){
        return "/book_display";
    }
}
