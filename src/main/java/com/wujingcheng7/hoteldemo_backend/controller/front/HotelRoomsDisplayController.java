package com.wujingcheng7.hoteldemo_backend.controller.front;

import com.wujingcheng7.hoteldemo_backend.domain.Hotel;
import com.wujingcheng7.hoteldemo_backend.domain.HotelRoom;
import com.wujingcheng7.hoteldemo_backend.service.HotelRoomService;
import com.wujingcheng7.hoteldemo_backend.service.HotelService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

import static javax.swing.text.html.CSS.getAttribute;

@Controller
@RequestMapping("/rooms_display")
public class HotelRoomsDisplayController {
    @Autowired
    HotelRoomService hotelRoomService;
    @Autowired
    HotelService hotelService;

    @GetMapping("")
    public String getHtml(){
        return "/rooms_display";
    }

    @PostMapping("")
    public Model showRoomList(HttpServletRequest request, @Param("hotel_id")String hotel_id,Model model){
        HttpSession session = request.getSession();
        List<HotelRoom> rooms = hotelRoomService.getRoomListByHotelId(hotel_id);
        Hotel hotel = hotelService.getHotelById(hotel_id);
        model.addAttribute("RoomList",rooms);
        model.addAttribute("HotelObject",hotel);
        return model;
    }

}
