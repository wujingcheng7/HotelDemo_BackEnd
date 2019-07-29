package com.wujingcheng7.hoteldemo_backend.mapper;

import com.wujingcheng7.hoteldemo_backend.domain.Account;
import com.wujingcheng7.hoteldemo_backend.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BookMapper {
    @Select("Select * from book_list where book_id=#{book_id}")
    Book getById(String book_id);

    @Delete("Delete * from book_list where book_id=#{book_id}")
    void deleteById(String book_id);

    @Insert("Insert into book_list(book_id,hotel_id,user_tel,room_id,book_indate,book_outdate,book_lastdays) values(#{book_id},#{hotel_id},#{user_tel},#{room_id},#{book_indate},#{book_outdate},#{book_lastdays})")
    void book(Book book);
}
