package com.hlkj.hystrix;

import com.hlkj.hystrix.hystrix.Fallback;
import com.hlkj.user.service.UserService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Lixiangping
 * @createTime 2022年10月20日 14:46
 * @decription:
 */
@FeignClient(name = "cloud-user-service", fallback = Fallback.class)
public interface MyService extends UserService {
}
