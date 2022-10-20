package com.hlkj.hystrix.hystrix;

import com.hlkj.hystrix.MyService;
import com.hlkj.user.pojo.User;
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

    //这里关注error方法即可
    @Override
    public String error() {
        log.info("Fallback: I'm not a black sheep any more");
        return "Fallback: I'm not a black sheep any more";
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
