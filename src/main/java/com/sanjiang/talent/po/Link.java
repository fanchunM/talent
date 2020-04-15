package com.sanjiang.talent.po;

import lombok.Data;


@Data
public class Link {

    private String id;

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 关联ID
     */
    private String linkId;

    /**
     * 关联类型（1：关联用户，2：关联菜单）
     */
    private int type;
}
