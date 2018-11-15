package org.lilacseeking.Controller.video;

import com.querydsl.jpa.JPAQueryBase;
import com.querydsl.jpa.impl.JPAQuery;
import org.lilacseeking.Model.DTO.VideoClassDTO;
import org.lilacseeking.Model.PO.VideoCoursePO;
import org.lilacseeking.Service.video.VideoClassService;
import org.lilacseeking.Utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Auther: lilacseeking
 * @Date: 2018/10/18 22:41
 * @Description:
 */
@RestController
@RequestMapping(value = "/video")
public class VideoController {

    @Autowired
    private VideoClassService videoClassService;

    @Autowired
    private ResponseUtil responseUtil;

    /**
     * 创建课程
     * @param videoClassDTO
     * @param response
     */
    @RequestMapping(value = "/addVideoClass")
    public void AddVideoClass(@RequestBody VideoClassDTO videoClassDTO, HttpServletResponse response){
        VideoCoursePO videoCoursePO = null;
        try {
            videoCoursePO = new VideoCoursePO(videoClassDTO);
            videoCoursePO = videoClassService.addVideoClass(videoCoursePO);

        }catch (Exception e){
            e.printStackTrace();
        }
        responseUtil.putSuccess(videoCoursePO);
        responseUtil.writeMessage(response);
    }

    /**
     * 查询教师开设的所有课程
     * @param id
     * @return
     */
    public List getVideoClassByTeacherId(Long id){
        JPAQueryBase query = new JPAQuery<>();

        return null;
    }
}
