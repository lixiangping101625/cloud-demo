package com.hlkj.order.service;

import order.pojo.Order;
import order.vo.OrderVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Lixiangping
 * @createTime 2022年10月17日 17:14
 * @decription: 接口层现在需要对外提供服务，所以需要添加@RequestMapping等注解,
 *              将其声明成controller。这些注解也会被继承，避免下游应用调用时
 *              还要配置寻址路径
 */
@RequestMapping("orders-api")
public interface OrderService {

    @GetMapping("listAll")
    List<Order> listAll();

    @GetMapping("info")
    OrderVO detail(@RequestParam(name = "id",required = true) Long id);
}