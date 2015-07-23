package com.kyss;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Mathieu SAUVAGE
 */
public class DateHelper {

    public static Date longToDate(final long dateValue) {
        Calendar lCalendar = Calendar.getInstance();
        lCalendar.setTimeInMillis(dateValue);
        return lCalendar.getTime();
    }
}
