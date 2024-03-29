package org.lilacseeking.Dao.video;

import org.lilacseeking.Dao.AbstractRepository;
import org.lilacseeking.Model.PO.VideoCoursePO;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @Auther: lilacseeking
 * @Date: 2018/10/18 22:50
 * @Description:课程持久化类
 */
@Repository
public class VideoCourseRepository extends AbstractRepository<VideoCoursePO> {
    @Transactional
    public VideoCoursePO saveOrUpdate(VideoCoursePO videoCoursePO){
        return entityManager.merge(videoCoursePO);
    }
}
