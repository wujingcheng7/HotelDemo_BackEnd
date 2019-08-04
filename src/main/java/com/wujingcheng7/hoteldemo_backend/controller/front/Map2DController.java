package com.wujingcheng7.hoteldemo_backend.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Map2D")
public class Map2DController {
    @GetMapping("")
    public String getHtml(){
        return "/Map2D";
    }
}
