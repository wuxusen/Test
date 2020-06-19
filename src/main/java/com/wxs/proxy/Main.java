package com.wxs.proxy;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-06-17
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class Main {

    public static void main(String[] args) {

        MeProxy meProxy = new MeProxy();

        UserControllerr user =  (UserControllerr)meProxy.createProxy(new UserControllerr());

        user.say();

    }
}
