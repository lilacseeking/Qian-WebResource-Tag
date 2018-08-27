package org.lilacseeking.Service.Impl;

import org.lilacseeking.Dao.UserRepository;
import org.lilacseeking.Model.PO.UserPO;
import org.lilacseeking.Service.UserService;
import org.lilacseeking.Utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public Page listAllUser(Page page){
        page =  userRepository.list(new Page());
        return page;
    }

    /**
     *
     * @param userPO
     * @return
     */
    public Integer register(UserPO userPO){
//        参数检查

//        密码加密

//        持久化数据

        return 1;
    }

    public UserPO login(UserPO userPO){
        return new UserPO();
    }
}
