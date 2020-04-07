package com.sanjiang.talent.po;

import lombok.Data;

import java.util.Date;

@Data
public class Role {

    private String id;

    private String roleName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createBy;
}
