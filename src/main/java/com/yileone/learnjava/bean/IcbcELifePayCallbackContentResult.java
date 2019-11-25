package com.yileone.learnjava.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Title: IebcELifeCommonResult.class
 * Description: 工行e支付回调业务参数
 * <p>
 * Create DateTime: 2019-07-04 20:02
 *
 * @author zyf
 */
@Data
public class IcbcELifePayCallbackContentResult {

    @JSONField(name = "return_code")    // fastjson认得
    @ApiModelProperty(value = "返回码，交易成功返回0，其余为失败情况", required = true, example = "0")
    private String returnCode;

//    @JsonProperty("return_msg")
    @ApiModelProperty(value = "返回码说明", required = true, example = "")
    private String returnMsg;

//    @JsonProperty("msg_id")
    @ApiModelProperty(value = "消息号", required = true, example = "urcnl24ciutr9")
    private String msgId;

    @JsonProperty("pay_status")
    @ApiModelProperty(value = "交易结果标志，0：支付中，1：支付成功，2：支付失败", required = false, example = "0")
    private String payStatus;

    @JsonProperty("cust_id")
    @ApiModelProperty(value = "用户唯一标识", required = false, example = "Ey0LsS39FwdE35TsSW1A2eeoIRMZrjSa")
    private String custId;

    @JsonProperty("card_no")
    @ApiModelProperty(value = "屏蔽后的银行卡号", required = false, example = "528856**3754")
    private String cardNo;

    @JsonProperty("total_amt")
    @ApiModelProperty(value = "订单总金额，单位：分", required = false)
    private Long totalAmt;

    @JsonProperty("point_amt")
    @ApiModelProperty(value = "积分抵扣金额，单位：分", required = false)
    private Long pointAmt;

    @JsonProperty("ecoupon_amt")
    @ApiModelProperty(value = "电子券抵扣金额，单位：分", required = false)
    private Long ecouponAmt;

    @JsonProperty("mer_disc_amt")
    @ApiModelProperty(value = "优惠立减金额，单位：分", required = false)
    private Long merDiscAmt;

    @JsonProperty("coupon_amt")
    @ApiModelProperty(value = "优惠券金额，单位：分", required = false)
    private Long couponAmt;

    @JsonProperty("bank_disc_amt")
    @ApiModelProperty(value = "银行补贴金额，单位：分", required = false)
    private Long bankDiscAmt;

    @JsonProperty("payment_amt")
    @ApiModelProperty(value = "用户实际扣减金额，单位：分", required = false)
    private Long paymentAmt;

    @JsonProperty("out_trade_no")
    @ApiModelProperty(value = "商户系统订单号，单位：分", required = false)
    private String outTradeNo;

    @JsonProperty("order_id")
    @ApiModelProperty(value = "行内系统订单号(特约商户27位，特约部门30位)", required = false)
    private String orderId;

    @JsonProperty("pay_time")
    @ApiModelProperty(value = "支付完成时间，yyyyMMdd格式", required = false)
    private String payTime;

    @JsonProperty("total_disc_amt")
    @ApiModelProperty(value = "总优惠金额，其值=优惠立减金额（商户部分）+银行补贴金额，单位：分", required = false)
    private Long totalDiscAmt;

    @JsonProperty("mer_id")
    @ApiModelProperty(value = "商户线下档案编号(特约商户12位，特约部门15位)", required = false)
    private String merId;

    @JsonProperty("attach")
    @ApiModelProperty(value = "商户上送的附加数据，原样返回", required = false)
    private String attach;

}
