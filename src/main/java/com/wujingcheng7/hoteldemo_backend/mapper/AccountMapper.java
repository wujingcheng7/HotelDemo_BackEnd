package com.wujingcheng7.hoteldemo_backend.mapper;

import com.wujingcheng7.hoteldemo_backend.domain.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface AccountMapper {
    @Select("select * from account where user_tel=#{user_tel}")
    Account getByTel(String user_tel);

    @Delete("delete * from account where user_tel=#{user_tel}")
    void deleteByTel(String user_tel);

    @Insert("insert into account(user_tel,user_password) values (#{user_tel},#{user_password})")
    void regist(Account account);

    @Update("update account set user_bankcard=#{user_bankcard},user_password=#{user_password}")
    void update(Account account);

    /*
    *根据手机和密码查找账户
    * */
    @Select("select user_tel from account where user_tel=#{user_tel},user_password=#{user_password}")
    String login(Account account);
}
