package org.lilacseeking.Service.video;

import org.lilacseeking.Model.PO.VideoCoursePO;

/**
 * @Auther: lilacseeking
 * @Date: 2018/10/18 22:46
 * @Description:课程相关接口
 */
public interface VideoClassService {

    /**
     * 新增课程
     * @param videoCoursePO
     * @return
     */
    VideoCoursePO addVideoClass(VideoCoursePO videoCoursePO);
}
