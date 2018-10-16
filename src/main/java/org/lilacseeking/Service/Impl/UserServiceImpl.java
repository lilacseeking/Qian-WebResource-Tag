package org.lilacseeking.Service.Impl;

import org.lilacseeking.Dao.UserRepository;
import org.lilacseeking.Model.DTO.LoginDTO;
import org.lilacseeking.Model.DTO.RegisterDTO;
import org.lilacseeking.Model.PO.UserPO;
import org.lilacseeking.Service.UserService;
import org.lilacseeking.Utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.lilacseeking.Utils.Page;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @PersistenceContext
    EntityManager em;

    public Page listAllUser(Page page){
        page =  userRepository.list(new Page());
        return page;
    }

    /**
     *
     * @param registerDTO
     * @return
     */
    public Integer register(RegisterDTO registerDTO){
//        参数检查
        UserPO userPO = new UserPO(registerDTO);
        //密码加密
        String password = userPO.getPassword();
        MD5Util.generate(password);
        String yanzhi = "";
        userRepository.saveOrUpdate(userPO);
//        密码加密

//        持久化数据

        return 1;
    }

    public UserPO login(LoginDTO loginDTO){
        return new UserPO();
    }
}
