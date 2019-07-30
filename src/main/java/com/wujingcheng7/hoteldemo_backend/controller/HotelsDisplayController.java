package com.wujingcheng7.hoteldemo_backend.controller;

import com.wujingcheng7.hoteldemo_backend.domain.Hotel;
import com.wujingcheng7.hoteldemo_backend.service.HotelService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/hotels_display")
public class HotelsDisplayController {
    @Autowired
    HotelService hotelSearchService;

    @GetMapping("")
    public String getHtml(){
        return "/hotels_display";
    }

    @PostMapping("")
    public Model showHotelList(@Param("hotel_city")String hotel_city,
                              @Param("hotel_name")String hotel_name,
                              Model model){
        model.addAttribute("Hotel_city",hotel_city);
        model.addAttribute("Hotel_name",hotel_name);
        List<Hotel> hotels = hotelSearchService.getHotelListByCityAndName(hotel_city,hotel_name);
        model.addAttribute("HotelList",hotels);
        return model;
    }
}
