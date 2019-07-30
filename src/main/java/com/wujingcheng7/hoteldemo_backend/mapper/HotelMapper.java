package com.wujingcheng7.hoteldemo_backend.mapper;

import com.wujingcheng7.hoteldemo_backend.domain.Hotel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Mapper
@Repository
public interface HotelMapper {
    @Select("select * from hotel where hotel_id=#{hotel_id}")
    Hotel getById(String hotel_id);

    @Delete("Delete * from hotel where hotel_id=#{hotel_id}")
    void deleteById(String hotel_id);

    @Insert("Insert into book_list(hotel_id,hotel_name,hotel_longitude,hotel_latitude,hotel_stars,hotel_address,hotel_text) values(#{hotel_id},#{hotel_name},#{hotel_longitude},#{hotel_latitude},#{hotel_stars},#{hotel_address},#{hotel_text})")
    void createHotel(Hotel hotel);

    @Select("select hotel_name from hotel where hotel_name like #{hotel_name} and hotel_city like #{hotel_city}")
    String getResultsetByCityAndName(String hotel_city, String hotel_name);

    @Select("select hotel_name from hotel where hotel_name like #{hotel_name} and hotel_city like #{hotel_city}")
    ArrayList<Hotel> getByCityAndName(String hotel_city, String hotel_name);
}
