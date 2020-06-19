package com.wxs.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-06-17
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class DynamicProxyHandler implements InvocationHandler {



    private Object proxiedObject;



    public DynamicProxyHandler(Object proxiedObject){
        this.proxiedObject = proxiedObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("调用目标方法前 》》》》》》》》》》");
        Object invoke = method.invoke(proxiedObject, args);
        System.out.println("调用目标方法后 》》》》》》》》》》");

        return invoke;
    }
}
