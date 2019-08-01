package com.wujingcheng7.hoteldemo_backend.mapper;

import com.wujingcheng7.hoteldemo_backend.domain.OrderList;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface OrderlistMapper {
    @Select("Select * from order_list where order_id=#{order_id}")
    OrderList getOrderlistByOrderId(int order_id);

    @Select("Select * from order_list where hotel_id=#{hotel_id}")
    List<OrderList> getAllOrderlistsByHotelId(String hotel_id);

    @Delete("Delete from order_list where order_id=#{order_id}")
    void deleteOrderlistByOrderId(int order_id);

    @Select("Select * from order_list where user_tel=#{user_tel}")
    List<OrderList> getAllOrderlistsByUserTel(String user_tel);

    @Options(useGeneratedKeys = true,keyProperty = "order_id",keyColumn = "order_id")
    @Insert("insert into order_list(hotel_id,user_tel,room_id,hotel_room_id,order_price,order_indate,order_outdate,order_howmanyday,hotel_name) values (#{hotel_id},#{user_tel},#{room_id},#{hotel_room_id},#{order_price},#{order_indate},#{order_outdate},#{order_howmanyday},#{hotel_name})")
    void insertOrderlist(OrderList orderList);
}
