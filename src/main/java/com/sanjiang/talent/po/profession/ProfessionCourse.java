package com.sanjiang.talent.po.profession;

import lombok.Data;

/**
 * 专业课程信息表
 */
@Data
public class ProfessionCourse {

    private String id;

    /**
     * 专业ID
     */
    private String professionId;

    /**
     * 课程ID
     */
    private String courseId;

    /**
     * 课程性质
     */
    private String courseNature;

    /**
     * 课内学分
     */
    private String courseInCredits;

    /**
     * 课内总学时
     */
    private String courseToalHours;

    /**
     * 授课
     */
    private String teaching;

    /**
     * 上机
     */
    private String onbroad;

    /**
     * 课内实践
     */
    private String practice;

    /**
     *实验室实验
     */
    private String laboratory;

    /**
     *课外学分
     */
    private String courseOutCredits;

    /**
     *第一学期
     */
    private String term1;

    /**
     *第二学期
     */
    private String term2;

    /**
     *第三学期
     */
    private String term3;

    /**
     *第四学期
     */
    private String term4;

    /**
     *第五学期
     */
    private String term5;

    /**
     *第六学期
     */
    private String term6;

    /**
     *第七学期
     */
    private String term7;

    /**
     *第八学期
     */
    private String term8;

}
