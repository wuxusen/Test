package com.wxs.designPatterns.decorator;

/**
 * 类描述  ： 这个类就是被装饰的类
 * 创建人  : 吴绪森
 * 创建时间：2020-07-14
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class ConcreteComponent implements Component{

    @Override
    public void sampleOperation() {

        System.out.println("我是被装饰者 ConcreteComponent");

    }
}
