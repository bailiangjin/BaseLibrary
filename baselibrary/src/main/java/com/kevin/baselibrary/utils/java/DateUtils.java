package com.kevin.baselibrary.utils.java;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils
{
	private static final String CN_TIME_FORMAT_HH_mm = "HH:mm";
	private static final String CN_TIME_FORMAT_HH_mm_ss = "HH:mm:ss";
	private static final String CN_TIME_FORMAT_M_d_HH_mm = "M月d日 HH:mm";
	private static final String CN_TIME_FORMAT_yyyy_M_d = "yyyy年M月d日";
	private static final String CN_TIME_FORMAT_yyyy_M_d_simple = "yyyy-M-d";
	private static final String CN_TIME_FORMAT_yyyy_M_d_HH_mm = "yyyy年M月d日 HH:mm";
	private static final String CN_TIME_FORMAT_yyyy_M_d_HH_mm_ss = "yyyy年M月d日 HH:mm:ss";

	/**
	 * 获取当前时间戳字符串
	 * 
	 * @return
	 */
	public static String getTimestampString()
	{
		return Long.toString(System.currentTimeMillis());
	}

	/**
	 * 获取当前时间
	 */
	public static Date getCurrentDate()
	{
		return new Date(System.currentTimeMillis());
	}

	/**
	 * 通过 时间戳 得到当前时间
	 * 
	 * @param timeMillis
	 *            时间戳
	 * @return
	 */
	public static Date getDateByTimeMillis(long timeMillis)
	{
		Timestamp timestamp = new Timestamp(timeMillis);
		return timestamp;
	}

	/**
	 * 通过 时间戳字符串 得到当前时间
	 * 
	 * @param timeMillisStr
	 *            时间戳字符串
	 * @return
	 */
	public static Date getDateByTimeMillisStr(String timeMillisStr)
	{
		Timestamp timestamp = new Timestamp(Long.parseLong(timeMillisStr));
		return timestamp;
	}

	/**
	 * 指定格式字符串转换为Date
	 * 
	 * @param patternedDateStr
	 *            符合pattern 的日期字符串
	 * @param pattern
	 *            格式
	 * @return
	 */
	public static Date StringToDate(String patternedDateStr, String pattern)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;
		try
		{
			date = sdf.parse(patternedDateStr);
		}
		catch (ParseException localParseException)
		{
			localParseException.printStackTrace();
		}
		return date;
	}

	/**
	 * 解析时间字符串
	 * 
	 * @param dateString
	 * @param format
	 * @return
	 */
	public static Date parse(String dateString, String format)
	{
		return parse(dateString, format, Locale.CHINESE, TimeZone.getDefault());
	}

	/**
	 * 解析时间字符串
	 * 
	 * @param dateString
	 * @param format
	 * @param locale
	 * @param timeZone
	 * @return
	 */
	public static Date parse(String dateString, String format, Locale locale, TimeZone timeZone)
	{
		SimpleDateFormat sdf = (SimpleDateFormat) DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,
				locale);
		sdf.applyPattern(format);
		sdf.setTimeZone(timeZone);
		Date date = null;
		try
		{
			date = sdf.parse(dateString);
		}
		catch (Exception e)
		{
			date = null;
		}
		return date;
	}

	/**
	 * 格式化日期 中国大陆
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String dateToString_CN(Date date, String pattern)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.CHINESE);
		return sdf.format(date);
	}

	/**
	 * 获得两个时间的间隔天数
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return int 间隔天数
	 */
	public static int getIntervalDays(Date beginDate, Date endDate)
	{
		if (beginDate == null || endDate == null)
			return 0;
		long between = (endDate.getTime() - beginDate.getTime()) / 1000;// 除以1000是为了转换成秒
		return (int) between / (24 * 60 * 60);
	}

	/**
	 * 判断时间间隔是否超过一天
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static boolean isOverOneDay(long startTime, long endTime)
	{
		long gap = startTime - endTime;
		if (gap < 0L)
			gap = -gap;
		long oneDayLength = 24 * 60 * 60 * 1000;
		if (gap / oneDayLength >= 1)
		{
			return true;
		}
		return false;
	}

	/**
	 * 判断两个时间戳间距是否大于一分钟
	 * 
	 * @param thisTimeStamp
	 * @param lastTimeStamp
	 * @return
	 */
	public static boolean isCloseEnough(long thisTimeStamp, long lastTimeStamp)
	{
		long l = thisTimeStamp - lastTimeStamp;
		if (l < 0L)
			l = -l;
		return l < 60000L;// 一分钟
	}

	/**
	 * 判断两个时间戳是否为同一分钟
	 * 
	 * @param thisTimeStamp
	 * @param lastTimeStamp
	 * @return
	 */
	public static boolean isSameMinute(long thisTimeStamp, long lastTimeStamp)
	{
		TimeInfo timeInfo = getThisMinuteStartAndEndTime(lastTimeStamp);
		return (thisTimeStamp >= timeInfo.getStartTime()) && (thisTimeStamp <= timeInfo.getEndTime());
	}

	/**
	 * 将服务器时间转换成当地时间
	 * 
	 * @param time
	 * @param serverTimeZone
	 *            服务器时区
	 * @return
	 */
	public static long transform(long time, String serverTimeZone)
	{
		Date resultDate = null;
		Date date = new Date(time);
		if (date != null)
		{
			// 本地时区
			Calendar localCalender = Calendar.getInstance();
			TimeZone localTimeZone = localCalender.getTimeZone();
			int timeOffset = TimeZone.getTimeZone(serverTimeZone).getRawOffset() - localTimeZone.getRawOffset();
			resultDate = new Date(date.getTime() - timeOffset);
		}
		return resultDate.getTime();
	}

	/**
	 * 获取更改时区后的时间
	 * 
	 * @param date
	 *            时间
	 * @param oldTimeZone
	 *            旧时区
	 * @param newTimeZone
	 *            新时区
	 * @return 时间
	 */
	public static Date changeTimeZone(Date date, TimeZone oldTimeZone, TimeZone newTimeZone)
	{
		Date newDate = null;
		if (date != null)
		{
			int timeOffset = oldTimeZone.getRawOffset() - newTimeZone.getRawOffset();
			newDate = new Date(date.getTime() - timeOffset);
		}
		return newDate;
	}

	/**
	 * 判断是否为今天
	 * 
	 * @param paramLong
	 * @return
	 */
	public static boolean isToday(long paramLong)
	{
		TimeInfo localTimeInfo = getTodayStartAndEndTime();
		return (paramLong >= localTimeInfo.getStartTime()) && (paramLong <= localTimeInfo.getEndTime());
	}

	/**
	 * 判断是否为昨天
	 * 
	 * @param paramLong
	 * @return
	 */
	public static boolean isYesterday(long paramLong)
	{
		TimeInfo localTimeInfo = getYesterdayStartAndEndTime();
		return (paramLong >= localTimeInfo.getStartTime()) && (paramLong <= localTimeInfo.getEndTime());
	}

	/**
	 * 判断是否为本月
	 * 
	 * @param paramLong
	 * @return
	 */
	public static boolean isThisMonth(long paramLong)
	{
		TimeInfo localTimeInfo = getThisMonthStartAndEndTime();
		return (paramLong >= localTimeInfo.getStartTime()) && (paramLong <= localTimeInfo.getEndTime());
	}

	/**
	 * 判断是否为今年
	 * 
	 * @param paramLong
	 * @return
	 */
	public static boolean isThisYear(long paramLong)
	{
		TimeInfo localTimeInfo = getThisYearStartAndEndTime();
		return (paramLong >= localTimeInfo.getStartTime()) && (paramLong <= localTimeInfo.getEndTime());
	}

	/**
	 * 获取某一分钟起始时间
	 * 
	 * @return
	 */
	public static TimeInfo getThisMinuteStartAndEndTime(long time)
	{
		Calendar localCalendarStart = Calendar.getInstance();
		localCalendarStart.setTime(new Date(time));
		localCalendarStart.set(Calendar.SECOND, 0);
		localCalendarStart.set(Calendar.MILLISECOND, 0);
		Date startDate = localCalendarStart.getTime();
		long startTime = startDate.getTime();
		Calendar localCalendarEnd = Calendar.getInstance();
		localCalendarEnd.setTime(new Date(time));
		localCalendarEnd.set(Calendar.SECOND, 59);
		localCalendarEnd.set(Calendar.MILLISECOND, 999);
		Date endDate = localCalendarEnd.getTime();
		long endTime = endDate.getTime();
		TimeInfo localTimeInfo = new TimeInfo();
		localTimeInfo.setStartTime(startTime);
		localTimeInfo.setEndTime(endTime);
		return localTimeInfo;
	}

	/**
	 * 获取今天起始时间
	 * 
	 * @return
	 */
	public static TimeInfo getTodayStartAndEndTime()
	{
		Calendar localCalendarStart = Calendar.getInstance();
		localCalendarStart.set(Calendar.HOUR_OF_DAY, 0);
		localCalendarStart.set(Calendar.MINUTE, 0);
		localCalendarStart.set(Calendar.SECOND, 0);
		localCalendarStart.set(Calendar.MILLISECOND, 0);
		Date startDate = localCalendarStart.getTime();
		long startTime = startDate.getTime();
		Calendar localCalendarEnd = Calendar.getInstance();
		localCalendarEnd.set(Calendar.HOUR_OF_DAY, 23);
		localCalendarEnd.set(Calendar.MINUTE, 59);
		localCalendarEnd.set(Calendar.SECOND, 59);
		localCalendarEnd.set(Calendar.MILLISECOND, 999);
		Date endDate = localCalendarEnd.getTime();
		long endTime = endDate.getTime();
		TimeInfo localTimeInfo = new TimeInfo();
		localTimeInfo.setStartTime(startTime);
		localTimeInfo.setEndTime(endTime);
		return localTimeInfo;
	}

	/**
	 * 获取昨天起始时间
	 * 
	 * @return
	 */
	public static TimeInfo getYesterdayStartAndEndTime()
	{
		Calendar localCalendarStart = Calendar.getInstance();
		localCalendarStart.add(Calendar.DAY_OF_MONTH, -1);// 时间向前一天
		localCalendarStart.set(Calendar.HOUR_OF_DAY, 0);
		localCalendarStart.set(Calendar.MINUTE, 0);
		localCalendarStart.set(Calendar.SECOND, 0);
		localCalendarStart.set(Calendar.MILLISECOND, 0);
		Date startDate = localCalendarStart.getTime();
		long startTime = startDate.getTime();
		Calendar localCalendarEnd = Calendar.getInstance();
		localCalendarStart.add(Calendar.DAY_OF_MONTH, -1);// 时间向前一天
		localCalendarEnd.set(Calendar.HOUR_OF_DAY, 23);
		localCalendarEnd.set(Calendar.MINUTE, 59);
		localCalendarEnd.set(Calendar.SECOND, 59);
		localCalendarEnd.set(Calendar.MILLISECOND, 999);
		Date endDate = localCalendarEnd.getTime();
		long endTime = endDate.getTime();
		TimeInfo localTimeInfo = new TimeInfo();
		localTimeInfo.setStartTime(startTime);
		localTimeInfo.setEndTime(endTime);
		return localTimeInfo;
	}

	/**
	 * 获取前天起始时间
	 * 
	 * @return
	 */
	public static TimeInfo getTheDayBeforeYesterdayStartAndEndTime()
	{
		Calendar localCalendarStart = Calendar.getInstance();
		localCalendarStart.add(Calendar.DAY_OF_MONTH, -2);// 时间向前两天
		localCalendarStart.set(Calendar.HOUR_OF_DAY, 0);
		localCalendarStart.set(Calendar.MINUTE, 0);
		localCalendarStart.set(Calendar.SECOND, 0);
		localCalendarStart.set(Calendar.MILLISECOND, 0);
		Date startDate = localCalendarStart.getTime();
		long startTime = startDate.getTime();
		Calendar localCalendarEnd = Calendar.getInstance();
		localCalendarStart.add(Calendar.DAY_OF_MONTH, -2);// 时间向前两天
		localCalendarEnd.set(Calendar.HOUR_OF_DAY, 23);
		localCalendarEnd.set(Calendar.MINUTE, 59);
		localCalendarEnd.set(Calendar.SECOND, 59);
		localCalendarEnd.set(Calendar.MILLISECOND, 999);
		Date endDate = localCalendarEnd.getTime();
		long endTime = endDate.getTime();
		TimeInfo localTimeInfo = new TimeInfo();
		localTimeInfo.setStartTime(startTime);
		localTimeInfo.setEndTime(endTime);
		return localTimeInfo;
	}

	/**
	 * 获取本月起始时间
	 * 
	 * @return
	 */
	public static TimeInfo getThisMonthStartAndEndTime()
	{
		// 开始时间
		Calendar localCalendarStart = Calendar.getInstance();
		localCalendarStart.set(Calendar.DATE, 1);
		localCalendarStart.set(Calendar.HOUR_OF_DAY, 0);
		localCalendarStart.set(Calendar.MINUTE, 0);
		localCalendarStart.set(Calendar.SECOND, 0);
		localCalendarStart.set(Calendar.MILLISECOND, 0);
		Date startDate = localCalendarStart.getTime();
		long startTime = startDate.getTime();

		// 结束时间
		Calendar localCalendarEnd = Calendar.getInstance();
		localCalendarStart.set(Calendar.DATE, localCalendarStart.getActualMaximum(Calendar.DAY_OF_MONTH));
		localCalendarEnd.set(Calendar.HOUR_OF_DAY, 23);
		localCalendarEnd.set(Calendar.MINUTE, 59);
		localCalendarEnd.set(Calendar.SECOND, 59);
		localCalendarEnd.set(Calendar.MILLISECOND, 999);
		Date endDate = localCalendarEnd.getTime();
		long endTime = endDate.getTime();
		TimeInfo localTimeInfo = new TimeInfo();

		// 设置时间段的起始时间
		localTimeInfo.setStartTime(startTime);
		localTimeInfo.setEndTime(endTime);
		return localTimeInfo;
	}

	/**
	 * 获取上月起始时间
	 * 
	 * @return
	 */
	public static TimeInfo getLastMonthStartAndEndTime()
	{
		// 开始时间
		Calendar localCalendarStart = Calendar.getInstance();
		localCalendarStart.add(Calendar.MONTH, -1);// 向前一月
		localCalendarStart.set(Calendar.DATE, 1);
		localCalendarStart.set(Calendar.HOUR_OF_DAY, 0);
		localCalendarStart.set(Calendar.MINUTE, 0);
		localCalendarStart.set(Calendar.SECOND, 0);
		localCalendarStart.set(Calendar.MILLISECOND, 0);
		Date startDate = localCalendarStart.getTime();
		long startTime = startDate.getTime();

		// 结束时间
		Calendar localCalendarEnd = Calendar.getInstance();
		localCalendarStart.add(Calendar.MONTH, -1);// 向前一月
		localCalendarStart.set(Calendar.DATE, localCalendarStart.getActualMaximum(Calendar.DAY_OF_MONTH));
		localCalendarEnd.set(Calendar.HOUR_OF_DAY, 23);
		localCalendarEnd.set(Calendar.MINUTE, 59);
		localCalendarEnd.set(Calendar.SECOND, 59);
		localCalendarEnd.set(Calendar.MILLISECOND, 999);
		Date endDate = localCalendarEnd.getTime();
		long endTime = endDate.getTime();
		TimeInfo localTimeInfo = new TimeInfo();

		// 设置时间段的起始时间
		localTimeInfo.setStartTime(startTime);
		localTimeInfo.setEndTime(endTime);
		return localTimeInfo;
	}

	/**
	 * 获取本年起始时间
	 * 
	 * @return
	 */
	public static TimeInfo getThisYearStartAndEndTime()
	{
		Calendar localCalendarStart = Calendar.getInstance();
		localCalendarStart.set(Calendar.MONTH, 0);
		localCalendarStart.set(Calendar.DATE, 1);
		localCalendarStart.set(Calendar.HOUR_OF_DAY, 0);
		localCalendarStart.set(Calendar.MINUTE, 0);
		localCalendarStart.set(Calendar.SECOND, 0);
		localCalendarStart.set(Calendar.MILLISECOND, 0);
		Date startDate = localCalendarStart.getTime();
		long startTime = startDate.getTime();
		Calendar localCalendarEnd = Calendar.getInstance();
		localCalendarEnd.set(Calendar.HOUR_OF_DAY, 23);
		localCalendarEnd.set(Calendar.MINUTE, 59);
		localCalendarEnd.set(Calendar.SECOND, 59);
		localCalendarEnd.set(Calendar.MILLISECOND, 999);
		Date endDate = localCalendarEnd.getTime();
		long endTime = endDate.getTime();
		TimeInfo localTimeInfo = new TimeInfo();
		localTimeInfo.setStartTime(startTime);
		localTimeInfo.setEndTime(endTime);
		return localTimeInfo;
	}

	/**
	 * 时间信息工具类
	 * 
	 * @author blj
	 * 
	 */
	static class TimeInfo
	{
		private long startTime;
		private long endTime;

		public long getStartTime()
		{
			return this.startTime;
		}

		public void setStartTime(long paramLong)
		{
			this.startTime = paramLong;
		}

		public long getEndTime()
		{
			return this.endTime;
		}

		public void setEndTime(long paramLong)
		{
			this.endTime = paramLong;
		}
	}

	/*
	 * Location: C:\Users\baobao561\Desktop\easemobchat_2.1.4.jar Qualified
	 * Name: com.easemob.util.TimeInfo JD-Core Version: 0.6.2
	 */

}
