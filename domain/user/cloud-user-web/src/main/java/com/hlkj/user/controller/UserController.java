package com.hlkj.user.controller;

import com.hlkj.pojo.UnifyResponse;
import com.hlkj.user.pojo.User;
import com.hlkj.user.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Lixiangping
 * @createTime 2022年10月17日 17:40
 * @decription:
 */
@RestController
@RequestMapping("/user")
@Api(value = "商品接口", tags = "用户信息展示相关接口")
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation(value = "查询所有", tags = "查询所有用户信息")
    @GetMapping("/listAll")
    @HystrixCommand(
            commandKey = "listFail",//全局唯一的标识符（默认是函数名称list）
            groupKey = "list", //全局服务分组。用于组织仪表盘、统计信息。默认是类名
            fallbackMethod = "listFail", //同一个类中，public和private都可以
//            ignoreExceptions = {IllegalArgumentException.class}, //配置例外的情况（列表中的exception不会触发降级）
            threadPoolKey = "threadPoolA", //线程组(多个服务可以公用一个线程组)
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),//核心线程数
                    //size>0, linkedBlockingQueue ->请求等待队列
                    //默认-1, SynchronousQueue -> 不存储元素的阻塞队列（建议读源码）
                    @HystrixProperty(name = "maxQueueSize", value = "40"),
                    // maxQueueSize=-1时无效。队列没有达到maxQueueSize依然拒绝
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15"),
                    // 统计窗口（线程池）持续时间
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1024"),
                    // 窗口内桶子的数量
                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "18")
            }
//            commandProperties = {
//                    // TODO  熔断降级相关属性也可以放到这里
//            }
    )
    public List<User> list(){
        return userService.listAll();
    }

    // list()方法的fallback方法
    private List<User> listFail(Throwable throwable){
        return null;
    }

    @ApiOperation(value = "查询用户详情", tags = "查询用户详情")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id",value = "用户id", required = true)
    )
    @GetMapping("/info")
    public User detail(@RequestParam(name = "id") Long id){
        return userService.detail(id);
    }

    @GetMapping("/globalException")
    public UnifyResponse globalException(){
        int i = 10/0;
        return UnifyResponse.buildSuccess();
    }
}
