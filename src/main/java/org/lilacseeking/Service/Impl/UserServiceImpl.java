package org.lilacseeking.Service.Impl;

import org.lilacseeking.Dao.UserRepository;
import org.lilacseeking.Model.UserPO;
import org.lilacseeking.Service.UserService;
import org.lilacseeking.Utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    public Page listAllUser(Page page){
        List<UserPO> userPOList =  userRepository.listAllUser(1);
        page.setResultList(userPOList);
        return page;
    }
}
