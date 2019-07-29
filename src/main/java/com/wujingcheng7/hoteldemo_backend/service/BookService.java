package com.wujingcheng7.hoteldemo_backend.service;

import com.wujingcheng7.hoteldemo_backend.config.Result;
import com.wujingcheng7.hoteldemo_backend.domain.Book;
import com.wujingcheng7.hoteldemo_backend.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;
    /*
    * 预定房间
    * */
    public Result Book(Book book){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            Object isBooked = bookMapper.getById(book.getBook_id());
            if(isBooked != null){
                //房间已被预订
                result.setMsg("该房间已被预定");
            }else{
                bookMapper.book(book);
                result.setMsg("预定成功");
                result.setSuccess(true);
                result.setDetail(book);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }
}
