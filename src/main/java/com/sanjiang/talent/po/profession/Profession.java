package com.sanjiang.talent.po.profession;

import lombok.Data;

/**
 * 专业表
 */
@Data
public class Profession {

    private String id;

    /**
     * 专业名
     */
    private String name;

    /**
     * 校内码
     */
    private String codeIn;

    /**
     * 校外码
     */
    private String codeOut;

}
