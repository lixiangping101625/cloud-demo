package com.hlkj.turbine2;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author Lixiangping
 * @createTime 2022年10月21日 10:23
 * @decription:
 */
@EnableDiscoveryClient
@EnableHystrix
@EnableCircuitBreaker
@EnableTurbine
@EnableAutoConfiguration
public class Turbine2Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Turbine2Application.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }

}
