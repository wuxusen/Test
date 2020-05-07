package com.wxs.business;

import java.util.ArrayList;




public class Test {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//
		ArrayList<UpbaaDate> list=new ArrayList<UpbaaDate>();
		UpbaaDate  date01=new UpbaaDate("2012/01/21",-20000);
//		date01.payment=-20000;
//		
		UpbaaDate  date02=new UpbaaDate("2012/02/21",5000);
//		date02.payment=7000;
//		
		UpbaaDate  date03=new UpbaaDate("2012/03/01",10000);
//		date03.payment=10000;
////		
////		CocoonDate  date04=new CocoonDate("2013/05/03");
////		date04.payment=34668.3f;
		list.add(date01);
		list.add(date02);
		list.add(date03);
//	//	list.add(date04);
		System.out.println("01="+System.currentTimeMillis());
		XirrData Xirr=new XirrData(list);
		System.out.println("02="+System.currentTimeMillis());
		//Log.e("aaaaaaaa", "tan="+Math.tan(45));
	System.out.println("Xirr="+Xirr.getXirr());
//		System.out.println("tan="+((96.31693-74)/(74*74));
	}
}
