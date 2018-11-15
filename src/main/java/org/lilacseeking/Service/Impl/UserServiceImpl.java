package org.lilacseeking.Service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.ctrip.framework.apollo.core.utils.StringUtils;
import org.lilacseeking.Configuration.ConstantProperties;
import org.lilacseeking.Dao.UserRepository;
import org.lilacseeking.Eumns.ErrorCodeEumn;
import org.lilacseeking.Eumns.SmsTemltateEnum;
import org.lilacseeking.Exception.BusinessException;
import org.lilacseeking.Model.DTO.LoginDTO;
import org.lilacseeking.Model.PO.UserPO;
import org.lilacseeking.Model.VO.UserInfoVO;
import org.lilacseeking.Service.RedisService;
import org.lilacseeking.Service.UserService;
import org.lilacseeking.Utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RedisService redisService;
    @Autowired
    ConstantProperties constantProperties;

    public Page listAllUser(String params) throws ParseException {
        JSONObject value = JSONObject.parseObject(params).getJSONObject("params");
        int rows = Integer.valueOf(value.getString("rows"));
        int page = Integer.valueOf(value.getString("page"));
        String filter = value.getString("optionParam");
        Page page1 = new Page();
        page1.setCurrentPage(page);
        page1.setRows(rows);
        return userRepository.list(page1, filter);
    }

    /**
     *
     * @param userPO
     * @return
     */
    public UserPO register(UserPO userPO){
        //密码加密
        userPO.setPassword(MD5Util.MD5(userPO.getPassword()));
        userPO.setYanzhi(StringUtil.getRandomString(12));
//        密码加密
//        持久化数据

        return userRepository.saveOrUpdate(userPO);
    }

    /**
     * 用户密码登录
     * @param userPO
     * @return
     * @throws BusinessException
     */
    public UserInfoVO loginByPwd(UserPO userPO) throws BusinessException {
        if (StringUtils.isBlank(userPO.getMobile())){
            throw new BusinessException(ErrorCodeEumn.MOBILE_NOT_NULL.getName());
        }
        UserPO userPOByMobile = userRepository.getUserPOByMobile(userPO.getMobile());
        if (!MD5Util.MD5(userPO.getPassword()).equals(userPOByMobile.getPassword())){
            throw new BusinessException(ErrorCodeEumn.PASSWORD_NOT_CORRECT.getName());
        }
        // 保存用户信息token
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanCopyUtil.copyPropertiesIgnoreNull(userPO,userInfoVO);
        userInfoVO = redisService.saveUserToken(userInfoVO);
        return userInfoVO;
    }

    /**
     * 发送登录短信验证码
     * @param loginDTO
     * @return
     */
    public SendSmsResponse sendMobileCode(LoginDTO loginDTO){
        // 生成6位随机数字
        String verifyCode = String.valueOf((int)((Math.random()*9+1)*100000));
        redisService.saveSmsCode(loginDTO.getMobile(),verifyCode);
        try {
//            SendSmsResponse sendSmsResponse = SmsUtil.sendSms(loginDTO.getMobile(), SmsTemltateEnum.USER_LOGIN, verifyCode);
            SmsUtil.getInstance(constantProperties);
            SendSmsResponse sendSmsResponse = SmsUtil.getInstance(constantProperties).sendSms(loginDTO.getMobile(), SmsTemltateEnum.USER_LOGIN, verifyCode);
            return sendSmsResponse;
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 手机验证码登录
     * @param loginDTO
     * @return
     */
    public UserInfoVO mobileLogin(LoginDTO loginDTO){
        String smsCode = redisService.getSmsCode(loginDTO.getMobile());
        // 验证验证码输入是否正确
        if (!loginDTO.getVerifyCode().equals(smsCode)){
            throw new BusinessException(ErrorCodeEumn.MOBILE_CODE_ERROR.getName());
        }
        // Redis缓存置该用户验证码信息置为失效
         redisService.invalid(loginDTO.getMobile());
        UserPO userPO = userRepository.getUserPOByMobile(loginDTO.getMobile());
        // 保存session

        // 保存用户信息token
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanCopyUtil.copyPropertiesIgnoreNull(userPO,userInfoVO);
        userInfoVO = redisService.saveUserToken(userInfoVO);
        return userInfoVO;
    }
    /**
     * 修改密码 and 重置密码
     * @param userPO
     * @param pwd 新密码
     * @return
     * @throws BusinessException
     */
    public UserPO resetPassword(UserPO userPO,String pwd) throws BusinessException {
        // 参数校验
        if (StringUtils.isBlank(userPO.getMobile())){
            throw new BusinessException(ErrorCodeEumn.MOBILE_NOT_NULL.getName());
        }
        if (StringUtils.isBlank(pwd)){
            throw new BusinessException(ErrorCodeEumn.NEW_PASSWORD_NOT_NULL.getName());
        }
        //查找该用户信息
        UserPO userPOByMobile = userRepository.getUserPOByMobile(userPO.getMobile());
        if (!MD5Util.MD5(userPO.getPassword()).equals(userPOByMobile.getPassword())){
            throw new BusinessException(ErrorCodeEumn.PASSWORD_NOT_CORRECT.getName());
        }
        userPOByMobile.setPassword(MD5Util.MD5(pwd));
        return userRepository.saveOrUpdate(userPOByMobile);
    }

    /**
     * 封存（注销）用户
     * @param list
     * @return
     */
    public Integer achieveUser(List list){
        return null;
    }
}
