package com.wxs.proxy;

import java.lang.reflect.Proxy;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-06-17
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class MeProxy {

    private Mecontroller mecontroller;


   public MeProxy(){
       this.mecontroller = new Mecontroller();
   }


   public Object createProxy(Object proxiedObject){

       Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();

       DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler(proxiedObject);

       return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(),interfaces,dynamicProxyHandler);


   }



}
