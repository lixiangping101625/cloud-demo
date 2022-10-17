package com.hlkj.item.mapper;

import com.hlkj.item.pojo.Items;
import com.hlkj.my.mapper.MyMapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Lixiangping
 * @createTime 2022年10月17日 16:51
 * @decription:
 */
public interface ItemsMapper extends MyMapper<Items> {

    //fixme 注意搜索应该划分到主搜模块
    List<Items> list();

    Items getDetail(@Param("id") Long id);

}
