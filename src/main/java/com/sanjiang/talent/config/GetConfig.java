package com.sanjiang.talent.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetConfig {

    @Value("${mybatis.mapper-locations}")
    public String mybatis;

}
