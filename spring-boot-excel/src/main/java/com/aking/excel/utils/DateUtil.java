package com.aking.excel.utils;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import com.aking.excel.utils.StringUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DateUtil {
    public static final String[] WEEKS = new String[]{"日", "一", "二", "三", "四", "五", "六"};
    private static final long MILLISECONDS_OF_DAY = 86400000L;
    private static final long MILLISECONDS_OF_MINUTE = 60000L;
    public static final String Format_1 = "yyyy-MM-dd HH:mm:ss";
    public static final String Format_2 = "yyyy-MM-dd";
    public static final String Format_3 = "HH:mm:ss";
    public static final String Format_4 = "yyyy-MM-dd HH:mm:ss,SSS";
    public static final String Format_5 = "yyyy年MM月dd日 HH:mm:ss";
    public static final String Format_6 = "yyyy年MM月dd日";
    public static final String Format_7 = "yyyyMMdd";
    public static final String Format_8 = "yyyyMMddHHmmss";
    public static final String Format_9 = "yyyy.MM.dd HH:mm:ss";
    public static final String Format_10 = "yyyy.MM.dd";
    public static final String Format_11 = "M.d";
    public static final String Format_12 = "M月d日";
    public static final String Format_13 = "yyyy/MM/dd";
    public static final String Format_14 = "HH:mm";
    public static final String Format_15 = "yyyy-MM-dd HH:mm";
    public static final String Format_16 = "yyyy/MM/dd HH:mm:ss";
    public static final String Format_17 = "yyyyMMddHHmmssSSS";
    public static final String Format_18 = "yyMMdd";
    public static final String Format_19 = "yyyyMMdd HH:mm:ss";
    public static final String DAY = "day";
    public static final String MINUTE = "minute";
    public static final String SECOND = "second";

    private DateUtil() {
    }

    public static String getIntegratedTimeFormat(String timeStr) {
        if (isTime(timeStr, "yyyy-MM-dd HH:mm:ss")) {
            return "yyyy-MM-dd HH:mm:ss";
        } else if (isTime(timeStr, "yyyy-MM-dd HH:mm:ss,SSS")) {
            return "yyyy-MM-dd HH:mm:ss,SSS";
        } else if (isTime(timeStr, "yyyy年MM月dd日 HH:mm:ss")) {
            return "yyyy年MM月dd日 HH:mm:ss";
        } else if (isTime(timeStr, "yyyyMMddHHmmss")) {
            return "yyyyMMddHHmmss";
        } else if (isTime(timeStr, "yyyy.MM.dd HH:mm:ss")) {
            return "yyyy.MM.dd HH:mm:ss";
        } else if (isTime(timeStr, "yyyy/MM/dd HH:mm:ss")) {
            return "yyyy/MM/dd HH:mm:ss";
        } else {
            return isTime(timeStr, "yyyyMMddHHmmssSSS") ? "yyyyMMddHHmmssSSS" : null;
        }
    }

    public static Date getIntegratedTimeDate(String timeStr) {
        Date time = null;
        if (null != (time = stringToDate(timeStr, "yyyy-MM-dd HH:mm:ss"))) {
            return time;
        } else if (null != (time = stringToDate(timeStr, "yyyy-MM-dd HH:mm:ss,SSS"))) {
            return time;
        } else if (null != (time = stringToDate(timeStr, "yyyy年MM月dd日 HH:mm:ss"))) {
            return time;
        } else if (null != (time = stringToDate(timeStr, "yyyyMMddHHmmss"))) {
            return time;
        } else if (null != (time = stringToDate(timeStr, "yyyy.MM.dd HH:mm:ss"))) {
            return time;
        } else if (null != (time = stringToDate(timeStr, "yyyy/MM/dd HH:mm:ss"))) {
            return time;
        } else {
            return null != (time = stringToDate(timeStr, "yyyyMMddHHmmssSSS")) ? time : null;
        }
    }

    public static boolean isTime(String timeStr, String format) {
        if (null == format) {
            return false;
        } else {
            SimpleDateFormat form = new SimpleDateFormat(format);

            try {
                form.parse(timeStr);
                return true;
            } catch (ParseException var4) {
                return false;
            }
        }
    }

    public static int getIntervalDays(Date oDate) {
        if (null == oDate) {
            return -1;
        } else {
            Date currentDate = new Date();
            if (currentDate.before(oDate)) {
                long intervalMilli = oDate.getTime() - currentDate.getTime();
                return (int)(intervalMilli / 86400000L);
            } else {
                return -1;
            }
        }
    }

    public static boolean isLesserAndEqualsDay(Date day1, Date day2) throws Exception {
        if (null != day1 && null != day2) {
            Date startTimeForDay1 = getStartTimeForDay(day1);
            Date startTimeForDay2 = getStartTimeForDay(day2);
            return startTimeForDay1.getTime() <= startTimeForDay2.getTime();
        } else {
            throw new Exception("[DateUtil.isLargeDay]: day1 is null  or  day2 is null, day1=" + day1 + " ,  day2=" + day2);
        }
    }

    public static boolean isLargeDay(Date day1, Date day2) throws Exception {
        if (null != day1 && null != day2) {
            Date startTimeForDay1 = getStartTimeForDay(day1);
            Date startTimeForDay2 = getStartTimeForDay(day2);
            return startTimeForDay1.getTime() > startTimeForDay2.getTime();
        } else {
            throw new Exception("[DateUtil.isLargeDay]: day1 is null  or  day2 is null, day1=" + day1 + " ,  day2=" + day2);
        }
    }

    public static boolean isLargeAndEqualsDay(Date day1, Date day2) throws Exception {
        if (null != day1 && null != day2) {
            Date startTimeForDay1 = getStartTimeForDay(day1);
            Date startTimeForDay2 = getStartTimeForDay(day2);
            return startTimeForDay1.getTime() >= startTimeForDay2.getTime();
        } else {
            throw new Exception("[DateUtil.isLargeDay]: day1 is null  or  day2 is null, day1=" + day1 + " ,  day2=" + day2);
        }
    }

    public static boolean isInDay(Date baseDay, Date time) throws Exception {
        if (null != baseDay && null != time) {
            Date startTime = getStartTimeForDay(baseDay);
            Date endTime = getEndTimeForDay(baseDay);
            return startTime.getTime() <= time.getTime() && endTime.getTime() >= time.getTime();
        } else {
            return false;
        }
    }

    public static boolean isINRestTime(Date baseDay, Date time) throws Exception {
        if (null != baseDay && null != time) {
            Date startTime = getStartTimeForRest(baseDay);
            Date endTime = getEndTimeForRest(baseDay);
            return startTime.getTime() <= time.getTime() && endTime.getTime() >= time.getTime();
        } else {
            return false;
        }
    }

    public static boolean equalsDay(Date day1, Date day2) {
        return null != day1 && null != day2 ? dateToString(day1, "yyyyMMdd").equals(dateToString(day2, "yyyyMMdd")) : false;
    }

    public static String getNowDateTimeStr() {
        return dateToString(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    public static String getNowDateTimeStr(String format) {
        return dateToString(new Date(), format);
    }

    public static String getNowDateStr() {
        return dateToString(new Date(), "yyyy-MM-dd");
    }

    public static String getNowTimeStr() {
        return dateToString(new Date(), "HH:mm:ss");
    }

    public static String dateToString(Date date, String format) {
        if (null == date) {
            return null;
        } else {
            if (null == format) {
                format = "yyyy-MM-dd HH:mm:ss";
            }

            SimpleDateFormat form = new SimpleDateFormat(format);
            return form.format(date);
        }
    }

    public static Date stringToDate(String dateString, String format) {
        if (StringUtil.isEmpty(dateString)) {
            return null;
        } else {
            SimpleDateFormat form = new SimpleDateFormat(null == format ? "yyyy-MM-dd" : format);
            Date date = null;

            try {
                date = form.parse(dateString);
            } catch (ParseException var5) {
                var5.printStackTrace();
            }

            return date;
        }
    }

    public static Integer getMaxDayInMonth(Integer year, Integer month) {
        if (null == month || 2 == month && null == year) {
            return null;
        } else if (1 != month && 3 != month && 5 != month && 7 != month && 8 != month && 10 != month && 12 != month) {
            if (4 != month && 6 != month && 9 != month && 11 != month) {
                if (2 != month) {
                    return null;
                } else {
                    return year % 400 != 0 && (year % 4 != 0 || year % 100 == 0) ? 28 : 29;
                }
            } else {
                return 30;
            }
        } else {
            return 31;
        }
    }

    public static List<String> sortListDesc(Set<String> set) {
        List<String> retStr = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map<Long, String> map = new TreeMap();
        Iterator var4 = set.iterator();

        while(var4.hasNext()) {
            String value = (String)var4.next();

            try {
                map.put(sdf.parse(value).getTime(), value);
            } catch (ParseException var7) {
                var7.printStackTrace();
            }
        }

        Collection<String> coll = map.values();
        retStr.addAll(coll);
        Collections.reverse(retStr);
        return retStr;
    }

    public static List<String> sortListDesc1(Set<String> set) {
        List<String> retStr = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Map<Long, String> map = new TreeMap();
        Iterator var4 = set.iterator();

        while(var4.hasNext()) {
            String value = (String)var4.next();

            try {
                map.put(sdf.parse(value).getTime(), value);
            } catch (ParseException var7) {
                var7.printStackTrace();
            }
        }

        Collection<String> coll = map.values();
        retStr.addAll(coll);
        Collections.reverse(retStr);
        return retStr;
    }

    public static int getNowDayInWeek() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return calendar.get(7);
    }

    public static int getDayInWeek(Date time) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        return calendar.get(7);
    }

    public static boolean isCommonWorkDay(Date time) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        int day = calendar.get(7);
        return 2 <= day && day <= 6;
    }

    public static Date getStartTimeForDay(Date date) throws Exception {
        if (null == date) {
            return null;
        } else {
            SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
            String timeStr = form.format(date);
            timeStr = timeStr + " 00:00:00";
            form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            try {
                return form.parse(timeStr);
            } catch (ParseException var4) {
                throw new RuntimeException(var4);
            }
        }
    }

    public static Date getMiddleTimeForDay(Date date) throws Exception {
        if (null == date) {
            return null;
        } else {
            SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
            String timeStr = form.format(date);
            timeStr = timeStr + " 12:00:00";
            form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            try {
                return form.parse(timeStr);
            } catch (ParseException var4) {
                throw new RuntimeException(var4);
            }
        }
    }

    public static Date getStartTimeForRest(Date date) throws Exception {
        if (null == date) {
            return null;
        } else {
            SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
            String timeStr = form.format(date);
            timeStr = timeStr + " 21:00:00";
            form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            try {
                return form.parse(timeStr);
            } catch (ParseException var4) {
                throw new RuntimeException(var4);
            }
        }
    }

    public static String formatDate(Date date) throws Exception {
        if (null == date) {
            return null;
        } else {
            SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timeStr = form.format(date);
            return timeStr;
        }
    }

    public static Date getAssignTimeForDay(Date day, String assignTime) throws Exception {
        if (null == day) {
            return null;
        } else {
            SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
            String timeStr = form.format(day);
            timeStr = timeStr + " ";
            timeStr = timeStr + assignTime;
            form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            try {
                return form.parse(timeStr);
            } catch (ParseException var5) {
                throw new RuntimeException(var5);
            }
        }
    }

    public static Date replaceTimeIntoDay(Date date, String timeForDate) throws Exception {
        if (null == date) {
            return null;
        } else {
            timeForDate = StringUtil.trim(timeForDate);
            if (StringUtil.isEmpty(timeForDate)) {
                return date;
            } else {
                SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
                String timeStr = form.format(date);
                timeStr = timeStr + " ";
                timeStr = timeStr + timeForDate;
                form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                try {
                    return form.parse(timeStr);
                } catch (ParseException var5) {
                    throw new RuntimeException(var5);
                }
            }
        }
    }

    public static Date getEndTimeForDay(Date date) {
        if (null == date) {
            return null;
        } else {
            SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
            String timeStr = form.format(date);
            timeStr = timeStr + " 23:59:59";
            form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            try {
                return form.parse(timeStr);
            } catch (ParseException var4) {
                throw new RuntimeException(var4);
            }
        }
    }

    public static Date getEndTimeForRest(Date date) throws Exception {
        if (null == date) {
            return null;
        } else {
            SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
            String timeStr = form.format(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(form.parse(timeStr));
            cal.add(6, 1);
            String nextDate = form.format(cal.getTime());
            nextDate = nextDate + " 08:00:00";
            form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            try {
                return form.parse(nextDate);
            } catch (ParseException var6) {
                throw new RuntimeException(var6);
            }
        }
    }

    public static Date getNextDay(Date date) throws Exception {
        if (null == date) {
            return null;
        } else {
            long nextTimeL = date.getTime() + 86400000L;
            return new Date(nextTimeL);
        }
    }

    public static Date getPreDay(Date date) throws Exception {
        if (null == date) {
            return null;
        } else {
            long nextTimeL = date.getTime() - 86400000L;
            return new Date(nextTimeL);
        }
    }

    public static Date getPreDays(Date date, int days) throws Exception {
        if (null == date) {
            return null;
        } else if (days <= 0) {
            return date;
        } else {
            long nextTimeL = date.getTime() - (long)(86400000 * days);
            return new Date(nextTimeL);
        }
    }

    public static LocalDate toLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static String getWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return WEEKS[calendar.get(7) - 1];
    }

    public static float offsetHours(Date startTime, Date endTime) {
        long diff = endTime.getTime() - startTime.getTime();
        if (diff < 0L) {
            return 0.0F;
        } else {
            long min = diff / 60000L;
            float resHour = 0.0F;
            if (min >= 0L && min <= 59L) {
                resHour = 0.5F;
            } else if (min % 60L < 30L) {
                resHour = (float)(min / 60L);
            } else if (min % 60L >= 30L) {
                resHour = (float)(min / 60L) + 0.5F;
            }

            return resHour;
        }
    }

    public static String getTimeByMinute(int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(12, minute);
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(calendar.getTime());
    }

    public static int daysBetween(Date smdate, Date bdate) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / 86400000L;
        return Integer.parseInt(String.valueOf(between_days));
    }

    public static String getSlangTime(Date curTime, Date targetTime, boolean todayIsEmpty) throws Exception {
        if (null != curTime && null != targetTime) {
            String dayStr = null;
            int days;
            if (getMiddleTimeForDay(curTime).getTime() <= getMiddleTimeForDay(targetTime).getTime()) {
                days = daysBetween(curTime, targetTime);
                if (0 == days) {
                    dayStr = todayIsEmpty ? "" : "今天 ";
                    return dayStr + dateToString(targetTime, "HH:mm");
                }

                if (1 == days) {
                    dayStr = "明天";
                } else {
                    dayStr = dateToString(targetTime, "yyyy-MM-dd HH:mm");
                }
            } else {
                days = daysBetween(targetTime, curTime);
                if (1 == days) {
                    dayStr = "昨天";
                } else {
                    dayStr = dateToString(targetTime, "yyyy-MM-dd HH:mm");
                }
            }

            return dayStr;
        } else {
            throw new Exception("curTime is null or targetTime is null.");
        }
    }

    public static String getSlangTime2(Date curTime, Date targetTime, boolean todayIsEmpty) throws Exception {
        if (null != curTime && null != targetTime) {
            String dayStr = null;
            int days;
            if (getMiddleTimeForDay(curTime).getTime() <= getMiddleTimeForDay(targetTime).getTime()) {
                days = daysBetween(curTime, targetTime);
                if (0 == days) {
                    dayStr = todayIsEmpty ? "" : "今天 ";
                    return dayStr + dateToString(targetTime, "HH:mm");
                }

                if (1 == days) {
                    dayStr = "明天";
                } else {
                    dayStr = dateToString(targetTime, "yyyy-MM-dd");
                }
            } else {
                days = daysBetween(targetTime, curTime);
                if (1 == days) {
                    dayStr = "昨天";
                } else {
                    dayStr = dateToString(targetTime, "yyyy-MM-dd");
                }
            }

            return dayStr;
        } else {
            throw new Exception("curTime is null or targetTime is null.");
        }
    }

    public static Date getWeekBegin(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(2);
        calendar.set(7, 2);
        return getDayBegin(calendar);
    }

    public static Date getWeekEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(2);
        calendar.set(7, 1);
        return getEndTimeForDay(calendar.getTime());
    }

    public static Date getDayBegin(Date date) {
        Calendar calendarBefore = Calendar.getInstance();
        calendarBefore.setTime(date);
        return getDayBegin(calendarBefore);
    }

    public static Date getDayEnd(Date date) {
        Calendar calendarBefore = Calendar.getInstance();
        calendarBefore.setTime(date);
        return getDayEnd(calendarBefore);
    }

    public static Date addDay(Date date, int days) {
        return date == null ? null : new Date(date.getTime() + 86400000L * (long)days);
    }

    public static Date addDayByTimeType(Date date, String timeType, Long interval) {
        if (date == null) {
            return null;
        } else if ("day".equals(timeType)) {
            return addDay(date, interval.intValue());
        } else if ("minute".equals(timeType)) {
            return new Date(date.getTime() + 60000L * interval);
        } else {
            return "second".equals(timeType) ? new Date(date.getTime() + 1000L * interval) : null;
        }
    }

    public static Date reduceDay(Date date, int days) {
        return date == null ? null : new Date(date.getTime() - 86400000L * (long)days);
    }

    public static Date reduceDayByTimeType(Date date, String timeType, Long interval) {
        if (date == null) {
            return null;
        } else if ("day".equals(timeType)) {
            return reduceDay(date, interval.intValue());
        } else if ("minute".equals(timeType)) {
            return new Date(date.getTime() - 60000L * interval);
        } else {
            return "second".equals(timeType) ? new Date(date.getTime() - 1000L * interval) : null;
        }
    }

    public static Date getDayBegin(Calendar calendarBefore) {
        Calendar calendarAfter = Calendar.getInstance();
        calendarAfter.set(calendarBefore.get(1), calendarBefore.get(2), calendarBefore.get(5));
        calendarAfter.set(11, 0);
        calendarAfter.set(12, 0);
        calendarAfter.set(13, 0);
        calendarAfter.set(14, 0);
        return calendarAfter.getTime();
    }

    public static Date getDayEnd(Calendar calendarBefore) {
        Calendar calendarAfter = Calendar.getInstance();
        calendarAfter.set(calendarBefore.get(1), calendarBefore.get(2), calendarBefore.get(5));
        calendarAfter.set(11, 23);
        calendarAfter.set(12, 59);
        calendarAfter.set(13, 59);
        calendarAfter.set(14, 999);
        return calendarAfter.getTime();
    }

    public static int compare(Date date, Date anotherDate) {
        if (date == null && anotherDate == null) {
            return 0;
        } else if (anotherDate == null) {
            return 1;
        } else {
            return date == null ? -1 : date.compareTo(anotherDate);
        }
    }

    public static boolean isTimeYMDHMS(String time) throws Exception {
        if (StringUtil.isEmpty(time)) {
            throw new Exception("[DateUtil.isTimeYMDHMS]:time is null.");
        } else {
            String regex = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}";
            return time.trim().matches(regex);
        }
    }

    public static boolean isTimeYMD(String time) throws Exception {
        if (StringUtil.isEmpty(time)) {
            throw new Exception("[DateUtil.isTimeYMD]:time is null.");
        } else {
            String regex = "\\d{4}-\\d{2}-\\d{2}";
            return time.trim().matches(regex);
        }
    }

    public static Date getMonthBegin(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int firstDay = calendar.getActualMinimum(5);
        calendar.set(5, firstDay);
        return getDayBegin(calendar);
    }

    public static Date getMonthEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int lastDay = calendar.getActualMaximum(5);
        calendar.set(5, lastDay);
        return getEndTimeForDay(calendar.getTime());
    }

    public static Date getStartTimeForMonth(Date date) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int firstDay = calendar.getActualMinimum(5);
        calendar.set(5, firstDay);
        return getStartTimeForDay(calendar.getTime());
    }

    public static Date getEndTimeForMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int lastDay = calendar.getActualMaximum(5);
        calendar.set(5, lastDay);
        return getEndTimeForDay(calendar.getTime());
    }

    public static Date getStartTimeForYear(Date date) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int firstDay = calendar.getActualMinimum(6);
        calendar.set(6, firstDay);
        return getStartTimeForDay(calendar.getTime());
    }

    public static Date getEndTimeForYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int lastDay = calendar.getActualMaximum(6);
        calendar.set(6, lastDay);
        return getEndTimeForDay(calendar.getTime());
    }

    public static void main(String[] args) throws Exception {
        Date d1 = stringToDate("2017-10-17 23:59:59", "yyyy-MM-dd HH:mm:ss");
        Date d2 = stringToDate("2017-10-10 00:00:00", "yyyy-MM-dd HH:mm:ss");
        System.out.println(daysBetween(d1, d2));
        System.out.println("==================");
        String timeStr = "2017年10月17日 23:59:59";
        System.out.println(isTime(timeStr, "yyyy-MM-dd HH:mm:ss"));
        System.out.println(getIntegratedTimeFormat(timeStr));
        System.out.println("==================");
        System.out.println("getStartTimeForMonth=" + getStartTimeForMonth(new Date()));
        System.out.println("getStartTimeForMonth=" + getEndTimeForMonth(new Date()));
        System.out.println("getStartTimeForMonth=" + getStartTimeForYear(new Date()));
        System.out.println("getStartTimeForMonth=" + getEndTimeForYear(new Date()));
        Date date = new Date();
        System.out.println(addDayByTimeType(date, "day", 1L));
        System.out.println(addDay(date, 1));
        System.out.println(addDayByTimeType(date, "minute", 60L));
        System.out.println(addDayByTimeType(date, "second", 60L));
        System.out.println(reduceDay(date, 1));
        System.out.println(reduceDayByTimeType(date, "day", 1L));
        System.out.println(reduceDayByTimeType(date, "minute", 60L));
        System.out.println(reduceDayByTimeType(date, "second", 60L));
        System.out.println(dateToString(stringToDate("20190911 09:51:41", "yyyyMMdd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss"));
    }
}
