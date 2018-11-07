package org.lilacseeking.Service;

/**
 * @Auther: lilacseeking
 * @Date: 2018/10/30 19:52
 * @Description: Redis工具类
 */
public interface RedisService {

    // 手机验证码
    String QIAN_MANAGE_SMS_CODE = "Qian-Manage-SMS-CODE";

    // 保存验证码
    Boolean saveSmsCode(String mobile,String code);

    // 查询验证码
    String getSmsCode();

    // 保存登录token
    Boolean saveUserToken();

    String getUserToken();
}
