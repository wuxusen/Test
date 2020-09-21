package com.wxs.designPatterns.decorator;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-07-14
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class Concreate2Decorator extends Decorator {


    public Concreate2Decorator(Component component) {
        super(component);
    }


    @Override
    public void sampleOperation() {

        System.out.println("no2 >>  调用被装饰者实例之前修饰");
        super.sampleOperation();

        System.out.println("no2 >>  调用被装饰者实例之后修饰");



    }
}
