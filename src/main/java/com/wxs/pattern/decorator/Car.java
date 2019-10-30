package com.wxs.pattern.decorator;

/**
 * 类描述  ： 具体构件
 * 创建人  : 吴绪森
 * 创建时间：2019-10-30
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class Car  extends  ACar{


    @Override
    public int getPrice() {
        return 50;
    }

    @Override
    public String show() {
        return "车";
    }
}
