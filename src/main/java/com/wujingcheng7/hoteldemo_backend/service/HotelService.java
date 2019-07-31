package com.wujingcheng7.hoteldemo_backend.service;

import com.wujingcheng7.hoteldemo_backend.domain.Hotel;
import com.wujingcheng7.hoteldemo_backend.mapper.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HotelService {
    @Autowired
    HotelMapper hotelMapper;

    public List<Hotel> getHotelListByCityAndName(String hotel_city, String hotel_name){
        return hotelMapper.getListByCityAndName(hotel_city,hotel_name);
    }

    public Hotel getHotelById(String hotel_id){
        return hotelMapper.getById(hotel_id);
    }
}
