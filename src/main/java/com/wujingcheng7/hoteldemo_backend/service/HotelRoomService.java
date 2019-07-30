package com.wujingcheng7.hoteldemo_backend.service;

import com.wujingcheng7.hoteldemo_backend.domain.HotelRoom;
import com.wujingcheng7.hoteldemo_backend.mapper.HotelRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class HotelRoomService {
    @Autowired
    HotelRoomMapper roomMapper;

    public List<HotelRoom> getRoomListByHotelId(String hotel_id){
        return roomMapper.getHotelRoomListByHotelId(hotel_id);
    }
}
