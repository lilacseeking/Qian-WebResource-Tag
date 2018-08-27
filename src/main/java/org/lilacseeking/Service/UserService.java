package org.lilacseeking.Service;

import org.lilacseeking.Model.PO.UserPO;
import org.lilacseeking.Utils.Page;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    /**
     * 分页查查询所有用户
     * @param page
     * @return
     */
    public Page listAllUser(Page page);

    /**
     * 用户注册
     * @param userPO
     * @return
     */
    public Integer register(UserPO userPO);

    public UserPO login(UserPO userPO);
}
