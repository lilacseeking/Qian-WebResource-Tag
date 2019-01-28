package org.lilacseeking.Controller.video;

import com.querydsl.jpa.JPAQueryBase;
import com.querydsl.jpa.impl.JPAQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.lilacseeking.Model.DTO.VideoContentDTO;
import org.lilacseeking.Model.DTO.VideoCourseDTO;
import org.lilacseeking.Model.PO.VideoContentPO;
import org.lilacseeking.Model.PO.VideoCoursePO;
import org.lilacseeking.Service.video.VideoContentService;
import org.lilacseeking.Service.video.VideoCourseService;
import org.lilacseeking.Utils.BeanCopyUtil;
import org.lilacseeking.Utils.ResponseUtil;
import org.lilacseeking.Utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Auther: lilacseeking
 * @Date: 2018/10/18 22:41
 * @Description:
 */
@RestController
@RequestMapping(value = "/video")
@Api(value = "课程")
public class VideoController {

    @Autowired
    private VideoCourseService videoCourseService;

    @Autowired
    private ResponseUtil responseUtil;

    @Autowired
    private VideoContentService videoContentService;

    /**
     * 创建课程
     * @param videoCourseDTO
     * @param response
     */
    @RequestMapping(value = "/addVideoClass",method = RequestMethod.POST)
    @ApiOperation(value = "创建课程")
    public void AddVideoClass(@RequestBody VideoCourseDTO videoCourseDTO, HttpServletResponse response){
        VideoCoursePO videoCoursePO = VideoCoursePO.builder().build();
        videoCoursePO = videoCourseService.addVideoClass(videoCoursePO);
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

    @RequestMapping(value = "/addVideoContent",method = RequestMethod.POST)
    @ApiOperation(value = "创建课程")
    public void addVideoContent(@RequestBody VideoContentDTO videoContentDTO, HttpServletResponse response){
        VideoContentPO videoContentPO = VideoContentPO.builder().build();
        BeanCopyUtil.copyPropertiesIgnoreNull(videoContentDTO,videoContentPO);
        VideoContentPO videoContent = videoContentService.addVideoContent(videoContentPO);
        responseUtil.putSuccess(videoContent);
        responseUtil.writeMessage(response);
    }

    /**
     * 课程文件上传
     * @param classVideo
     * @param classThumbnail
     * @param response
     */
    @RequestMapping(value = "/uploadVideoClass",method = RequestMethod.POST)
    @ApiOperation(value = "上传视频")
    public void uploadVideoClass(MultipartFile classVideo,MultipartFile classThumbnail,HttpServletResponse response){
        try {
            UploadUtils.uploadFileStream(classVideo.getInputStream());
            UploadUtils.uploadFileStream(classThumbnail.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
