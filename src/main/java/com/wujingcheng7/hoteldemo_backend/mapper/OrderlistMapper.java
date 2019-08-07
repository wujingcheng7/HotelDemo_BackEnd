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

    /*查看酒店所有当前订单*/
    @Select("Select * from order_list where hotel_id=#{hotel_id} and order_outdate>CURRENT_DATE()")
    List<OrderList> getNowOrderlistsByHotelId(String hotel_id);

    /*查看酒店所有历史订单*/
    @Select("Select * from order_list where hotel_id=#{hotel_id} and order_outdate<CURRENT_DATE() and visible = 1")
    List<OrderList> getOldOrderlistsByHotelId(String hotel_id);

    /*查看用户所有当前订单*/
    @Select("select * from order_list where user_tel=#{user_tel} and order_outdate>=CURRENT_DATE() and visible = 1")
    List<OrderList> getNowOrderlistsByUserTel(String user_tel);

    /*查看用户所有历史订单*/
    @Select("select * from order_list where user_tel=#{user_tel} and order_outdate<CURRENT_DATE() and visible = 1")
    List<OrderList> getOldOrderlistsByUserTel(String user_tel);

    /*预定房间时查询该房间所有冲突订单*/
    @Select("Select * from order_list where hotel_room_id=#{hotel_room_id} and order_outdate>#{order_indate} and order_indate<#{order_outdate}")
    List<OrderList> getAllOrderlistsByHotelRoomIdAndDate(OrderList orderList);

    /*
    * 删除订单，
    * 设置为对用户不可见
    * */
    @Update("update  order_list set visible=0 where order_id=#{order_id}")
    void deleteOrderlistByOrderId(int order_id);

    /*
    * 取消订单，
    * 只能取消未入住的订单
    * 删除数据库订单
    * */
    @Delete("delete from order_list where order_id=#{order_id} and order_indate>CURRENT_DATE()")
    int cancelOrderlistByOrderId(int order_id);

    /*
    * 根据用户根据手机号查看可见订单
    * */
    @Select("Select * from order_list where user_tel=#{user_tel} and visible=1")
    List<OrderList> getAllOrderlistsByUserTel(String user_tel);

    @Options(useGeneratedKeys = true,keyProperty = "order_id",keyColumn = "order_id")
    @Insert("insert into order_list(hotel_id,user_tel,room_id,hotel_room_id,order_price,order_indate,order_outdate,order_howmanyday,hotel_name) values (#{hotel_id},#{user_tel},#{room_id},#{hotel_room_id},#{order_price},#{order_indate},#{order_outdate},#{order_howmanyday},#{hotel_name})")
    void insertOrderlist(OrderList orderList);


}
