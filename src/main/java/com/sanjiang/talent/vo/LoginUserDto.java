package com.sanjiang.talent.vo;

import lombok.Data;

@Data
public class LoginUserDto {

    private String loginUserId;

    private String userName;

    private String password;

    private int isTeacher;

    private String chsName;

    private String position;

    private String department;

}
