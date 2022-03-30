package cn.springboot.util;

import org.apache.commons.lang3.StringUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 胡桃夹子
 * @Description 时间与日期的工具类
 * @date Mar 16, 2017 5:20:10 PM
 */
public class DateUtil {

    /**
     * yyyyMMddHHmmssSSS
     */
    public static final String fm_yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";

    /**
     * yyyy-MM-dd HH:mm:ss.SSS
     */
    public static final String fm_yyyy_MM_dd_HHmmssSSS = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * yyyyMMddHHmmss
     */
    public static final String fm_yyyyMMddHHmmss = "yyyyMMddHHmmss";

    /**
     * yyyyMMddHHmm
     */
    public static final String fm_yyyyMMddHHmm = "yyyyMMddHHmm";

    /**
     * yyyyMMddHHmmss
     */
    public static final String fm_yyyyMMddHH = "yyyyMMddHH";

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String fm_yyyy_MM_dd_HHmmss = "yyyy-MM-dd HH:mm:ss";

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String HHmm = "HH:mm";

    /**
     * yyyyMMdd
     */
    public static final String fm_yyyyMMdd = "yyyyMMdd";

    /**
     * yyyyMM
     */
    public static final String fm_yyyyMM = "yyyyMM";

    /**
     * yyMM
     */
    public static final String fm_yyMM = "yyMM";

    /**
     * yyyy-MM-dd
     */
    public static final String fm_yyyy_MM_dd = "yyyy-MM-dd";

    /**
     * yyyy/MM/dd
     */
    public static final String fmx_yyyy_MM_dd = "yyyy/MM/dd";

    /**
     * yyyy-MM.dd
     */
    public static final String fmp_yyyy_MM_dd = "yyyy-MM.dd";

    /**
     * yyyy
     */
    public static final String fm_yyyy = "yyyy";

    /**
     * MM.dd
     */
    public static final String fm_MM_dd = "MM-dd";

    /**
     * yyyy年MM月dd日
     */
    public static final String cn_yyyyMMdd = "yyyy年MM月dd日";

    /**
     * M月dd日
     */
    public static final String cn_MMdd = "MM月dd日";

    /**
     * yyyy-MM-dd HH:mm
     */
    public static final String yyyy_MM_dd_HH_mm = "yyyy-MM-dd HH:mm";

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String fm_HHmmss = "HH点mm分ss秒";

    /**
     * 锁对象
     */
    private static final Object LOCK_OBJ = new Object();

    /**
     * 存放不同的日期模板格式的sdf的Map
     */
    private static final Map<String, ThreadLocal<DateTimeFormatter>> formatterMap = new HashMap<>();


    public static final int MONTH_DAY_NUM = 30;

    public static final int YEAR_DAY_NUM = 360;

    /**
     * 返回一个ThreadLocal的sdf,每个线程只会new一次sdf
     *
     * @param pattern 表达式
     * @return DateTimeFormatter
     */
    private static DateTimeFormatter getDateFormat(final String pattern) {
        ThreadLocal<DateTimeFormatter> local = formatterMap.get(pattern);

        // 此处的双重判断和同步是为了防止sdfMap这个单例被多次put重复的sdf
        if (local == null) {
            synchronized (LOCK_OBJ) {
                local = formatterMap.get(pattern);
                if (local == null) {
                    // 只有Map中还没有这个pattern的sdf才会生成新的sdf并放入map
                    // 这里是关键,使用ThreadLocal<DateTimeFormatter>替代原来直接DateTimeFormatter.ofPattern()
                    local = ThreadLocal.withInitial(() -> DateTimeFormatter.ofPattern(pattern));
                    formatterMap.put(pattern, local);
                }
            }
        }
        return local.get();
    }

    /**
     * 将java.utils.Date 转换为java8 的java.time.LocalDateTime,默认时区为东8区
     *
     * @param date Date
     * @return LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(Date date) {
        return date.toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime();
    }

    /**
     * 将java8 的 java.time.LocalDateTime 转换为 java.utils.Date，默认时区为东8区
     *
     * @param localDateTime LocalDateTime
     * @return Date
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.toInstant(ZoneOffset.of("+8")));
    }

    /**
     * 将java8 的 java.time.LocalDate 转换为 java.utils.Date
     *
     * @param localDate LocalDate
     * @return Date
     */
    public static Date localDateToDate(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 去除时分秒，返回只保留年月日的日期
     *
     * @param date 待处理日期
     * @return 只保留年月日的日期
     */
    public static Date parse(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 字符串转成日期
     *
     * @param dateString 日期字符串
     * @param pattern    format格式
     * @return
     */
    public static Date stringToDate(String dateString, String pattern) {
        if (StringUtils.isBlank(dateString)) {
            return null;
        }
        if (StringUtils.isBlank(pattern)) {
            pattern = fm_yyyyMMdd;
        }
        LocalDate localDate = LocalDate.parse(dateString, getDateFormat(pattern));
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 当前时间转字符串
     *
     * @param pattern 格式(DateTimeUtil.fmx_yyyy_MM_dd ...)
     * @return 日期字符
     */
    public static String dateToString(String pattern) {
        Date cur = Calendar.getInstance().getTime();
        if (StringUtils.isBlank(pattern)) {
            pattern = fm_yyyy_MM_dd_HHmmss;
        }
        return dateToString(cur, pattern);
    }

    /**
     * 日期转字符串
     *
     * @param date    日期
     * @param pattern 格式(DateTimeUtil.fmx_yyyy_MM_dd ...)
     * @return 日期字符
     */
    public static String dateToString(Date date, String pattern) {
        if (date == null) {
            date = Calendar.getInstance().getTime();
        }
        if (StringUtils.isBlank(pattern)) {
            pattern = fm_yyyy_MM_dd_HHmmss;
        }

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime ldt = DateUtil.toLocalDateTime(date);
        return ldt.format(dateFormat);
    }

    /**
     * 日期转字符串
     *
     * @param milliseconds 日期
     * @param pattern      格式(DateTimeUtil.fmx_yyyy_MM_dd ...)
     * @return 日期字符
     */
    public static String dateToString(Long milliseconds, String pattern) {
        if (milliseconds == null) {
            milliseconds = Calendar.getInstance().getTime().getTime();
        }
        if (StringUtils.isBlank(pattern)) {
            pattern = fm_yyyy_MM_dd_HHmmss;
        }
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime ldt = LocalDateTime.ofEpochSecond(milliseconds, 0, ZoneOffset.ofHours(8));
        return ldt.format(dateFormat);
    }

    /**
     * 得到前面某一天的日期
     *
     * @param date 当前日期
     * @param day  前天多少天
     * @return 前面某一天的日期
     */
    public static Date getBeginDate(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, -day);
        return c.getTime();
    }

    /**
     * 得到后面某一天的日期
     *
     * @param date 当前日期
     * @param day  后面多少天
     * @return 后面某一天的日期
     */
    public static Date getAfterDate(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, day);
        return c.getTime();
    }

    /**
     * 得到前一天的日期
     *
     * @param date 当前日期
     * @return 前一天日期（昨天）
     */
    public static Date getYesterday(Date date) {
        return getBeginDate(date, 1);
    }

    /**
     * 得到明天的日期
     *
     * @param date 当前日期
     * @return 明天日期
     */
    public static Date getTomorrow(Date date) {
        return getAfterDate(date, 1);
    }

    /**
     * 根据某日期得到当月第一天日期
     *
     * @param date 日期
     * @return 当月第一天
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }

    /**
     * 根据某日期得到当年第一天日期
     *
     * @param date 日期
     * @return 当年第一天
     */
    public static Date getFirstDayOfYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR, 0);
        c.set(Calendar.DAY_OF_YEAR, 1);
        return c.getTime();
    }

    /**
     * 根据某日期得到上月第一天日期
     *
     * @param date 日期
     * @return 上月第一天
     */
    public static Date getFirstDayOfLastMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }

    /**
     * 根据某日期得到当周第一天日期
     *
     * @param date 日期
     * @return 当周第一天(星期一)
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar cd = Calendar.getInstance();
        // 中国周一为一周内的第一天
        cd.setFirstDayOfWeek(Calendar.MONDAY);
        cd.setTime(date);
        cd.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cd.getTime();
    }

    /**
     * 获取某日期上周第一天日期
     *
     * @param date 日期
     * @return 上周第一天日期（周一）
     */
    public static Date getFirstDayOfLastWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        // 中国周一为一周内的第一天
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return calendar.getTime();
    }

    /**
     * 根据某日期得到上月最后一天日期
     *
     * @param date 日期
     * @return 上月最后一天
     */
    public static Date getLastDayOfLastMonth(Date date) {
        Calendar a = Calendar.getInstance();
        a.setTime(date);
        // 把日期设置为上个月同一天
        a.add(Calendar.MONTH, -1);
        //把日期设置为该月第一天
        a.set(Calendar.DATE, 1);
        //日期回滚一天，也就是最后一天
        a.roll(Calendar.DATE, -1);
        return a.getTime();
    }

    /**
     * 根据某日期得到月最后一天日期
     *
     * @param date 日期
     * @return 月最后一天
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar a = Calendar.getInstance();
        a.setTime(date);
        //把日期设置为该月第一天
        a.set(Calendar.DATE, 1);
        //日期回滚一天，也就是最后一天
        a.roll(Calendar.DATE, -1);
        return a.getTime();
    }


    /**
     * 获取某日期上周最后一天日期
     *
     * @param date 日期
     * @return 上周最后一天日期（周日）
     */
    public static Date getLastDayOfLastWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        // 中国周一为一周内的第一天
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return calendar.getTime();
    }

    /**
     * 根据某日期得到上周同一天日期
     *
     * @param date 日期
     * @return 上周同一天
     */
    public static Date getCurDayOfLastWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.WEEK_OF_YEAR, -1);
        return c.getTime();
    }

    /**
     * 根据某日期得到两周前的同一天日期
     *
     * @param date 日期
     * @return 两周前的同一天
     */
    public static Date getCurDayOflastTwoWeek(Date date) {
        return getCurDayOfLastWeek(getCurDayOfLastWeek(date));
    }

    /**
     * 根据某日期得到上个月同一天日期
     *
     * @param date 日期
     * @return 上个月同一天
     */
    public static Date getCurDayOfLastMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -1);
        return c.getTime();
    }

    /**
     * 根据某日期得到上两个月同一天日期
     *
     * @param date 日期
     * @return 上两个月同一天
     */
    public static Date curDayOfLastTwoMonth(Date date) {
        return getCurDayOfLastMonth(getCurDayOfLastMonth(date));
    }

    /**
     * 根据某日期得到去年同一天
     *
     * @param date 日期
     * @return 去年同一天对应的日期
     */
    public static Date getCurDayOfLastYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, -1);
        return cal.getTime();
    }

    /**
     * 根据某日期得到明年同一天
     *
     * @param date 日期
     * @return 去年同一天对应的日期
     */
    public static Date getCurDayOfAfterYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, 1);
        return cal.getTime();
    }

    /**
     * 根据某日期得到上一年同一天对应的周一日期
     *
     * @param date 日期
     * @return 上一年同一天对应的周一日期
     */
    public static Date getFirstDayOfWeekByLastYear(Date date) {
        return getFirstDayOfWeek(getCurDayOfLastYear(date));
    }

    /**
     * 判断某日期是不是周一
     *
     * @param date 当前日期
     * @return true为周一，默认false
     */
    public static boolean getCurDateIsMonday(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        return cd.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY;
    }

    /**
     * 根据某日期得到年份
     *
     * @param date 日期
     * @return 年份
     */
    public static int getOfYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR);
    }

    /**
     * 根据某日期得到月份
     *
     * @param date 日期
     * @return 月份
     */
    public static int getOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        // 月份下标从0开始
        return c.get(Calendar.MONTH) + 1;
    }

    /**
     * 根据某日期得到日期是当月的哪一号（哪一天）
     *
     * @param date 日期
     * @return 当月第几天
     */
    public static int getDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 根据某日期得到星期
     *
     * @param date 日期
     * @return 星期几(1, 2, 3, 4, 5, 6, 7)
     */
    public static int getDayOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.setFirstDayOfWeek(Calendar.MONDAY);
        return c.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 自定义创建一个日期
     *
     * @param year  年
     * @param month 月
     * @param day   日
     * @return 日期
     */
    public static Date getCustomDate(int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DATE, day);
        return c.getTime();
    }


    /**
     * 根据开始时间、结束时间得到两个时间段内所有的日期(包含开始日期与结束日期)
     *
     * @param start 开始日期
     * @param end   结束日期
     * @return 两个日期之间的日期
     */
    public static List<Date> getDateRangeList(Date start, Date end) {
        ArrayList<Date> ret = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        Date tmpDate = calendar.getTime();
        long endTime = end.getTime();
        while (tmpDate.before(end) || tmpDate.getTime() == endTime) {
            ret.add(parse(calendar.getTime()));
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            tmpDate = calendar.getTime();
        }
        return ret;
    }

    /**
     * 根据开始时间、结束时间得到两个时间段内所有的日期(包含开始日期与结束日期)
     *
     * @param start 开始日期
     * @param end   结束日期
     * @return 两个日期之间的天数
     */
    public static int getDateRangeNum(Date start, Date end) {
        ArrayList<Date> ret = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        Date tmpDate = calendar.getTime();
        long endTime = end.getTime();
        while (tmpDate.before(end) || tmpDate.getTime() == endTime) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            ret.add(parse(calendar.getTime()));
            tmpDate = calendar.getTime();
        }
        return ret.size();
    }

    /**
     * 判断是不是在时间区间内：
     *
     * @param date 要判断的时间
     * @param from 开始时间
     * @param to   结束时间
     * @return true=[from <= cur < to]，false=反之则返回false
     */
    public static boolean isBetween(Date date, Date from, Date to) {
        if (null == date || null == from || null == to) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        Calendar c = Calendar.getInstance();
        c.setTime(from);

        int result = calendar.compareTo(c);
        if (result > 0) {
            // 大于开始时间
            c.setTime(to);
            result = calendar.compareTo(c);
            return result < 0;
        }
        return false;
    }

    /**
     * 判断是不是在时间区间内：
     *
     * @param date 要判断的时间
     * @param from 开始时间(含)
     * @param to   结束时间(含)
     * @return true=[from <= cur <= to]，false=反之则返回false
     */
    public static boolean hasIncludeTime(Date date, Date from, Date to) {
        if (null == date || null == from || null == to) {
            return false;
        }
        // 如果大于的话返回的是正整数，等于是0，小于的话就是负整数

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        Calendar c = Calendar.getInstance();
        c.setTime(from);

        int result = calendar.compareTo(c);
        if (result >= 0) {
            // 大于开始时间
            c.setTime(to);
            result = calendar.compareTo(c);
            return result <= 0;
        }
        return false;
    }

    /**
     * 前面某一天的日期的开始时间
     *
     * @return 日期
     */
    public static Date getDayBegin(Date cur) {
        Calendar c = Calendar.getInstance();
        c.setTime(cur);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 获得某一天的日期的结束时间
     *
     * @return 日期
     */
    public static Date getDayEnd(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }


    /**
     * 为日期增加分钟
     *
     * @param date   日期
     * @param amount 分钟
     * @return 日期
     */
    public static Date addMinute(Date date, int amount) {
        Calendar cld = Calendar.getInstance();
        if (date == null) {
            date = cld.getTime();
        }
        cld.setTime(date);
        cld.add(Calendar.MINUTE, amount);
        return cld.getTime();
    }
}
