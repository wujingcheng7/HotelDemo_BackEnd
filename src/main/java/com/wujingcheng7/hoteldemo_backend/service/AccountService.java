package com.wujingcheng7.hoteldemo_backend.service;

import com.wujingcheng7.hoteldemo_backend.mapper.AccountMapper;
import com.wujingcheng7.hoteldemo_backend.config.Result;
import com.wujingcheng7.hoteldemo_backend.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;
    /*
    * 注册
    * @return Result
    * */
    public Result regist(Account account){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            Object existaccount = accountMapper.getByTel(account.getUser_tel());
            if(existaccount != null){
                //如果用户已存在
                result.setMsg("该手机号已被注册");
            }else{
                accountMapper.regist(account);
                result.setMsg("注册成功");
                result.setSuccess(true);
                result.setDetail(account);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;

    }
    /*
    * 登录
    * @param Account 手机号和密码
    * @return Result
    * */
    public Result login(Account account){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            String usertel = accountMapper.login(account);
            if(usertel == null){
                result.setMsg("用户名或密码错误");
            }else{
                result.setMsg("登录成功");
                result.setSuccess(true);
                result.setDetail(account);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return  result;
    }
}
