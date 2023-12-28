package com.collegevol.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 活动图片表
 * </p>
 *
 *
 * @since 2019-09-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class EventPicture implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增长图片id
     */
    @TableId(value = "ep_id", type = IdType.AUTO)
    private Integer epId;

    /**
     * 活动ID
     */
    private Integer eventId;

    /**
     * 图片地址
     */
    private String imgUrl;


}
