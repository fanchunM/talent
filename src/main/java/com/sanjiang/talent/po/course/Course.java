package com.sanjiang.talent.po.course;

import lombok.Data;

/**
 * 课程表
 */
@Data
public class Course {

    private String id;

    /**
     * 课程名
     */
    private String name;

    /**
     * 课程代码
     */
    private String code;

    /**
     * 模块ID
     */
    private String moudleId;

    /**
     * 平台名称
     */
    private String platformName;

    /**
     * 模块名称
     */
    private String moudleName;

    /**
     * 开课单位ID
     */

     private String courseUnitsId;

    /**
     * 开课单位名
     */

    private String courseUnitsName;


}
