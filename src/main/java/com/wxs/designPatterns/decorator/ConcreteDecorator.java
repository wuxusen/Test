package com.wxs.designPatterns.decorator;

/**
 * 类描述  ： 具体装饰类
 * 创建人  : 吴绪森
 * 创建时间：2020-07-14
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class ConcreteDecorator extends  Decorator {


    public ConcreteDecorator(Component component) {
        super(component);
    }


    @Override
    public void sampleOperation() {

        System.out.println("no1 >>  调用被装饰者实例之前修饰");


        super.sampleOperation();


        System.out.println("no1 >>  调用被装饰者实例之后修饰");
    }
}
