package com.alias.uploadcet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.alias.uploadcet.mapper")
public class UploadcetApplication {

    public static void main(String[] args) {

        SpringApplication.run(UploadcetApplication.class, args);
    }

}
