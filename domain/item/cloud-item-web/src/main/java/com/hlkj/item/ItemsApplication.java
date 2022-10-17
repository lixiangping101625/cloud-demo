package com.hlkj.item;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Lixiangping
 * @createTime 2022年10月17日 17:36
 * @decription:
 */
@SpringBootApplication
@EnableDiscoveryClient // 表示到注册中心拉去服务注册列表
@MapperScan(basePackages = "com.hlkj.item.mapper")
// TODO feign注解
public class ItemsApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ItemsApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }

}
