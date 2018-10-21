package org.lilacseeking.Service.Impl.video;

import org.lilacseeking.Dao.video.VideoClassRepository;
import org.lilacseeking.Model.PO.VideoClassPO;
import org.lilacseeking.Service.video.VideoClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: lilacseeking
 * @Date: 2018/10/18 22:48
 * @Description:课程相关接口实现类
 */
@Service
public class VideoClassServiceImpl implements VideoClassService {

    @Autowired
    private VideoClassRepository videoClassRepository;

    /**
     * 保存课程信息
     * @param videoClassPO
     * @return
     */
    public VideoClassPO addVideoClass(VideoClassPO videoClassPO){
        return videoClassRepository.saveOrUpdate(videoClassPO);
    }
}
