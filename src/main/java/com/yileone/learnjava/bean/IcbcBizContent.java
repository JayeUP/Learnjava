package com.yileone.learnjava.bean;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author jinyuan
 * @since 2019-11-12
 */
@Data
@ToString
public class IcbcBizContent extends Model<IcbcBizContent> {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;
    /**
     * 我们的预支付订单号
     */
    @TableField("pre_order_id")
    private String preOrderId;
    /**
     * 我们的订单编号
     */
    @TableField("order_code")
    private String orderCode;
    /**
     * 用户唯一标识
     */
    @TableField("cust_id")
    private String custId;
    /**
     * 屏蔽后的银行卡号
     */
    @TableField("card_no")
    private String cardNo;
    /**
     * 订单总金额，单位：分
     */
    @TableField("total_amt")
    private Long totalAmt;
    /**
     * 积分抵扣金额，单位：分
     */
    @TableField("point_amt")
    private Long pointAmt;
    /**
     * 电子券抵扣金额，单位：分
     */
    @TableField("ecoupon_amt")
    private Long ecouponAmt;
    /**
     * 优惠立减金额（商户部分），单位：分
     */
    @TableField("mer_disc_amt")
    private Long merDiscAmt;
    /**
     * 优惠券金额，单位：分
     */
    @TableField("coupon_amt")
    private Long couponAmt;
    /**
     * 银行补贴金额，单位：分
     */
    @TableField("bank_disc_amt")
    private Long bankDiscAmt;
    /**
     * 用户实际扣减金额，单位：分
     */
    @TableField("payment_amt")
    private Long paymentAmt;
    /**
     * 行内系统订单号(特约商户27位，
特约部门30位)
     */
    @TableField("bank_order_id")
    private String bankOrderId;
    /**
     * 支付完成时间，yyyyMMdd格式
     */
    @TableField("pay_time")
    private String payTime;
    /**
     * 总优惠金额，其值=优惠立减金额
（商户部分）+银行补贴金额，单位：分
     */
    @TableField("total_disc_amt")
    private Long totalDiscAmt;
    /**
     * 商户线下档案编号(特约商户12位，
特约部门15位)
     */
    @TableField("mer_id")
    private String merId;
    /**
     * 商户上送的附加数据，原样返回
     */
    @TableField("attach")
    private String attach;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
