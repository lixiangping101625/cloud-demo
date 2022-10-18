package com.hlkj.item.controller;

import com.hlkj.item.pojo.Items;
import com.hlkj.item.service.ItemsService;
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
@RequestMapping("/items")
@Api(value = "商品接口", tags = "商品信息展示相关接口")
public class ItemController {
    @Resource
    private ItemsService itemsService;

    @ApiOperation(value = "查询所有", tags = "查询所有商品信息")
    @GetMapping("/listAll")
    public List<Items> list(){
        return itemsService.listAll();
    }
    @ApiOperation(value = "查询商品详情", tags = "查询商品详情")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id",value = "商品id", required = true)
    )
    @GetMapping("/info")
    public Items detail(@RequestParam(name = "id") Long id){
        return itemsService.detail(id);
    }
}
