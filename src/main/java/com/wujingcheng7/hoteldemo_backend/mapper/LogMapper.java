package com.wujingcheng7.hoteldemo_backend.mapper;

import com.wujingcheng7.hoteldemo_backend.domain.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface LogMapper {
    //创建日志
    @Options(useGeneratedKeys = true,keyProperty = "log_id",keyColumn = "log_id")
    @Insert("insert into log(log_operation,log_man,log_time) values(#{log_operation},#{log_man},#{log_time})")
    public void createLog(Log log);

    //根据酒店ID查询日志
    @Select("select * from log where hotel_id=#{hotel_id)")
    public List<Log> getLogsByHotelId(String hotel_id);
}
