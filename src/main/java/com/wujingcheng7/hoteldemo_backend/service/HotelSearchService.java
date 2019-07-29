package com.wujingcheng7.hoteldemo_backend.service;

import com.wujingcheng7.hoteldemo_backend.domain.Hotel;
import com.wujingcheng7.hoteldemo_backend.mapper.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class HotelSearchService {
    @Autowired
    HotelMapper hotelMapper;

    public ArrayList<Hotel> getByCityAndName(String hotel_city, String hotel_name){
//        String str = hotelMapper.getResultsetByCityAndName(hotel_city,hotel_name);
//        System.out.println(str);
//        ArrayList<Hotel> hotels = new ArrayList<>();
        ArrayList<Hotel> hotels = hotelMapper.getByCityAndName(hotel_city,hotel_name);

        return hotels;
    }
}
