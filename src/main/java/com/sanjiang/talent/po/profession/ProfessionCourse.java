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
    private double courseInCredits;

    /**
     * 课内总学时
     */
    private double courseTotalHours;

    /**
     * 授课
     */
    private double teaching;

    /**
     * 上机
     */
    private double onbroad;

    /**
     * 课内实践
     */
    private double practice;

    /**
     *实验室实验
     */
    private double laboratory;

    /**
     *课外学分
     */
    private double courseOutCredits;

    /**
     *第一学期
     */
    private double term1;

    /**
     *第二学期
     */
    private double term2;

    /**
     *第三学期
     */
    private double term3;

    /**
     *第四学期
     */
    private double term4;

    /**
     *第五学期
     */
    private double term5;

    /**
     *第六学期
     */
    private double term6;

    /**
     *第七学期
     */
    private double term7;

    /**
     *第八学期
     */
    private double term8;

    private String platformName;

    private String moudleName;

    private String courseCode;

    private String professionName;

    private String courseName;

    private String courseUnitsName;



}
