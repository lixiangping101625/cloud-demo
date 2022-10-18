package com.hlkj.user.service.impl;

import com.hlkj.user.mapper.UserMapper;
import com.hlkj.user.pojo.User;
import com.hlkj.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Lixiangping
 * @createTime 2022年10月17日 17:23
 * @decription:
 */
@RestController //eureka时基于http的服务治理框架，所以service提供的服务需要声明成controller
//@Service //注意不需要
@Slf4j
public class UserServiceImpl implements UserService {

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;

    public List<User> listAll() {
        logger.info("查询用户列表");
        return userMapper.list();
    }
    public User detail(@RequestParam(name = "id") Long id) {
        return userMapper.getDetail(id);
    }
}
