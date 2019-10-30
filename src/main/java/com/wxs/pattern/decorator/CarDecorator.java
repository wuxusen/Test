package com.wxs.pattern.decorator;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-10-30
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public abstract class CarDecorator  extends ACar{


    private ACar aCar;


    public CarDecorator(ACar aCar){

        this.aCar = aCar;
    }


    @Override
    public String show() {
        return this.aCar.show();
    }


    @Override
    public int getPrice() {
        return this.aCar.getPrice();
    }

    public abstract void doSomeThing();






}
