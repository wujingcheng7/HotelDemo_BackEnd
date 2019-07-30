package com.wujingcheng7.hoteldemo_backend.mapper;

import com.wujingcheng7.hoteldemo_backend.domain.Orderlist;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderlistMapper {
    @Select("Select * from order_list where order_id=#{order_id}")
    Orderlist getOrderlistByOrderlistId(String order_id);

    @Delete("Delete * from order_list where order_id=#{order_id}")
    void deleteOrderlistByOrderId(String order_id);

    @Select("Select * from order_list where user_tel=#{user_tel}")
    List<Orderlist> getAllOrderlistsByUserTel(String user_tel);

    @Insert("")
    void insertOrderlist();//TODO:此方法有待完善
}
