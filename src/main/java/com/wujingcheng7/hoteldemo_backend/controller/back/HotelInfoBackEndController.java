package com.wujingcheng7.hoteldemo_backend.controller.back;

import com.wujingcheng7.hoteldemo_backend.service.HotelService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("hotel_info_backend")
public class HotelInfoBackEndController {
    /*
    * 酒店信息修改
    * */
    @Autowired
    private HotelService hotelService;

    @GetMapping("")
    public String html(){
        return "/hotel_info_backend";
    }
    @PostMapping("")
    public String HotelInfoModify(HttpServletRequest request,Model model, @Param("hotel_name")String hotel_name, @Param("hotel_text")String hotel_text, @Param("hotel_stars")String hotel_stars, @Param("hotel_img_url")String hotel_img_url){
        HttpSession session = request.getSession();
        String hotel_id = (String)session.getAttribute("hotel_id");
        if(hotel_name!="")
            hotelService.updateHotelName(hotel_name,hotel_id);
        if(hotel_text!="")
            hotelService.updateHotelText(hotel_text,hotel_id);
        if(hotel_stars!="")
            hotelService.updateHotelStars(hotel_stars,hotel_id);
        return "/bookinfo_backend";
    }
}
