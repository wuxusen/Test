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

public class Decorator implements  Component{

    private Component component;

    public Decorator(Component component){
        this.component = component;
    }


    @Override
    public void sampleOperation() {

        component.sampleOperation();
    }
}
