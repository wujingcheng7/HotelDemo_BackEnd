package com.wujingcheng7.hoteldemo_backend.controller;

import com.wujingcheng7.hoteldemo_backend.domain.Hotel;
import com.wujingcheng7.hoteldemo_backend.service.HotelSearchService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/hotel_display")
public class HotelSearchController {
    @Autowired
    HotelSearchService hotelSearchService;

    @GetMapping("")
    public String getHtml(){
        return "/hotel_display";
    }

    @PostMapping("")
    public void showHotelList(@Param("hotel_city")String hotel_city,
                              @Param("hotel_name")String hotel_name){
        ArrayList<Hotel> hotels = hotelSearchService.getByCityAndName(hotel_city,hotel_name);
        if (hotels.get(1) == null){
            System.out.println("草泥马没读取成功");
        }else {
            System.out.println("草泥马读取成功了");
        }
    }
}
