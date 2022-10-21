package com.hlkj.hystrix;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author Lixiangping
 * @createTime 2022年07月23日 23:46
 * @decription:
 */
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashBoardApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(HystrixDashBoardApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }

}
