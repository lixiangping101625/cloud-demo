package com.hlkj.hystrix.hystrix;

import com.hlkj.hystrix.MyService;
import com.hlkj.user.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Lixiangping
 * @createTime 2022年10月20日 14:45
 * @decription: 针对MyService的容错类
 */
@Component
@Slf4j
public class Fallback implements MyService {

    @HystrixCommand(fallbackMethod = "multistage")//指定多级降级的业务方法
    @Override
    public String error() {
        log.info("Fallback: I'm not a black sheep any more");
//        return "Fallback: I'm not a black sheep any more";
        //测试多级降级：一错再错。最好向外层抛出
        throw new RuntimeException();
    }

    //超时降级
    @Override
    public String timeout(Integer count) {
        log.info("超时降级：you are late");
        return "you are late";
    }

    private String multistage(){
        log.info("多级降级");
        return "多级降级：多级降级";
    }

    @Override
    public List<User> listAll() {
        return null;
    }

    @Override
    public User detail(Long id) {
        return null;
    }

}
