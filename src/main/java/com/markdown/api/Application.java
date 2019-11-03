package com.markdown.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

/**
 * Company
 * Created By   : Lr
 * Created Date : 2019/10/16 10:24
 * Description  :
 * @author      :lr
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}

}

@MapperScan("com.markdown.api.mapper")
@SpringBootApplication
class MybatisAnnotationApplication {

	public static void main(String[] args) {

		SpringApplication.run(MybatisAnnotationApplication.class, args);

	}
}



