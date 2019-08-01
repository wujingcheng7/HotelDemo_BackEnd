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
    //根据城市名获取酒店对象列表
    public List<Hotel> getHotelListByCityAndName(String hotel_city, String hotel_name){
        return hotelMapper.getListByCityAndName(hotel_city,hotel_name);
    }
    //根据酒店Id获取酒店对象
    public Hotel getHotelById(String hotel_id){
        return hotelMapper.getById(hotel_id);
    }
    //根据酒店Id更改酒店名字
    public boolean updateHotelName(String hotel_name,String hotel_id){
        return hotelMapper.updateNameById(hotel_name,hotel_id);
    }
    //根据酒店Id更改酒店星级
    public boolean updateHotelStars(String hotel_stars,String hotel_id){
        return hotelMapper.updateStarById(hotel_stars, hotel_id);
    }
    //根据酒店Id更改酒店文本介绍
    public boolean updateHotelText(String hotel_text,String hotel_id){
        return hotelMapper.updatelTextById(hotel_text, hotel_id);
    }
    //根据酒店Id更改酒店主图片
    public boolean updateHotelImg(String hotel_img_url,String hotel_id){
        return hotelMapper.updatelImgUrlById(hotel_img_url, hotel_id);
    }
    //根据酒店Id更改酒店文字地址（非坐标）
    public boolean updateHotelAddr(String hotel_address,String hotel_id){
        return hotelMapper.updateAddrById(hotel_address, hotel_id);
    }
}
