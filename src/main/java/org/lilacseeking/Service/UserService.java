package org.lilacseeking.Service;

import org.lilacseeking.Model.DTO.LoginDTO;
import org.lilacseeking.Model.DTO.RegisterDTO;
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
     * @param registerDTO
     * @return
     */
    public Integer register(RegisterDTO registerDTO);

    public UserPO login(LoginDTO loginDTO);
}
