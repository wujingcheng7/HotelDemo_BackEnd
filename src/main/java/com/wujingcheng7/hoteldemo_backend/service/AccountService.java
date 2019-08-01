package com.wujingcheng7.hoteldemo_backend.service;

import com.wujingcheng7.hoteldemo_backend.domain.HotelAdmin;
import com.wujingcheng7.hoteldemo_backend.mapper.AccountMapper;
import com.wujingcheng7.hoteldemo_backend.config.Result;
import com.wujingcheng7.hoteldemo_backend.domain.Account;
import com.wujingcheng7.hoteldemo_backend.mapper.HotelAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.sql.SQLOutput;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private HotelAdminMapper hotelAdminMapper;
    /*
    * 用户注册
    * @return Result
    * */
    public Result UserRegister(Account account){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        result.setMsg(null);
        try{
            String existaccount = accountMapper.getByTel(account.getUser_tel());
            if(existaccount != null){
                //如果用户已存在
                result.setMsg("该手机号已被注册");
            }else{
                accountMapper.regist(account);
                result.setMsg("注册成功");
                result.setSuccess(true);
                result.setDetail(account.getUser_name());
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;

    }
    /*
    * 用户登录
    * @param Account 手机号和密码
    * @return Result
    * */
    public Result UserLogin(String user_tel,String user_password){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            Account user = accountMapper.login(user_tel,user_password);
            if(user == null){
                result.setMsg("用户名或密码错误");
            }else{
                result.setMsg("登录成功");
                result.setSuccess(true);
                result.setDetail(user.getUser_name());//Detail收录用户姓名
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        System.out.println(result.toString());
        return  result;
    }

    /*
    * 管理员注册
    * */
    public Result AdminRegister(HotelAdmin hotelAmin){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        result.setMsg(null);
        try{
            String existadmin = hotelAdminMapper.getByHotelAdminId(hotelAmin.getHotel_admin_id());
            if(existadmin != null){
                //如果用户已存在
                result.setMsg("该管理员账户已存在");
            }else{
                hotelAdminMapper.regist(hotelAmin);
                result.setMsg("注册成功");
                result.setSuccess(true);
                result.setDetail(hotelAmin.getHotel_admin_id());
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }
    /*
    * 管理员登录
    * */
    public Result AdminLogin(String hotel_admin_id,String hotel_admin_psw){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            HotelAdmin hotelAdmin = hotelAdminMapper.login(hotel_admin_id,hotel_admin_psw);
            if(hotelAdmin == null){
                result.setMsg("用户名或密码错误");
            }else{
                result.setMsg("登录成功");
                result.setSuccess(true);
                result.setDetail(hotelAdmin.getHotel_admin_id());//Detail收录管理员账号
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        System.out.println(result.toString());
        return  result;
    }
    public boolean updatePassword(String user_password,String user_tel){
        return accountMapper.updateUserPassword(user_password,user_tel);
    }
    public boolean updateName(String user_name,String user_tel){
        return accountMapper.updateUserName(user_name,user_tel);
    }
    public boolean updateSex(String user_sex,String user_tel){
        return accountMapper.updateUserSex(user_sex,user_tel);
    }
    public boolean updateBankcard(String user_bankcard,String user_tel){
        return accountMapper.updateUserBankcard(user_bankcard,user_tel);
    }
}
