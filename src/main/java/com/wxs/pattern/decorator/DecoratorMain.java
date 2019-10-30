package com.wxs.pattern.decorator;

import java.io.IOException;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-10-30
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class DecoratorMain {


    public static void main(String[] args) throws IOException {

        ACar aCar = new Car();

        aCar = new TireDecorator(aCar);
        aCar = new TVDecorator(aCar);

//
//        System.out.println("价格 == "+aCar.getPrice());
//        System.out.println("改装 == "+ aCar.show());


        TVDecorator tvDecorator = new TVDecorator(new TireDecorator(new Car()));


        System.out.println("价格 == "+tvDecorator.getPrice());
        System.out.println("改装 == "+ tvDecorator.show());

      //  DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("")));



    }
}
