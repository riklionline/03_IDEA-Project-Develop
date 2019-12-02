package com.remcal.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/11/2
 * CREATE TABLE `tb_goods` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `name` varchar(100) NOT NULL,
 *   `pubdate` date DEFAULT NULL,
 *   `picture` varchar(255) NOT NULL,
 *   `price` decimal(8,2) NOT NULL,
 *   `star` tinyint(4) NOT NULL DEFAULT '0',
 *   `intro` text,
 *   `typeid` int(11) NOT NULL,
 *   PRIMARY KEY (`id`),
 *   KEY `fk_typeid` (`typeid`),
 *   CONSTRAINT `fk_typeid` FOREIGN KEY (`typeid`) REFERENCES `tb_goods_type` (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8
 */
public class Goods {
    private Integer id;
    private String name;
    private Date pubdate;
    private String picture;
    private BigDecimal price;
    private Integer star;
    private String intro;
    private Integer typeId;
    private GoodsType goodsType;

    public Goods(Integer id, String name, Date pubdate, String picture, BigDecimal price, Integer star, String intro, Integer typeId) {
        this.id = id;
        this.name = name;
        this.pubdate = pubdate;
        this.picture = picture;
        this.price = price;
        this.star = star;
        this.intro = intro;
        this.typeId = typeId;
    }

    public Goods() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public GoodsType getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(GoodsType goodsType) {
        this.goodsType = goodsType;
    }
}
