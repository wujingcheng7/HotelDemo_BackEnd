package com.wujingcheng7.hoteldemo_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Map3D")
public class Map3DController {
    @GetMapping("")
    public String getHtml(){
        return "/Map3D";
    }
}
