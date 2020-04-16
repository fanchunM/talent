package com.sanjiang.talent.po.course;

import lombok.Data;

/**
 * 模块表
 */
@Data
public class Moudle {

    private String id;

    /**
     * 模块名
     */
    private String name;

    /**
     * 平台ID
     */
    private String platformId;

    /**
     * 名称
     */
    private String platformName;

}


