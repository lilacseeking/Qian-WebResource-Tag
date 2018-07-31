package org.lilacseeking.Dao;

import org.lilacseeking.Model.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface UserRepository extends JpaRepository<UserPO,Long>,JpaSpecificationExecutor {

    @Modifying
    @Query(value = "select userPO from UserPO userPO where userPO.gender=:gender")
    List listAllUser(@Param(value = "gender")Integer gender);
}
