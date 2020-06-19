package com.wxs.designPatterns.callBack;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-06-18
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public interface Icallbackk {

    void methodTocallBack();

}

 class BClass{

    public void process(Icallbackk back){

        back.methodTocallBack();
    }

}


class AClass{
    public static void main(String[] args) {

        BClass bClass = new BClass();

        bClass.process(()->{
            System.out.println("call back me ");
        });


    }



}


interface AA{
    void  show(String a,String b);
}

class BB{
    public static void main(String[] args) {

        BB bb = new BB();
        bb.ss((e1,e2)->{});


        new Thread(()->{}).start();
    }


    private void ss(AA aa){
        aa.show("a","b");
    }
}