package org.lilacseeking.Dao;

import org.lilacseeking.Model.PO.UserPO;
import org.lilacseeking.Utils.Page;

public class UserRepository {

    /**
     * 保存或更新
     * @return
     */
    public Integer saveOrUpdate(UserPO userPO){
        return 0;
    }

    /**
     * 分页查询
     * @param page
     * @return
     */
    public Page list(Page page){
        return new Page();
    }

    /**
     * 删除用户
     * @return
     */
    public Integer delete(UserPO userPO){
        return 0;
    }

    /**
     * 封存用户
     * @param userPO
     * @return
     */
    public Integer achieve(UserPO userPO){
        return 0;
    }
}
