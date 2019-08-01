package com.wujingcheng7.hoteldemo_backend.mapper;

import com.wujingcheng7.hoteldemo_backend.domain.Hotel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface HotelMapper {
    @Select("select * from hotel where hotel_id=#{hotel_id}")
    Hotel getById(String hotel_id);

    @Delete("Delete * from hotel where hotel_id=#{hotel_id}")
    void deleteById(String hotel_id);

    @Insert("Insert into book_list(hotel_id,hotel_name,hotel_longitude,hotel_latitude,hotel_stars,hotel_address,hotel_text) values(#{hotel_id},#{hotel_name},#{hotel_longitude},#{hotel_latitude},#{hotel_stars},#{hotel_address},#{hotel_text})")
    void createHotel(Hotel hotel);

    @Select("select * from hotel where hotel_name like concat('%',#{hotel_name},'%') and hotel_city like concat('%',#{hotel_city},'%')")
    List<Hotel> getListByCityAndName(String hotel_city, String hotel_name);

    @Update("update hotel set hotel_name=#{hotel_name} where hotel_id=#{hotel_id}")
    boolean updateNameById(String hotel_name,String hotel_id);

    @Update("update hotel set hotel_text=#{hotel_text} where hotel_id=#{hotel_id}")
    boolean updatelTextById(String hotel_text,String hotel_id);

    @Update("update hotel set hotel_img_url=#{hotel_img_url} where hotel_id=#{hotel_id}")
    boolean updatelImgUrlById(String hotel_img_url,String hotel_id);

    @Update("update hotel set hotel_stars=#{hotel_stars} where hotel_id=#{hotel_id}")
    boolean updateStarById(String hotel_stars,String hotel_id);

    @Update("update hotel set hotel_address=#{hotel_address} where hotel_id=#{hotel_id}")
    boolean updateAddrById(String hotel_address,String hotel_id);
}
