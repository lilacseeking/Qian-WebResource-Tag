package org.lilacseeking.Service;

import org.lilacseeking.Model.VO.UserInfoVO;

/**
 * @Auther: lilacseeking
 * @Date: 2018/10/30 19:52
 * @Description: Redis工具类
 */
public interface RedisService {

    // 手机验证码
    String QIAN_MANAGE_SMS_CODE = "Qian-Manage-Sms-Code";
    // 用户信息
    String QIAN_MANAGE_USER_INFO = "Qian-Manage-User-Info";

    // 保存验证码
    Boolean saveSmsCode(String mobile,String code);

    // 查询验证码
    String getSmsCode(String mobile);

    // 验证码置为失效
    void invalid(String mobile);

    // 保存登录token
    UserInfoVO saveUserToken(UserInfoVO userInfoVO);

    String getUserToken();
}
