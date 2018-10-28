package org.lilacseeking.Service;

import org.lilacseeking.Exception.BusinessException;
import org.lilacseeking.Model.PO.UserPO;
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
     * 用户登录
     * @param userPO
     * @return
     * @throws BusinessException
     */
    UserPO login(UserPO userPO) throws BusinessException;

    /**
     * 修改密码 and 重置密码
     * @param userPO
     * @param pwd
     * @return
     */
    UserPO resetPassword(UserPO userPO,String pwd) throws BusinessException;

    Integer achieveUser(List list);
}
