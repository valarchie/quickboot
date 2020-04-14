package com.valarchie.quickboot.account.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author valarchie
 * @since 2020-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    /**
     * 余额
     */
    private Integer money;

    /**
     * 折扣
     */
    private Integer discount;

    /**
     * 优惠券
     */
    private Integer coupon;

    /**
     * 红包
     */
    private Integer redPacket;


}
