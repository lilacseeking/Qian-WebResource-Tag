package org.lilacseeking.Dao;


import org.lilacseeking.Model.PO.UserPO;
import org.lilacseeking.Utils.Page;
import org.springframework.stereotype.Service;
import sun.reflect.generics.repository.AbstractRepository;


public class UserRepository extends AbstractRepository<UserPO> {


    /**
     * 保存或更新
     * @return
     */
    public Integer saveOrUpdate(UserPO userPO){
        return null;
    }


    /**
     * 分页查询
     * @param page
     * @return
     */
    public Page list(Page page){
        return null;
    }

    /**
     * 删除用户
     * @return
     */
//    public Integer delete(UserPO userPO);

    /**
     * 封存用户
     * @param userPO
     * @return
     */
    public Integer achieve(UserPO userPO){
        return null;
    }
}
