package com.duing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Configuration 声明这是一个配置类
 * @EnableSwagger2 swagger接口
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    /**
     * RequestHandlerSelectors.any()获取所有的接口
     * @return Docket
     */
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).
                select().
                apis(RequestHandlerSelectors.basePackage("com.duing")).
                paths(PathSelectors.any()).
                build().apiInfo(apiInfo());
    }

    /**
     * 自定义文档介绍
     */
    private ApiInfo apiInfo(){
        //返回接口的描述
        return new ApiInfoBuilder().title("家具系统").description("控制层的接口").version("2.9.2").build();
    }
}
