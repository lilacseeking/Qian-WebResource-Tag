package org.lilacseeking.Model.PO;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Auther: lilacseeking 未验证
 * @Date: 2018/8/23 22:40
 * @Description:课程目录表
 * 此表为视频课程表，显示课程的详细信息
 */
@Entity
@Data
@Table(name = "video_content")
//@Inheritance(strategy = InheritanceType.JOINED)
public class VideoContentPO extends BaseEntityPO {
    /**
     * 课程名称
     */
    @Column(name = "cource_name")
    public String courceName;

    /**
     * 章节名称
     */
    @Column(name = "chapter_nane")
    public String chapterNane;

    /**
     * 章节编号
     */
    @Column(name = "chapter_id")
    public String chapterId;

    /**
     * 章节描述
     */
    @Column(name = "chapter_description")
    public String chapterDescription;

    /**
     * 是否免费
     */
    @Column(name = "is_free")
    public String isFree;

    /**
     * 视频时长
     */
    @Column(name = "time")
    public String time;

    /**
     * 视频地址
     */
    @Column(name = "url")
    public String url;

    /**
     * 视频文件名称
     */
    @Column(name = "file_name")
    public String fileName;

    /**
     * 播放次数
     */
    @Column(name = "views")
    public String views;

}
