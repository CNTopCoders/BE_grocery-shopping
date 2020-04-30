package com.alias.uploadcet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.alias.uploadcet.mapper")
public class UploadcetApplication  extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(UploadcetApplication.class, args);
    }

}
