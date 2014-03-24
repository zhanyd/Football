package com.wildwolf.helper;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;


public class DataHelper {
	//生成主键
	public static String CreateID()
	{
		UUID uuid = UUID.randomUUID();
        String pk = uuid.toString();
        return pk;
	}
	
	 
	//设置时间为当天最晚时间
	public static Date GetLastTime(Date inDate)
	{
		if (inDate == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(inDate);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE,59);
		c.set(Calendar.SECOND, 59);
		
		return c.getTime();
	}
}
