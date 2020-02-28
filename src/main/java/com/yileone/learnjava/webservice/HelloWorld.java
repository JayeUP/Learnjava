package com.yileone.learnjava.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * @author: jinyuan
 * @since: 2020/2/27 16:51
 */
@WebService  // 添加了此注解,代表是一个WebService
public class HelloWorld {
    // 非 static final private 方法默认会发布
    public String sayHi(String name) {
        return "hello" + name;
    }

    @WebMethod(exclude = true)
    public void exclude() {
        // 被注解排除的方法
    }
    protected void protected1(){
        // 受保护的方法默认不发布
    }
    private void private1(){
        // 私有方法默认不发布
    }
    public static void static1(){
        // static 方法默认不发布
    }
    public final void final1(){
        // final 方法默认不发布
    }

    public static void main(String[] args) {
        String address = "http://127.0.0.1:8887/ws/helloWorldService";
        Endpoint.publish(address, new HelloWorld());
        System.out.println("wsdl地址 : " + address + "?WSDL");
    }
}
