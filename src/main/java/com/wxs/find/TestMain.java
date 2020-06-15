package com.wxs.find;

import com.wxs.entity.Fly;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-06-11
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class TestMain extends Fly {



    public void ss(){
        show();
        Fly fly = new Fly();

    }




    public static void main(String[] args) {

        TestMain testMain = new TestMain();

        testMain.show();


        Fly fly = new Fly();


        System.out.println(testMain instanceof Fly );



    }

}
