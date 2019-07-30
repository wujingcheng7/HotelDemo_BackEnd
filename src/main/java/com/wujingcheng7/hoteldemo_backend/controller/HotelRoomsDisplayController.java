package com.wujingcheng7.hoteldemo_backend.controller;

import com.wujingcheng7.hoteldemo_backend.service.HotelRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rooms_display")
public class HotelRoomsDisplayController {
    @Autowired
    HotelRoomService hotelRoomService;

    @GetMapping("")
    public String getHtml(){
        return "/rooms_display";
    }

//    @PostMapping("")

}
