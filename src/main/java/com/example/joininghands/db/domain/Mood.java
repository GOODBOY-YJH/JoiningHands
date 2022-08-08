package com.example.joininghands.db.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 心情
 * @TableName mood
 */
@Data
public class Mood implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 创建者Id
     */
    private Integer createId;

    /**
     * 类型1:好心情 2 坏心情
     */
    private Integer type;

    /**
     * 标题
     */
    private String title;

    /**
     * 心情描述
     */
    private String desc;

    /**
     * 图片描述
     */
    private Object photo;

    /**
     * 是否解决
     */
    private Integer isresolve;

    /**
     * 心情解决时间
     */
    private Date resolveTime;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}