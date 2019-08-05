package com.wujingcheng7.hoteldemo_backend.controller.back;

import com.wujingcheng7.hoteldemo_backend.domain.HotelRoom;
import com.wujingcheng7.hoteldemo_backend.service.HotelRoomService;
import com.wujingcheng7.hoteldemo_backend.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("hotelrooms_info_backend")
public class HotelRoomsInfoBackEndController {
    @Autowired
    HotelService hotelService;
    @Autowired
    HotelRoomService hotelRoomService;

    @GetMapping("")
    public Model goHtml(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        String hotel_id = (String) session.getAttribute("hotel_id");
        List<HotelRoom> hotelRoomList = hotelRoomService.getRoomListByHotelId(hotel_id);
        model.addAttribute("roomlist",hotelRoomList);
        return model;
    }

    @PostMapping("/{roomId}")
    @ResponseBody
    public HotelRoom getHotelRoom(@PathVariable("roomId") String roomId, HttpServletRequest request){
        HttpSession session = request.getSession();
        String hotel_id = (String)session.getAttribute("hotel_id");
        return hotelRoomService.getRoomByHotelRoomId(hotel_id+roomId);
    }
}
