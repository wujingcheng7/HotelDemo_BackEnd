package com.wujingcheng7.hoteldemo_backend.service;

import com.wujingcheng7.hoteldemo_backend.domain.OrderList;
import com.wujingcheng7.hoteldemo_backend.mapper.OrderlistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderlistService {
    @Autowired
    private OrderlistMapper orderlistMapper;

    //预定房间
    public void createAnOrder(OrderList orderList){
        orderlistMapper.insertOrderlist(orderList);//由于OrderlistMapper此方法有待完善，导致这句语句无效
    }

    //查看某用户的所有订单
    public List<OrderList> getAllMyOrders(String user_tel){
        return orderlistMapper.getAllOrderlistsByUserTel(user_tel);
    }

    //根据订单号删除某个订单
    public void deleteAnOrder(String order_id){
        orderlistMapper.deleteOrderlistByOrderId(order_id);
    }
}
