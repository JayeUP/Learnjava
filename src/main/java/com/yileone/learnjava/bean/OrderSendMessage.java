package com.yileone.learnjava.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by ZhengXinShuai on 2018/7/13.
 */
@Data
public class OrderSendMessage implements Serializable{
    //订单号
    private String orderCode;

    //1.支付成功 2.支付失败
    private Integer payState;

    //支付订单号
    private String paymentCode;

    private String merchantId;

    private String preOrderId;

    private String notifyTime;

    private BigDecimal merchantContribute;

    private String isFreeze;

    private IcbcELifePayCallbackContentResult icbcELifePayCallbackContentResult;

}
