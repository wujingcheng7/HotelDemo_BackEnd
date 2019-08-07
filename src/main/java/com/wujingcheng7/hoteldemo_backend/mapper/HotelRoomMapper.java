package com.wujingcheng7.hoteldemo_backend.mapper;

import com.wujingcheng7.hoteldemo_backend.domain.HotelRoom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HotelRoomMapper {
    @Select("select * from hotel_room where hotel_id = #{hotel_id}")
    List<HotelRoom> getHotelRoomListByHotelId(@Param("hotel_id")String hotel_id);

    @Select("select * from hotel_room where hotel_room_id = #{hotel_room_id}")
    HotelRoom getHotelRoomByHoteRoomlId(String hotel_room_id);

    @Update("update hotel_room set room_type=#{room_type} where hotel_room_id=#{hotel_room_id}")
    Boolean updateRoomTypeById(String hotel_room_id,String room_type);

    @Update("update hotel_room set room_price=#{room_price} where hotel_room_id=#{hotel_room_id}")
    Boolean updateRoomPriceById(String hotel_room_id,String room_price);

    @Update("update hotel_room set room_text=#{room_text} where hotel_room_id=#{hotel_room_id}")
    Boolean updateRoomTextById(String hotel_room_id,String room_text);


}
