package com.yileone.learnjava.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * 1. 在类上添加@WebService注解,代表发布一个WebService服务
 * 2. 通过EndPoint(端点服务)发布一个webService。Endpoint也是jdk提供的一个专门用于发布服务的类，它的publish方法接收两个参数，一个是本地的服务地址，二是提供服务的类。它位于javax.xml.ws.*包中。
 * 3. Endpoint.publish(String address, Object implementor) 静态方法在给定地址处针对指定的实现者对象创建并发布端点
 * 4. 给类添加上@WebService注解后，类中所有的非静态方法都将会对外公布
 * 5. 如果希望某个方法不对外公开，可以在方法上添加@WebMethod(exclude=true)，阻止对外公开。
 * 6. 如果一个类上，被添加了@WebService注解，则必须此类至少有一个可以公开的方法，否则将会启动失败。
 * 注意： protected、private、final、static方法不能对外公开
 *
 * @author: jinyuan
 * @since: 2020/2/27 16:31
 */
@WebService(serviceName = "PhoneManager",//修改服务名
        targetNamespace = "http://webservice.learnjava.yileone.com")//修改命名空间 ，默认包名，取反
//声明该业务类 对外提供webservice服务,默认只是对public 修饰的方法对外以webservice形式发布
public class PhoneService {

    /**@WebMethod(operationName="getMObileInfo"): 修改方法名
     * @WebResult(name="phone")：修改返回参数名
     * @WebParam(name="osName")：修改输入参数名
     */
    @WebMethod(operationName = "getMobileInfo")
    public @WebResult(name = "phone") Phone getPhoneInfo(@WebParam(name = "osName") String osName) {
        Phone phone = new Phone();
        if (osName.endsWith("android")) {
            phone.setName("android");
            phone.setOwner("google");
            phone.setTotal(80);
        } else if (osName.endsWith("ios")) {
            phone.setName("ios");
            phone.setOwner("apple");
            phone.setTotal(15);
        } else {
            phone.setName("windows phone");
            phone.setOwner("microsoft");
            phone.setTotal(5);
        }
        return phone;
    }

    @WebMethod(exclude = true)//把该方法排除在外
    public void sayHello(String city){
        System.out.println("你好："+city);
    }

    private void sayLuck(String city){
        System.out.println("好友："+city);
    }
    void sayGoodBye(String city){
        System.out.println("拜拜:"+city);
    }
    protected void saySayalala(String city){
        System.out.println("再见！"+city);
    }

    public static void main(String[] args) {
        String address = "http://127.0.0.1:8888/ws/phoneService";
        /**
         * 发布webservice服务
         * 1.address：服务的地址
         * 2：implementor 服务的实现对象
         */
        Endpoint.publish(address, new PhoneService());
        System.out.println("wsdl地址 : " + address + "?WSDL");
    }
}
