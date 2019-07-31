package com.wujingcheng7.hoteldemo_backend.service;

import com.wujingcheng7.hoteldemo_backend.domain.OrderList;
import com.wujingcheng7.hoteldemo_backend.mapper.HotelMapper;
import com.wujingcheng7.hoteldemo_backend.mapper.HotelRoomMapper;
import com.wujingcheng7.hoteldemo_backend.mapper.OrderlistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderlistService {
    @Autowired
    private OrderlistMapper orderlistMapper;
    @Autowired
    private HotelMapper hotelMapper;
    @Autowired
    private HotelRoomMapper hotelRoomMapper;

    //预定房间
    public OrderList createAnOrder(String user_tel,String hotel_id,String room_id,Date order_indate,Date order_outdate){
        OrderList orderList = new OrderList();
        String hotel_name = hotelMapper.getById(hotel_id).getHotel_name();
        String hotel_room_id = hotel_id+room_id;
        long days = (order_outdate.getTime()-order_indate.getTime())/(24*60*60*1000);
        long room_price = Long.parseLong(hotelRoomMapper.getHotelRoomByHoteRoomlId(hotel_room_id).getRoom_price());
        String order_price = String.valueOf(days*room_price);
        String order_howmanyday = String.valueOf(days);
        orderList.setHotel_name(hotel_name);
        orderList.setUser_tel(user_tel);
        orderList.setOrder_indate(order_indate);
        orderList.setOrder_outdate(order_outdate);
        orderList.setRoom_id(room_id);
        orderList.setHotel_id(hotel_id);
        orderList.setHotel_room_id(hotel_room_id);
        orderList.setOrder_howmanyday(order_howmanyday);
        orderList.setOrder_price(order_price);
        orderlistMapper.insertOrderlist(orderList);
        return orderList;
    }

    //查看某用户的所有订单
    public List<OrderList> getAllMyOrders(String user_tel){
        return orderlistMapper.getAllOrderlistsByUserTel(user_tel);
    }

    //根据订单号删除某个订单
    public void deleteAnOrder(int order_id){
        orderlistMapper.deleteOrderlistByOrderId(order_id);
    }
}
