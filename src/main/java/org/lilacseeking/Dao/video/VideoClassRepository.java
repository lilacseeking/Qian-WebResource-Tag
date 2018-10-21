package org.lilacseeking.Dao.video;

import org.lilacseeking.Dao.AbstractRepository;
import org.lilacseeking.Model.PO.VideoClassPO;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @Auther: lilacseeking
 * @Date: 2018/10/18 22:50
 * @Description:课程持久化类
 */
@Repository
public class VideoClassRepository extends AbstractRepository<VideoClassPO> {
    @Transactional
    public VideoClassPO saveOrUpdate(VideoClassPO videoClassPO){
        return entityManager.merge(videoClassPO);
    }
}
