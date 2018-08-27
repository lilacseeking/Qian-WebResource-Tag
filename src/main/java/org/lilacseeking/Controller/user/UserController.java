package org.lilacseeking.Controller.user;
import com.alibaba.fastjson.JSON;
import org.lilacseeking.Api.Result;
import org.lilacseeking.Service.UserService;
import org.lilacseeking.Utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/list")
    public String getUserById(Integer page, Integer rows){
        Result result = new Result();
        Page page1 = new Page(page,rows);
        page1 = userService.listAllUser(page1);
        if (page1.getResultList().size()>0){
            result.setSuccess(true);
            result.setData(page1);
        }else{
            result.setSuccess(false);
            result.setMessage("没有查询到用户");
        }
        return JSON.toJSONString(result);
    }
}
