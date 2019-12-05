package com.markdown.api.domain;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Company
 * Created By   : Lr
 * Created Date : 2019/10/16 10:24
 * Description  : Swagger配置文件
 *
 * @author :lr
 */
@Data
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * API接口包路径
     */
    private String basePackage;

    /**
     * API页面标题
     */
    private String title;

    /**
     * API描述
     */
    private String description;

    /**
     * 服务条款地址
     */
    private String termsOfServiceUrl;

    /**
     * 版本号
     */
    private String version;

    /**
     * 联系人
     */
    private Contact contact;

    @Bean
    public Docket api() {
        //在配置好的配置类中增加此段代码即可
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        //name表示名称，description表示描述
        ticketPar.name("Authorization").description("登录校验")
                .modelRef(new ModelRef("string")).parameterType("header")
                //required表示是否必填，defaultvalue表示默认值
                .required(false).defaultValue("Bearer 123.123.123").build();
        //添加完此处一定要把下边的带***的也加上否则不生效
        pars.add(ticketPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.markdown.api"))
                .paths(PathSelectors.any())
                .build()
                //************把消息头添加
                .globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("markdown-nice-api接口标准")
                .description("balabala")
                //.termsOfServiceUrl("http://www.javastack.cn/")
                .version("1.0")
                .build();
    }

}
