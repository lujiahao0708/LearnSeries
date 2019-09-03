package com.hellodev.base.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author lujiahao
 * @date 2019-09-03 19:29
 */
@Entity
@Table(name = "tb_label")
@Data
public class Label implements Serializable {
    private static final long serialVersionUID = -5312222516469860624L;

    @Id
    private String id;
    private String labelname;   // 标签名称
    private String state;   // 状态
    private Long count; // 使用数量
    private Long fans;  // 关注数
    private String recommend;   // 是否推荐
}
