package net.zjwu.mis.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtils {
    public static String dateToString(Date date){
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	return format.format(date);
    }
}
