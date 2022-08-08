package com.example.joininghands.db.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户表
 * @TableName user
 */
@Data
public class User implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 伴侣id
     */
    private Integer mateId;

    /**
     * 微信小程序openId
     */
    private String openId;

    /**
     * 微信名
     */
    private String name;

    /**
     * 性别
     */
    private Object sex;

    /**
     * 头像
     */
    private String photo;

    /**
     * 电话
     */
    private String tel;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 状态（是否注销）
     */
    private Integer status;

    /**
     * 
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}