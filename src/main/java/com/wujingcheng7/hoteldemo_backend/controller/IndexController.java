package com.wujingcheng7.hoteldemo_backend.controller;

import com.wujingcheng7.hoteldemo_backend.domain.Hotel;
import com.wujingcheng7.hoteldemo_backend.service.HotelSearchService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    HotelSearchService hotelSearchService;

    @GetMapping("")
    public String index(){return "/index";}

    @PostMapping("")
    public ModelAndView goHtml(@Param("hotel_city")String hotel_city,
                               @Param("hotel_name")String hotel_name){
        ModelAndView model = new ModelAndView("hotel_display");
        ArrayList<Hotel> hotels = hotelSearchService.getByCityAndName(hotel_city,hotel_name);
        try{
            if (hotels.size()==0){
                System.out.println("草泥马没读取成功,来自IndexController");
            }
            else
                System.out.println("草泥马读取成功了,来自IndexController");
                System.out.println(hotels);
        }catch (Exception e){
            System.out.println("出现异常");
        }
        model.addObject("HotelArrayList",hotels);
        return model;
    }
}
