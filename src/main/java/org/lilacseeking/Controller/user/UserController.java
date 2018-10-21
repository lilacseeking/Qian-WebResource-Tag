package org.lilacseeking.Controller.user;

import org.lilacseeking.Api.Result;
import org.lilacseeking.Service.UserService;
import org.lilacseeking.Utils.Page;
import org.lilacseeking.Utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    private ResponseUtil responseUtil;
    @RequestMapping(value = "/list")
    public void getUserById(@RequestBody String params , HttpServletResponse response){
        Result result = new Result();
        Page page = null;
        try {
            page = userService.listAllUser(params);
            responseUtil.putSuccess(page);
        }catch (Exception e){
            e.printStackTrace();
            responseUtil.putError(e);
        }
        responseUtil.writeMessage(response);
//        if (page.getResultList().size()>0){
//            result.setSuccess(true);
//            result.setData(page);
//        }else{
//            result.setSuccess(false);
//            result.setMessage("没有查询到用户");
//        }
    }
}
