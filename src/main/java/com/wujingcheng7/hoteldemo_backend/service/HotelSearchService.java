package com.wujingcheng7.hoteldemo_backend.service;

import com.wujingcheng7.hoteldemo_backend.mapper.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
* 酒店搜索
* 1、城市、名称：HotelSimpleSearch(String hotel_city,Stirng hotel_name)
* 2、城市、名称、日期:HotelDateSearch(String hotel_city,Stirng hotel_name,date indate,date outdate)
* */
@Service
public class HotelSearchService {
    @Autowired
    private HotelMapper hotelMapper;
}
