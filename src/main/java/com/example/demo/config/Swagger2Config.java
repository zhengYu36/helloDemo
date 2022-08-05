package com.example.demo.config;


import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    // 定义分隔符
    private static final String splitor = ";";
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("API接口文档")
                .description("用户信息管理")
                .version("1.0.0")
                .build();
    }
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(basePackage("com.nwh.framework.usersecurity.controller"+splitor+"com.nwh.dxds.algsappmain.controller"
                        +splitor+"com.nwh.dxds.duanmian.controller"+splitor+"com.nwh.dxds.accepter.controller"+splitor+"com.nwh.dxds.projectmanager.controller"
                        +splitor+"com.nwh.framework.flowable.rest"+splitor+"com.nwh.framework.flowable.controller"+splitor+"com.nwh.dxds.quality.controller"
                        +splitor+"com.nwh.dxds.leadinggeology.controller"
                        +splitor+"com.example.demo.controller"
                        +splitor+"com.nwh.dxds.property.controller")) //这里写的是API接口所在的包位置
                .paths(PathSelectors.any())
                .build();
    }

    public static Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage)     {
        return input -> {
            // 循环判断匹配
            for (String strPackage : basePackage.split(splitor)) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }


}
