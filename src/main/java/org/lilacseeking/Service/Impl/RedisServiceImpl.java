package org.lilacseeking.Service.Impl;

import com.alibaba.fastjson.JSON;
import org.lilacseeking.Model.VO.UserInfoVO;
import org.lilacseeking.Service.RedisService;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
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
        RMap<String, String> map = redissonClient.getMap(QIAN_MANAGE_SMS_CODE + "-" + mobile);
        map.fastPut(mobile, code);
        // 开发环境验证码有效时间为1天
        map.expire(1440, TimeUnit.MINUTES);
        return true;
    }

    // 查询验证码
    public String getSmsCode(String mobile){
        RMap<String, String> map = redissonClient.getMap(QIAN_MANAGE_SMS_CODE + "-" + mobile);
        return map.get(mobile);
    }

    /**
     * 验证码置为失效
     * @param mobile
     */
    public void invalid(String mobile){
        RMap<String, String> map = redissonClient.getMap(QIAN_MANAGE_SMS_CODE + "-" + mobile);
        map.remove(mobile);
    }

    // 保存登录token
    public UserInfoVO saveUserToken(UserInfoVO userInfoVO){
        userInfoVO.setToken(UUID.randomUUID().toString().replace("-","").toLowerCase());
        RMap<String, String> map = redissonClient.getMap(QIAN_MANAGE_USER_INFO);
        map.fastPut(userInfoVO.getUsername(), JSON.toJSONString(userInfoVO));
        return userInfoVO;
    }

    public String getUserToken(){
        return "";
    }
}
