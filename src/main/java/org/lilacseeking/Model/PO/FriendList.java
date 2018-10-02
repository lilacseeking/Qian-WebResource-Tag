package org.lilacseeking.Model.PO;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Auther: lilacseeking
 * @Date: 2018/8/24 22:00
 * @Description:好友列表
 * 用户的好友列表
 */
@Data
@Entity
@Table(name = "friend_list")
//@Inheritance(strategy = InheritanceType.JOINED)
public class FriendList extends BaseEntityPO {
    /**
     *
     */
    @Column(name = "friend_id")
    public Long friendId;

}
