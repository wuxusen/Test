package com.wxs.xirr;

import java.util.ArrayList;
import java.util.List;

public class Xirr {
    public static void main(String[] args) {
        ArrayList<UpbaaDate> list = new ArrayList<UpbaaDate>();

        List<String> date = getDates();
        List<Double> money = getCashFlow();


        for (int i = 0; i < date.size(); i++) {
            list.add(new UpbaaDate(date.get(i), money.get(i)));
        }

        double xirr = new XirrData(list).getXirr();//普通XIRR
        System.out.println(xirr);//输出  0.049039049520590336

    }

    //准备测试数据--日期
    public static List<String> getDates() {
        List<String> list = new ArrayList<String>();
        

        list.add("2014/09/12");
        list.add("2014/09/15");
        list.add("2015/01/21");
        list.add("2015/01/22");
        list.add("2015/01/23");

        return list;
    }

    //准备测试数据--现金流(先负 后正)
    public static List<Double> getCashFlow() {


        //-2000000, -1440000, 1395707.34, 894588.37, 0
        List<Double> list = new ArrayList<Double>();


        list.add(-2007000D);
        list.add(-1440398.97);
        list.add(894588.37);
        list.add(1395707.34);
        list.add(46732.13);


        return list;
    }


}