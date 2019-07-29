package com.wujingcheng7.hoteldemo_backend.service;

import com.wujingcheng7.hoteldemo_backend.domain.Hotel;
import com.wujingcheng7.hoteldemo_backend.mapper.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class HotelSearchService {
    @Autowired
    HotelMapper hotelMapper;

    public ArrayList<Hotel> getByCityAndName(String hotel_city, String hotel_name){
        ResultSet rs = hotelMapper.getResultsetByCityAndName(hotel_city,hotel_name);
        ArrayList<Hotel> hotels = new ArrayList<>();
        try {
            while (rs.next()) {
                hotels.add(new Hotel(
                        rs.getString("hotel_id"),
                        rs.getString("hotel_name"),
                        rs.getString("hotel_longitude"),
                        rs.getString("hotel_latitude"),
                        rs.getString("hotel_stars"),
                        rs.getString("hotel_address"),
                        rs.getString("hotel_text"),
                        rs.getString("hotel_city")
                ));
            }
        }catch (SQLException e){
            System.out.println("酒店列表SQL语句读取时出错");
            e.printStackTrace();
        }
        try {
            rs.close();
        } catch (SQLException e) {
            System.out.println("酒店列表SQL语句关闭时出错");
            e.printStackTrace();
        }
        return hotels;
    }
}
