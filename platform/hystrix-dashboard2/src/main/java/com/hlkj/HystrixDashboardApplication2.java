package com.hlkj;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author Lixiangping
 * @createTime 2022年10月21日 21:37
 * @decription:
 */
@SpringCloudApplication
@EnableHystrixDashboard
public class HystrixDashboardApplication2 {

    public static void main(String[] args) {
        new SpringApplicationBuilder(HystrixDashboardApplication2.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
