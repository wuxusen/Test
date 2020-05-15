package com.wxs.thread;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-05-15
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class TestCallable {


    public static void main(String[] args) {


        String a = "aaaaaa_aaa_aaaaa";

        System.out.println(getApiName(a));
        System.out.println(getApiName("test_assf_sss_eeesfb"));
        System.out.println(getApiName("pro_abcdefg_highlmn"));


    }


    private static String getApiName(String str){

        int pro_ = str.indexOf("pro_");
        int test_ = str.indexOf("test_");

        if(pro_ != -1){
            return str.substring(pro_+4);
        }
        if(test_ != -1){
            return str.substring(test_+ 5);
        }
        return str;
    }

}
