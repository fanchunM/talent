package com.sanjiang.talent.po;

import lombok.Data;

import java.util.Date;

@Data
public class Menu {

    private String id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父级菜单
     */
    private String fatherId;

    /**
     * 地址
     */
    private String address;

    /**
     * 图标
     */
    private String icon;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createBy;

}
