package com.remcal.domain;

import java.math.BigDecimal;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/11/2
 * CREATE TABLE `tb_cart` (
 *   `id` int(11) NOT NULL,
 *   `pid` int(11) NOT NULL DEFAULT '0',
 *   `num` int(11) DEFAULT NULL,
 *   `money` decimal(8,2) DEFAULT NULL,
 *   PRIMARY KEY (`id`,`pid`),
 *   KEY `fk_cart_pid` (`pid`),
 *   CONSTRAINT `fk_cart_id` FOREIGN KEY (`id`) REFERENCES `tb_user` (`id`),
 *   CONSTRAINT `fk_cart_pid` FOREIGN KEY (`pid`) REFERENCES `tb_goods` (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8
 */
public class Cart {
    private Integer id;
    private Integer pid;
    private Integer num;
    private BigDecimal money;

    public Cart(Integer id, Integer pid, Integer num, BigDecimal money) {
        this.id = id;
        this.pid = pid;
        this.num = num;
        this.money = money;
    }

    public Cart() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
