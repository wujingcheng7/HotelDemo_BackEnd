package com.wujingcheng7.hoteldemo_backend.mapper;

import com.wujingcheng7.hoteldemo_backend.domain.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface AccountMapper {
    @Select("select user_tel from account where user_tel=#{user_tel}")
    String getByTel(String user_tel);

    @Delete("delete * from account where user_tel=#{user_tel}")
    void deleteByTel(String user_tel);

    @Insert("insert into account(user_tel,user_password) values (#{user_tel},#{user_password})")
    void regist(Account account);

    @Update("update account set user_bankcard=#{user_bankcard},user_password=#{user_password}")
    void update(Account account);

    /*
    *根据手机和密码查找账户
    * */
    @Select("select * from account where user_tel=#{user_tel} and user_password=#{user_password}")
    Account login(String user_tel,String user_password);

    @Update("update account set user_password=#{user_password} where user_tel=#{user_tel}")
    boolean updateUserPassword(String user_password,String user_tel);
    @Update("update account set user_sex=#{user_sex} where user_tel=#{user_tel}")
    boolean updateUserSex(String user_sex,String user_tel);
    @Update("update account set user_name=#{user_name} where user_tel=#{user_tel}")
    boolean updateUserName(String user_name,String user_tel);
    @Update("update account set user_bankcard=#{user_bankcard} where user_tel=#{user_tel}")
    boolean updateUserBankcard(String user_bankcard,String user_tel);
}
