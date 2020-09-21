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

public class TestDecorator {

    public static void main(String[] args) {


        // 创建一个被装饰者类
        Component component = new ConcreteComponent();
      //  component.sampleOperation();


        Component decorator = new ConcreteDecorator(component);
    //    decorator.sampleOperation();


        Component decorator2  = new Concreate2Decorator(decorator);

        decorator2.sampleOperation();
    }
}
