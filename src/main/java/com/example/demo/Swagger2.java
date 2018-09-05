package com.example.demo;

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
 * Created by WD42700 on 2018/9/5.
 */
//

/**
 * 该配置类需要在Application同级目录下创建，在项目启动的时候，就初始化该配置类
 * https://blog.csdn.net/liuchuanhong1/article/details/59064794
 * https://blog.csdn.net/liuchuanhong1/article/details/58594045
 *
  */
@Configuration
@EnableSwagger2 // 启用Swagger
public class Swagger2 {

    @Bean
    public Docket createRestApi() {// 创建API基本信息
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.chhliu.jpa"))// 扫描该包下的所有需要在Swagger中展示的API，@ApiIgnore注解标注的除外
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {// 创建API的基本信息，这些信息会在Swagger UI中进行显示
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")// API 标题
                .description("rdcloud-jpa提供的RESTful APIs")// API描述
                .contact("chhliu@")// 联系人
                .version("1.0")// 版本号
                .build();
    }

}
