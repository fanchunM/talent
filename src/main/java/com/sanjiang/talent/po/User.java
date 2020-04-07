package com.sanjiang.talent.po;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private String Id;

    /**
     * 用户名（学号or工号）
     */
    private String userName;

    /**
     * 中文名
     */
    private String chsName;

    /**
     * 性别
     */
    private String gender;

    /**
     * 密码
     */
    private String password;

    /**
     * 职位
     */
    private String position;

    /**
     * 系别
     */
    private String department;

    /**
     * 0:学生， 1:教师， 2：管理员
     */
    private int isTeacher;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createBy;


}
