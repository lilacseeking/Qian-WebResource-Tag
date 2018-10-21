package org.lilacseeking.Service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.ctrip.framework.apollo.core.utils.StringUtils;
import org.lilacseeking.Dao.UserRepository;
import org.lilacseeking.Eumns.ErrorCodeEumn;
import org.lilacseeking.Exception.BusinessException;
import org.lilacseeking.Model.PO.UserPO;
import org.lilacseeking.Service.UserService;
import org.lilacseeking.Utils.MD5Util;
import org.lilacseeking.Utils.Page;
import org.lilacseeking.Utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public Page listAllUser(String params) throws ParseException {
        JSONObject value = JSONObject.parseObject(params);
        int rows = Integer.valueOf(value.getString("rows"));
        int page = Integer.valueOf(value.getString("page"));
        String filter = value.getString("filter");
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
        userPO.setPassword(MD5Util.generate(userPO.getPassword()));
        userPO.setYanzhi(StringUtil.getRandomString(12));
//        密码加密
//        持久化数据

        return userRepository.saveOrUpdate(userPO);
    }

    public UserPO login(UserPO userPO) throws BusinessException {
        if (StringUtils.isBlank(userPO.getMobile())){
            throw new BusinessException(ErrorCodeEumn.MOBILE_NOT_NULL.getName());
        }
        UserPO userPOByMobile = userRepository.getUserPOByMobile(userPO.getMobile());
        if (MD5Util.generate(userPO.getPassword()).equals(userPOByMobile.getPassword())){
            return userPOByMobile;
        }else {
            throw new BusinessException(ErrorCodeEumn.PASSWORD_NOT_CORRECT.getName());
        }
    }
}
