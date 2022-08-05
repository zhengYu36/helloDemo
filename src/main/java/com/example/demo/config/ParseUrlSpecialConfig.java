package com.example.demo.config;

import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <ul>
 * <li>文件包名 : com.yanjoy.designReview.config</li>
 * <li>创建时间 : 2020/9/28 14:38</li>
 * <li>修改记录 : 无</li>
 * </ul>
 * 类说明： 使后端可以接收url中的特殊符号
 *
 * @author zhengyu
 */

@Configuration
public class ParseUrlSpecialConfig {

    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> connector.setProperty("relaxedQueryChars", "|{}[]\\"));
        return factory;
    }

}
