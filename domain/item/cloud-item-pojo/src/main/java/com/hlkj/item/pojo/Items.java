package com.hlkj.item.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Lixiangping
 * @createTime 2022年10月17日 16:42
 * @decription: 商品
 */
@Table(name = "item")
@Data
public class Items implements Serializable {

    @Id
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "main_img")
    private String mainImg;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "stock")
    private String stock;


}
