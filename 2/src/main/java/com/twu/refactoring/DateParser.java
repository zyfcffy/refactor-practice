package com.twu.refactoring;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

public class DateParser {
    private final String dateAndTimeString;
    private static final HashMap<String, TimeZone> KNOWN_TIME_ZONES = new HashMap<String, TimeZone>();

    static {
        KNOWN_TIME_ZONES.put("UTC", TimeZone.getTimeZone("UTC"));
    }

    public DateParser(String dateAndTimeString) {
        this.dateAndTimeString = dateAndTimeString;
    }

    public Date parse() {
        int year, month, date, hour, minute;

        DateParserCondition yearCondition = new DateParserCondition(0, 4, "Year string is less than 4 characters", "Year is not an integer", 2000, 2012, "Year cannot be less than 2000 or more than 2012");
        year = getTime(yearCondition);

        DateParserCondition monthCondition = new DateParserCondition(5, 7, "Month string is less than 2 characters", "Month is not an integer", 1, 12, "Month cannot be less than 1 or more than 12");
        month = getTime(monthCondition);

        DateParserCondition dateCondition = new DateParserCondition(8, 10, "Date string is less than 2 characters", "Date is not an integer", 1, 31, "Date cannot be less than 1 or more than 31");
        date = getTime(dateCondition);

        if (dateAndTimeString.substring(11, 12).equals("Z")) {
            hour = 0;
            minute = 0;
        } else {
            DateParserCondition hourCondition = new DateParserCondition(11, 13, "Hour string is less than 2 characters", "Hour is not an integer", 0, 23, "Hour cannot be less than 0 or more than 23");
            hour = getTime(hourCondition);

            DateParserCondition minuteCondition = new DateParserCondition(14, 16, "Minute string is less than 2 characters", "Minute is not an integer", 0, 59, "Minute cannot be less than 0 or more than 59");
            minute = getTime(minuteCondition);

        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(year, month - 1, date, hour, minute, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    private int getTime(DateParserCondition dateParserCondition) {
        int time;
        try {
            String yearString = dateAndTimeString.substring(dateParserCondition.getStart(), dateParserCondition.getEnd());
            time = Integer.parseInt(yearString);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(dateParserCondition.getStringIndexOutOfBoundsException());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(dateParserCondition.getNumberFormatException());
        }
        if (time < dateParserCondition.getMin() || time > dateParserCondition.getMax())
            throw new IllegalArgumentException(dateParserCondition.getIllegalArgumentException());
        return time;
    }

}
