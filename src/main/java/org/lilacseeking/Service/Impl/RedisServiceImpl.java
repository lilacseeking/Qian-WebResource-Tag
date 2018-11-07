package org.lilacseeking.Service.Impl;

import org.lilacseeking.Service.RedisService;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: lilacseeking
 * @Date: 2018/10/30 20:53
 * @Description:
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedissonClient redissonClient;
    // 保存验证码
    public Boolean saveSmsCode(String mobile,String code){
        RMap<String, String> map = redissonClient.getMap(QIAN_MANAGE_SMS_CODE);
        map.fastPut(mobile, code);
        map.expire(5, TimeUnit.MINUTES);
        return true;
    }

    // 查询验证码
    public String getSmsCode(){
        return "";
    }

    // 保存登录token
    public Boolean saveUserToken(){
        return true;
    }

    public String getUserToken(){
        return "";
    }
}
