package com.wujingcheng7.hoteldemo_backend.service;

import com.wujingcheng7.hoteldemo_backend.config.Result;
import com.wujingcheng7.hoteldemo_backend.domain.Log;
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
    @Autowired
    LogService logService;

    //预定房间
    public Result createAnOrder(String user_tel, String hotel_id, String room_id, Date order_indate, Date order_outdate){
        //初始化orderList
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

        //冲突检测
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        List<OrderList> orderLists = orderlistMapper.getAllOrderlistsByHotelRoomIdAndDate(orderList);
        result.setSuccess(orderLists.isEmpty());
        if (result.isSuccess()) {
            result.setMsg("订单创建成功");
            orderlistMapper.insertOrderlist(orderList);
        }
        else {
            result.setMsg("订单与已有订单冲突");
        }
        return result;
    }

    //查看某用户的所有订单
    public List<OrderList> getAllMyOrders(String user_tel){
        return orderlistMapper.getAllOrderlistsByUserTel(user_tel);
    }

    //根据订单号删除某个订单
    public void deleteAnOrder(int order_id){
        OrderList orderList = orderlistMapper.getOrderlistByOrderId(order_id);

        //初始化log
        Log log = new Log();
        log.setLog_man(orderList.getUser_tel());
        log.setLog_operation("删除");
        log.setLog_time(new Date());
        log.setOrder_id(order_id);
        log.setHotel_id(orderList.getHotel_id());
        logService.CreateLog(log);
        orderlistMapper.deleteOrderlistByOrderId(order_id);
    }

    //查看某酒店所有订单
    public List<OrderList> getOrderListsByHotelId(String hotel_id){ return orderlistMapper.getAllOrderlistsByHotelId(hotel_id);}

    //根据订单号查询某个订单
    public OrderList getOrderListByOrderId(int order_id){return orderlistMapper.getOrderlistByOrderId(order_id);}

    //修改订单
    public Result modifyOrderList(OrderList orderListBackUp,String user_tel,String hotel_id,String room_id,Date order_indate,Date order_outdate,String hotel_admin_id){
        int order_id = orderListBackUp.getOrder_id();
        OrderList orderList = orderlistMapper.getOrderlistByOrderId(order_id);
        Log log = new Log();
        log.setLog_man(orderList.getUser_tel());
        log.setLog_operation("修改");
        log.setLog_time(new Date());
        log.setOrder_id(order_id);
        log.setHotel_id(orderList.getHotel_id());
        deleteAnOrder(order_id);
        Result result = createAnOrder(user_tel,hotel_id,room_id,order_indate,order_outdate);
        if (result.isSuccess()){
            logService.CreateLog(log);
        }
        else {
            //恢复备份
            createAnOrder(orderListBackUp.getUser_tel(),orderListBackUp.getHotel_id(),orderListBackUp.getRoom_id(),orderListBackUp.getOrder_indate(),orderListBackUp.getOrder_outdate());
        }

        return result;
    }

    public List<OrderList> getOrderListsByHotelRoomIdAndDate(OrderList orderList){
        return orderlistMapper.getAllOrderlistsByHotelRoomIdAndDate(orderList);
    }
}
