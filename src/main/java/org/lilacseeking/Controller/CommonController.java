package org.lilacseeking.Controller;

import org.lilacseeking.Model.DTO.LoginDTO;
import org.lilacseeking.Model.DTO.RegisterDTO;
import org.lilacseeking.Model.PO.UserPO;
import org.lilacseeking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: lilacseeking
 * @Date: 2018/8/27 21:57
 * @Description: 基本配置类
 */
@RequestMapping(name = "/common")
public class CommonController {

    @Autowired
    UserService userService;





    /**
     * 用户注册
     */
    @RequestMapping(name = "/register")
    public String register(RegisterDTO registerDTO){
        UserPO userPO = new UserPO(registerDTO);
        userService.register(userPO);
        return "";
    }
    /**
     * 用户登录
     */
    @RequestMapping(name = "/login")
    public UserPO login(LoginDTO loginDTO){
        UserPO userPO = new UserPO(loginDTO);
        userPO = userService.login(userPO);
        return userPO;
    }
}
