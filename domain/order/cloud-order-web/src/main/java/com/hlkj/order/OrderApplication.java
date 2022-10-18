package com.hlkj.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Lixiangping
 * @createTime 2022年10月17日 17:36
 * @decription:
 */
@SpringBootApplication
@EnableDiscoveryClient // 表示到注册中心拉去服务注册列表
@MapperScan(basePackages = "com.hlkj.order.mapper")
// TODO feign注解
public class OrderApplication {

    @Bean
    public RestTemplate register(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(OrderApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
