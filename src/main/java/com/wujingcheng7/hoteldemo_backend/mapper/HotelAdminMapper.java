package com.wujingcheng7.hoteldemo_backend.mapper;

import com.wujingcheng7.hoteldemo_backend.domain.HotelAdmin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface HotelAdminMapper {
    @Insert("insert into hotel_admin(hotel_admin_id,hotel_id,hotel_admin_pwd) values (#{hotel_admin_id},#{hotel_id},#{hotel_admin_pwd}")
    void regist(HotelAdmin hotelAdmin);

    @Select("select * from hotel_admin where hotel_admin_id=#{hotel_admin_id} and hotel_admin_pwd=#{hotel_admin_pwd}")
    HotelAdmin login(String hotel_admin_id, String hotel_admin_pwd);
    @Select("select hotel_admin_id form hotel_admin where hotel_admin_id=#{hotel_admin_id}")
    String getByHotelAdminId(String hotel_admin_id);

    @Select("select hotel_id from hotel_admin where hotel_admin_id=#{hotel_admin_id}")
    String getHotelIdByHotelAdminId(String hotel_admin_id);
}
