package com.lhb.wechat.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * 时间操作工具
 * @author 
 * @version
 */
public class TimeUtil
{
	/**
	 * 月
	 */
	public static final int MONTH = 1;
	/**
	 * 周
	 */
	public static final int WEEK = 2;
	/**
	 * 日
	 */
	public static final int DAY = 3;
	/**
	 * 时
	 */
	public static final int HOUR = 4;
	/**
	 * 分钟
	 */
	public static final int MINUTE = 5;
	/**
	 * 秒
	 */
	public static final int SECOND = 6;
	/**
	 * 一天的毫秒数
	 */
	public static final long ONEDAYMILLIS = 86400000;
	
	/**
	 * 对指定的时间进行添加
	 * @param timeUnit
	 * @param amount
	 * @return
	 */
	public static Date dateAddByDate(Date dateTime, int timeUnit, int amount)
	{
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(dateTime);
		switch(timeUnit)
		{
		case TimeUtil.MONTH:
			rightNow.add(Calendar.MONTH, amount);
			break;
		case TimeUtil.WEEK:
			rightNow.add(Calendar.DAY_OF_MONTH, amount * 7);
			break;
		case TimeUtil.DAY:
			rightNow.add(Calendar.DAY_OF_MONTH, amount);
			break;
		case TimeUtil.HOUR:
			rightNow.add(Calendar.HOUR_OF_DAY, amount);
			break;
		case TimeUtil.MINUTE:
			rightNow.add(Calendar.MINUTE, amount);
			break;
		case TimeUtil.SECOND:
			rightNow.add(Calendar.SECOND, amount);
			break;
		}
		
		return rightNow.getTime();
		
	}
	/**
	 * 格式化时间为字符串格式
	 * @param date 输入日期
	 * @param format 日期格式
	 * @return
	 */
	public static String formatDateToString(Date date, String format){
		try{
			if(date == null)
				return "";
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		}
		catch(Exception ex){
			return "";
		}
	}
	/**
	 * 返回指定的时间格式的日期
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getDateStr(Date date,String format){

		String dateTimeStr = formatDateToString(date, format);
		return dateTimeStr;

	}
	/**
	 * 获取当前年份
	 * @return 年份
	 */
	public static int getYear(Date date){
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR);
	}

	/**
	 * 返回当前时间的时间戳
	 * @return
	 */
	public static long getCurrentTimeStamp()
	{
		return Calendar.getInstance().getTimeInMillis();
	}
	
	/**
	 * 根据指定的格式获取时间字符串
	 * @param format 指定的时间格式
	 * @return 指定时间格式的字符串
	 */
	public static String getCurrentTime(String format)
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(cal.getTime());
	}
	
	/**
	 * 将字符串转固定格式的日期类型
	 * @param value
	 * @param format
	 * @return
	 */
	public static Date convertStringToDate(String value, String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if(value == null)
			return null;
		try
		{
			return sdf.parse(value);
		}
		catch(Exception e)
		{
			return null;
		}
	}

	/**
	 * 根据指定的的时间获取当前月份的天数
	 * @param dateDest
	 * @return
	 */
	public static int getAmountOfMonthByDate(String dateDest){
		Calendar calStart = Calendar.getInstance();
		Date date = convertStringToDate(dateDest, "yyyy-MM");
		calStart.setTime(date);
		int amount = calStart.getActualMaximum(Calendar.DAY_OF_MONTH);
		return amount;
		
	}

	
}
