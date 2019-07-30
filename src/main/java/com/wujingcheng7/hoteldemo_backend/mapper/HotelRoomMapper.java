package com.wujingcheng7.hoteldemo_backend.mapper;

import com.wujingcheng7.hoteldemo_backend.domain.HotelRoom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HotelRoomMapper {
    @Select("select * from hotel_room where hotel_id = #{hotel_id}")
    List<HotelRoom> getHotelRoomListByHotelId(@Param("hotel_id")String hotel_id);

}
