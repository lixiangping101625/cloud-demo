package com.hlkj.item.service.impl;

import com.hlkj.item.mapper.ItemsMapper;
import com.hlkj.item.pojo.Items;
import com.hlkj.item.service.ItemsService;
import com.hlkj.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Lixiangping
 * @createTime 2022年10月17日 17:23
 * @decription:
 */
@RestController //eureka时基于http的服务治理框架，所以service提供的服务需要声明成controller
//@Service //注意不需要
@Slf4j
public class ItemsServiceImpl implements ItemsService {

    private final static Logger logger = LoggerFactory.getLogger(ItemsServiceImpl.class);

    @Autowired
    private ItemsMapper itemsMapper;

    public List<Items> listAll() {
        logger.info("hahaha");
        return itemsMapper.list();
    }

    public Items detail(@RequestParam(name = "id") Long id) {
        return itemsMapper.getDetail(id);
    }
}
