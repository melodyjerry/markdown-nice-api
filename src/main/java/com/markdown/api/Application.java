package com.markdown.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Company
 * Created Date : 2019/10/16 10:24
 * Description  :
 *
 * @author lirui
 */
@MapperScan("com.markdown.api.mapper")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}