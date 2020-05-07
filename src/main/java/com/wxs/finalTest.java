package com.wxs;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-10-30
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class finalTest {


    public static void main(String[] args) {


       final int a = 10;

        TestInnerClass testInnerClass = new finalTest().new TestInnerClass(a);

        testInnerClass.doSomething();
        System.out.println(a);



    }






    class TestInnerClass extends finalTest {


        private int val$num;

        TestInnerClass(int var2) {

            this.val$num = var2;

        }


        void doSomething() {


            System.out.println("val$num-----"+val$num);

            System.out.println("val$num----- + 2 "+(val$num+2));
        }
    }



}
