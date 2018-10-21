package org.lilacseeking.Service;

import org.lilacseeking.Exception.BusinessException;
import org.lilacseeking.Model.PO.UserPO;
import org.lilacseeking.Utils.Page;
import org.springframework.stereotype.Service;

import java.text.ParseException;

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

    UserPO login(UserPO userPO) throws BusinessException;
}
