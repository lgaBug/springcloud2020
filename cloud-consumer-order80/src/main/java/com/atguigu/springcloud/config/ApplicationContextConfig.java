package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Andy
 * @Date: 2020/11/24 14:44
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    public RestTemplate getRestTemplatea() {
        return new RestTemplate();
    }
}
