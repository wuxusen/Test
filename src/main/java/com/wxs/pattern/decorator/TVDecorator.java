package com.wxs.pattern.decorator;

/**
 * 类描述  ：Tv 具体装饰
 * 创建人  : 吴绪森
 * 创建时间：2019-10-30
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class TVDecorator extends CarDecorator{


    public TVDecorator(ACar aCar){
        super(aCar);
    }


    @Override
    public int getPrice() {
        return super.getPrice() + 5;
    }


    @Override
    public String show() {
        return super.show()+" 换电视";
    }

    @Override
    public void doSomeThing() {

    }
}
