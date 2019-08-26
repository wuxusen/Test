package com.wxs;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-07-09
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class TestLink {


    public static void main(String[] args) {


        String str = "abcdefedcba";

        char[] chars = str.toCharArray();

        System.out.println(chars.length);



    }

    public static boolean isPhrase(char[] chars){

       int length =  chars.length;

       if(length < 1){
           throw  new RuntimeException("---");
       }

       int half ;


       if(length % 2 == 0){

           half = length / 2 ;

       }else {

           half = length / 2 + 1;
       }





        return true;
    }






}
