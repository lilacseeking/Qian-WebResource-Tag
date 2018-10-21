package org.lilacseeking.Model.PO;

import lombok.Data;
import org.lilacseeking.Model.DTO.VideoClassDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Auther: lilacseeking
 * @Date: 2018/8/23 22:29
 * @Description:视频课程表
 * 此表为视频课程表，显示课程的详细信息
 */
@Data
@Entity
@Table(name = "video_class")
//@Inheritance(strategy = InheritanceType.JOINED)
public class VideoClassPO extends BaseEntityPO {
    /**
     * 课程名称
     */
    @Column(name = "name",nullable = false)
    public String name;

    /**
     * 主讲人
     */
    @Column(name = "teacher", nullable = false)
    public Long teacher;

    /**
     * 课程描述
     */
    @Column(name = "description")
    public String description;

    /**
     *  课程标签
     */
    @Column(name = "tage")
    public String tags;

    /**
     * 该课程是否免费
     */
    @Column(name = "is_free", nullable = false)
    public Boolean isFree = true;

    /**
     * 该课程的折扣
     */
    @Column(name = "discount",nullable = false, precision = 2, scale = 1)
    public Double discount = 0.0;

    public VideoClassPO(VideoClassDTO videoClassDTO){

        this.name = videoClassDTO.getName();
        this.teacher = videoClassDTO.getTeacher();
        this.description = videoClassDTO.getDescription();
        this.tags = videoClassDTO.getTags();
        this.isFree = videoClassDTO.getIsFree();
        this.discount = videoClassDTO.getDiscount();
    }

    public VideoClassPO(){

    }

    public VideoClassPO(String name, Long teacher, String description, String tags, Boolean isFree, Double discount) {
        this.name = name;
        this.teacher = teacher;
        this.description = description;
        this.tags = tags;
        this.isFree = isFree;
        this.discount = discount;
    }
}
