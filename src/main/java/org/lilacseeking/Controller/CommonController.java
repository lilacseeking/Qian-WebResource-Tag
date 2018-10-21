package org.lilacseeking.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.lilacseeking.Model.DTO.LoginDTO;
import org.lilacseeking.Model.DTO.RegisterDTO;
import org.lilacseeking.Model.PO.UserPO;
import org.lilacseeking.Service.UserService;
import org.lilacseeking.Utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: lilacseeking
 * @Date: 2018/8/27 21:57
 * @Description: 基本配置类
 */
@RequestMapping(value = "/common")
@Api(value = "/common", tags = {"公共接口"})
@RestController
public class CommonController {

    @Autowired
    UserService userService;
    @Autowired
    ResponseUtil responseUtil;
    /**
     * 用户注册
     */
    @ApiOperation(value = "用户注册" ,notes = "用户注册")
    @RequestMapping(value = "/register" ,method = RequestMethod.POST)
    public void register(@RequestBody RegisterDTO registerDTO, HttpServletResponse res){
        UserPO register = null;
        try {
            UserPO userPO  = new UserPO(registerDTO);
            register = userService.register(userPO);
        } catch (Exception e) {
            e.printStackTrace();
            responseUtil.putError(e);
        }
        responseUtil.putSuccess(register);
        responseUtil.writeMessage(res);
//        result.setSuccess(true);
//        result.setCode("0");
//        result.setData(register);
    }
    /**
     * 用户登录
     */
    @ApiOperation(value = "用户登录" ,notes = "用户登录")
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public void login(@RequestBody LoginDTO loginDTO,HttpServletResponse res){
        UserPO userPO = new UserPO(loginDTO);
        try{
            userPO = userService.login(userPO);
            responseUtil.putSuccess(userPO);
        }catch (Exception e){
            e.printStackTrace();
            responseUtil.putError(e);
        }
        responseUtil.writeMessage(res);
    }
}
