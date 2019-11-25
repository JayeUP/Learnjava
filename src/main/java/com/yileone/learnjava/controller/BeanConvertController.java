package com.yileone.learnjava.controller;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.yileone.learnjava.bean.IcbcBizContent;
import com.yileone.learnjava.bean.IcbcELifePayCallbackContentResult;
import com.yileone.learnjava.bean.OrderSendMessage;
import com.yileone.learnjava.bean.Student;
import com.yileone.learnjava.util.CommTool;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * @author: jinyuan
 * @since: 2019/11/6 16:12
 */
@RestController
@RequestMapping("/bean_convert")
public class BeanConvertController {

    @RequestMapping("/one")
    public Student toStudent(HttpServletRequest request) throws InvocationTargetException, IllegalAccessException {
        Student student = new Student();
        System.out.println("Parameters = " + JSONUtil.toJsonStr(request.getParameterMap()));
        BeanUtils.populate(student, request.getParameterMap());
        System.out.println("student = " + student.toString());
        return student;
    }

    @RequestMapping("/copy")
    public void copyBean() {
        String biz_content = "{\"ecoupon_amt\":0,\"mer_id\":\"120208999442\",\"return_msg\":\"success\",\"total_disc_amt\":1900,\"pay_time\":\"20191113\",\"total_amt\":2000,\"out_trade_no\":\"644097692704317440\",\"card_no\":\"622237******9681\",\"bank_disc_amt\":0,\"coupon_amt\":0,\"attach\":\"\",\"payment_amt\":100,\"mer_disc_amt\":1900,\"msg_id\":\"120208999442201911133426526\",\"point_amt\":0,\"return_code\":\"0\",\"cust_id\":\"GvLAm4GgbMKLCEr9aswQ/dWtJj6o12Cl\",\"order_id\":\"120208999442201911133426526\"}";
        IcbcELifePayCallbackContentResult bizContent = JSONObject.parseObject(biz_content, IcbcELifePayCallbackContentResult.class);

        OrderSendMessage orderSendMessage = new OrderSendMessage();
        orderSendMessage.setOrderCode("1");
        orderSendMessage.setPayState(2);
        orderSendMessage.setPaymentCode("3");
        orderSendMessage.setMerchantId("4");
        orderSendMessage.setPreOrderId("5");
        orderSendMessage.setNotifyTime("6");
        orderSendMessage.setIcbcELifePayCallbackContentResult(bizContent);

        String jsonStr = JSONUtil.toJsonStr( orderSendMessage );
        OrderSendMessage message1 = JSONUtil.toBean( jsonStr, OrderSendMessage.class );

        IcbcELifePayCallbackContentResult icbcELifePayCallbackContentResult = message1.getIcbcELifePayCallbackContentResult();
        IcbcBizContent icbcBizContent = new IcbcBizContent();
        org.springframework.beans.BeanUtils.copyProperties(icbcELifePayCallbackContentResult, icbcBizContent);
        icbcBizContent.setPreOrderId(icbcELifePayCallbackContentResult.getOutTradeNo());
        icbcBizContent.setOrderCode("1");
        icbcBizContent.setBankOrderId(icbcELifePayCallbackContentResult.getOrderId());

        System.out.println("icbcBizContent = " + icbcBizContent.toString());
    }

    public static void main(String[] args) {
        String biz_content = "{\"ecoupon_amt\":0,\"mer_id\":\"120208999442\",\"return_msg\":\"success\",\"total_disc_amt\":1900,\"pay_time\":\"20191113\",\"total_amt\":2000,\"out_trade_no\":\"644097692704317440\",\"card_no\":\"622237******9681\",\"bank_disc_amt\":0,\"coupon_amt\":0,\"attach\":\"\",\"payment_amt\":100,\"mer_disc_amt\":1900,\"msg_id\":\"120208999442201911133426526\",\"point_amt\":0,\"return_code\":\"0\",\"cust_id\":\"GvLAm4GgbMKLCEr9aswQ/dWtJj6o12Cl\",\"order_id\":\"120208999442201911133426526\"}";
        // fastjson和hutool的json在解析json字符串到实体类的时候，会智能匹配 op_id->opid->ipId 都可以匹配
        IcbcELifePayCallbackContentResult bizContent = JSONObject.parseObject(biz_content, IcbcELifePayCallbackContentResult.class);
        IcbcELifePayCallbackContentResult bizContent1 = JSONUtil.toBean(biz_content, IcbcELifePayCallbackContentResult.class);
        System.out.println("bizContent = " + bizContent.toString());
        System.out.println("bizContent1 = " + bizContent1.toString());
        OrderSendMessage orderSendMessage = new OrderSendMessage();
        orderSendMessage.setOrderCode("1");
        orderSendMessage.setPayState(2);
        orderSendMessage.setPaymentCode("3");
        orderSendMessage.setMerchantId("4");
        orderSendMessage.setPreOrderId("5");
        orderSendMessage.setNotifyTime("6");
        orderSendMessage.setIcbcELifePayCallbackContentResult(bizContent);

        String jsonStr = JSONUtil.toJsonStr( orderSendMessage );
        String fastJsonStr = JSONObject.toJSONString(orderSendMessage);
        System.out.println("jsonStr = " + jsonStr);
        System.out.println("fastJsonStr = " + fastJsonStr);
        OrderSendMessage message1 = JSONUtil.toBean( jsonStr, OrderSendMessage.class );

        IcbcELifePayCallbackContentResult icbcELifePayCallbackContentResult = message1.getIcbcELifePayCallbackContentResult();
        IcbcBizContent icbcBizContent = new IcbcBizContent();
        org.springframework.beans.BeanUtils.copyProperties(icbcELifePayCallbackContentResult, icbcBizContent);
        icbcBizContent.setPreOrderId(icbcELifePayCallbackContentResult.getOutTradeNo());
        icbcBizContent.setOrderCode("1");
        icbcBizContent.setBankOrderId(icbcELifePayCallbackContentResult.getOrderId());
        System.out.println("icbcBizContent = " + icbcBizContent.toString());

        Integer s = null;
        if (s == 1) {
            System.out.println("s = " + s);
        }
    }
}
