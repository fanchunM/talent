package com.sanjiang.talent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.sanjiang.talent.mapper")
@EnableTransactionManagement
public class TalentApplication {

    public static void main(String[] args) {
        SpringApplication.run(TalentApplication.class, args);
    }

}
