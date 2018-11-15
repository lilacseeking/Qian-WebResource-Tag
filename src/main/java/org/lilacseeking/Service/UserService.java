package org.lilacseeking.Service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import org.lilacseeking.Exception.BusinessException;
import org.lilacseeking.Model.DTO.LoginDTO;
import org.lilacseeking.Model.PO.UserPO;
import org.lilacseeking.Model.VO.UserInfoVO;
import org.lilacseeking.Utils.Page;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public interface UserService {

    /**
     * 分页查查询所有用户
     * @param params
     * @return
     */
    Page listAllUser(String params) throws ParseException;

    /**
     * 用户注册
     * @param userPO
     * @return
     */
    UserPO register(UserPO userPO);

    /**
     * 用户密码登录
     * @param userPO
     * @return
     * @throws BusinessException
     */
    UserInfoVO loginByPwd(UserPO userPO) throws BusinessException;

    /**
     * 发送验证码
     * @param loginDTO
     * @return
     */
    SendSmsResponse sendMobileCode(LoginDTO loginDTO);

    /**
     * 验证码登录
     * @param loginDTO
     * @return
     */
    UserInfoVO mobileLogin(LoginDTO loginDTO);

    /**
     * 修改密码 and 重置密码
     * @param userPO
     * @param pwd
     * @return
     */
    UserPO resetPassword(UserPO userPO,String pwd) throws BusinessException;

    /**
     * 封存用户
     * @param list
     * @return
     */
    Integer achieveUser(List list);
}
