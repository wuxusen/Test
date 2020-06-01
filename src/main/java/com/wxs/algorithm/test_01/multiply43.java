package com.wxs.algorithm.test_01;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-05-25
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class multiply43 {


    public static void main(String[] args) {


        String a = "abcs";

        System.out.println(a.charAt(1));


        multiply43 multiply43 = new multiply43();

        String multiply = multiply43.multiply("123", "456");

        System.out.println(multiply);
    }


    public String multiply(String num1, String num2) {

        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }


        int[] res = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';

            for (int j = num2.length() - 1; j >= 0; j--) {

                int n2 = num2.charAt(j) - '0';

                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            s.append(res[i]);

        }

        return s.toString();
    }


    public String multiply1(String num1, String num2) {

        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int[] res = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = res[i + j + 1] + n1 * n2;
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }

        }

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            s.append(res[i]);
        }

        return s.toString();
    }

}
