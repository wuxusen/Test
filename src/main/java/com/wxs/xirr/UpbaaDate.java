package com.wxs.xirr;

public class UpbaaDate {
	public int year;
	public int month;
	public int day;
	public double payment;// 对应的现金
 
	public UpbaaDate(int year, int month, int day, double payment) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.payment = payment;
	}
 
	/**
	 * 
	 * @param stringTime
	 *            格式为：2013/02/05
	 * @param payment  对应的现金
	 */
	public UpbaaDate(String stringTime, double payment) {
		try {			
			this.year=Integer.parseInt(stringTime.substring(0, 4));
			this.month=Integer.parseInt(stringTime.substring(5, 7));
			this.day=Integer.parseInt(stringTime.substring(8, 10));			
		} catch (Exception e) {
			// TODO: handle exception
		}
		this.payment=payment;
	}
 
	/**
	 * 使用默认构造方法的话，则对应的是当前的时间，即今天的时间
	 */
	public UpbaaDate() {
		String stringTime=DateUtil.getNowStringDate("/");
		setStringDate(stringTime);
	}
	/**
	 * 设置年月日的字符串格式的时间 
	 * @param stringTime  格式为：2013/02/05
	 */
	public void setStringDate(String stringTime){
		try {			
			this.year=Integer.parseInt(stringTime.substring(0, 4));
			this.month=Integer.parseInt(stringTime.substring(5, 7));
			this.day=Integer.parseInt(stringTime.substring(8, 10));			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * 获得1970年到现在的天数
	 * @return long
	 */
	public long getDaysFrom1970(){
		return DateUtil.getDaysFrom1970(year, month, day);		
	}
	/**
	 * 获得字符串的日期
	 * @param split 分隔符 如 -
	 * @return  如：2013-02-22
	 */
	public String getStringDate(String split){
		if(split==null){
			split="-";
		}
		StringBuffer stringDate=new StringBuffer();
		stringDate.append(year).append(split);
		if(month<10){
			stringDate.append(0).append(month);
		}else{
			stringDate.append(month);
		}
		stringDate.append(split);
		if(day<10){
			stringDate.append(0).append(day);
		}else{
			stringDate.append(day);
		}		
		return stringDate.toString();
	}
}