package org.lilacseeking.Service.Impl.video;

import org.lilacseeking.Dao.video.VideoCourseRepository;
import org.lilacseeking.Model.PO.VideoCoursePO;
import org.lilacseeking.Service.video.VideoCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: lilacseeking
 * @Date: 2018/10/18 22:48
 * @Description:课程相关接口实现类
 */
@Service
public class VideoCourseServiceImpl implements VideoCourseService {

    @Autowired
    private VideoCourseRepository videoCourseRepository;

    /**
     * 保存课程信息
     * @param videoCoursePO
     * @return
     */
    public VideoCoursePO addVideoClass(VideoCoursePO videoCoursePO){
        return videoCourseRepository.saveOrUpdate(videoCoursePO);
    }
}
