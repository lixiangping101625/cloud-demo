package com.hlkj.hystrix;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Lixiangping
 * @createTime 2022年10月20日 14:44
 * @decription:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class HystrixApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(HystrixApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }

}
