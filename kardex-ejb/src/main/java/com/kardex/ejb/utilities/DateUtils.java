/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.utilities;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;

/**
 *
 * @author ADMIN
 */
public class DateUtils {

    public static boolean DEFAULT_LENIENT = false;
    public static int DEFAULT_CLEAN_FIELD = 11;
    public static Locale DEFAULT_LOCALE = Locale.getDefault();
    public static int DEFAULT_MAXIMUM_FIELD = 11;
    public static TimeZone DEFAULT_TIME_ZONE = TimeZone.getDefault();

    public static Calendar getCalendar() {
        return getCalendar((Calendar) null);
    }

    public static Calendar getCalendar(boolean ab_lenient) {
        return getCalendar((Calendar) null, ab_lenient);
    }

    public static Calendar getCalendar(Calendar ac_c) {
        return getCalendar(ac_c, DEFAULT_LENIENT);
    }

    public static Calendar getCalendar(Calendar ac_c, boolean ab_lenient) {
        Calendar lc_c = ac_c != null ? (Calendar) ac_c.clone() : new GregorianCalendar(DEFAULT_TIME_ZONE, DEFAULT_LOCALE);

        lc_c.setLenient(ab_lenient);

        return lc_c;
    }

    public static Calendar getCalendar(Calendar ac_c, int ai_field, int ai_amount, boolean ab_before) {
        Calendar lc_c = getCalendar(ac_c);

        lc_c.add(ai_field, ab_before ? ai_amount * -1 : ai_amount);

        return lc_c;
    }

    public static Calendar getCalendar(java.util.Date ad_d) {
        return getCalendar(ad_d, DEFAULT_LENIENT);
    }

    public static Calendar getCalendar(java.util.Date ad_d, boolean ab_lenient) {
        Calendar lc_c = getCalendar(ab_lenient);
        if (ad_d != null) {
            lc_c.setTime(ad_d);
        }
        return lc_c;
    }

    public static Calendar getCalendar(java.util.Date ad_d, int ai_field, int ai_amount, boolean ab_before) {
        return getCalendar(getCalendar(ad_d), ai_field, ai_amount, ab_before);
    }

    public static boolean isCalendarHoliday(Collection<Calendar> acc_holidays) {
        return isCalendarHoliday((Calendar) null, acc_holidays);
    }

    public static boolean isCalendarHoliday(Calendar ac_date, Collection<Calendar> acc_holidays) {
        return isHolidayByTimeDefinition(ac_date, getTimeDefinitionsFromCalendars(acc_holidays));
    }

    public static boolean isCalendarHoliday(java.util.Date ad_date, Collection<Calendar> acc_holidays) {
        return isCalendarHoliday(getCalendar(ad_date), acc_holidays);
    }

    public static Collection<Calendar> getCalendars(Collection<java.util.Date> acd_dates) {
        Collection<Calendar> lcc_calendars = null;
        if (CollectionUtils.isValidCollection(acd_dates)) {
            Iterator<java.util.Date> lid_dates = acd_dates.iterator();
            lcc_calendars = new ArrayList();
            while (lid_dates.hasNext()) {
                lcc_calendars.add(getCalendar((java.util.Date) lid_dates.next()));
            }
        }
        return lcc_calendars;
    }

    public static Calendar getCleanCalendar() {
        return getCleanCalendar((Calendar) null);
    }

    public static Calendar getCleanCalendar(Calendar ac_c) {
        return getCleanCalendar(ac_c, DEFAULT_CLEAN_FIELD);
    }

    public static Calendar getCleanCalendar(Calendar ac_c, int ai_field) {
        return clearCalendarFrom(getCalendar(ac_c), ai_field);
    }

    public static Calendar getCleanCalendar(java.util.Date ad_d) {
        return getCleanCalendar(getCalendar(ad_d));
    }

    public static Calendar getCleanCalendar(java.util.Date ad_d, int ai_field) {
        return getCleanCalendar(getCalendar(ad_d), ai_field);
    }

    public static Calendar getCleanCalendar(int ai_field) {
        return getCleanCalendar((Calendar) null, ai_field);
    }

    public static java.util.Date getCleanDate() {
        return getCleanDate((Calendar) null);
    }

    public static java.util.Date getCleanDate(Calendar ac_c) {
        return getCleanDate(ac_c, DEFAULT_CLEAN_FIELD);
    }

    public static java.util.Date getCleanDate(Calendar ac_c, int ai_field) {
        return getCleanCalendar(ac_c, ai_field).getTime();
    }

    public static java.util.Date getCleanDate(java.util.Date ad_d) {
        return getCleanDate(getCalendar(ad_d));
    }

    public static java.util.Date getCleanDate(java.util.Date ad_d, int ai_field) {
        return getCleanDate(getCalendar(ad_d), ai_field);
    }

    public static java.util.Date getCleanDate(int ai_field) {
        return getCleanDate((Calendar) null, ai_field);
    }

    public static java.sql.Date getCleanSQLDate() {
        return getSQLDate(getCleanCalendar());
    }

    public static java.sql.Date getCleanSQLDate(Calendar ac_c) {
        return getSQLDate(getCleanCalendar(ac_c));
    }

    public static java.sql.Date getCleanSQLDate(Calendar ac_c, int ai_field) {
        return getSQLDate(getCleanCalendar(ac_c, ai_field));
    }

    public static java.sql.Date getCleanSQLDate(java.util.Date ad_d) {
        return getSQLDate(getCleanDate(ad_d));
    }

    public static java.sql.Date getCleanSQLDate(java.util.Date ad_d, int ai_field) {
        return getSQLDate(getCleanDate(ad_d, ai_field));
    }

    public static java.sql.Date getCleanSQLDate(int ai_field) {
        return getSQLDate(getCleanCalendar(ai_field));
    }

    public static Timestamp getCleanTimestamp() {
        return getTimestamp(getCleanCalendar());
    }

    public static Timestamp getCleanTimestamp(Calendar ac_c) {
        return getTimestamp(getCleanCalendar(ac_c));
    }

    public static Timestamp getCleanTimestamp(Calendar ac_c, int ai_field) {
        return getTimestamp(getCleanCalendar(ac_c, ai_field));
    }

    public static Timestamp getCleanTimestamp(java.util.Date ad_d) {
        return getTimestamp(getCleanDate(ad_d));
    }

    public static Timestamp getCleanTimestamp(java.util.Date ad_d, int ai_field) {
        return getTimestamp(getCleanDate(ad_d, ai_field));
    }

    public static Timestamp getCleanTimestamp(int ai_field) {
        return getTimestamp(getCleanCalendar(ai_field));
    }

    public static java.util.Date getDate(Calendar ac_c, int ai_field, int ai_amount, boolean ab_before) {
        return getCalendar(ac_c, ai_field, ai_amount, ab_before).getTime();
    }

    public static java.util.Date getDate(java.sql.Date ad_d) {
        return ad_d != null ? new java.util.Date(ad_d.getTime()) : null;
    }

    public static java.util.Date getDate(java.util.Date ad_d, int ai_field, int ai_amount, boolean ab_before) {
        return getDate(getCalendar(ad_d), ai_field, ai_amount, ab_before);
    }

    public static java.util.Date getDate(int ai_julianDate) {
        String ls_julianDate = StringUtils.getStringZero(ai_julianDate, 6);
        StringBuilder lsb_date = new StringBuilder();

        String ls_century = ls_julianDate.substring(0, 1);
        int li_century;
        try {
            li_century = Integer.parseInt(ls_century);
        } catch (NumberFormatException le_e) {
            li_century = 0;
        }
        lsb_date.append(li_century + 19);

        lsb_date.append(ls_julianDate.substring(1, 3));
        lsb_date.append(ls_julianDate.substring(3, 6));

        return getDate(lsb_date.toString(), "yyyyDDD");
    }

    public static java.util.Date getDate(String as_date, String as_format) {
        return getDate(as_date, as_format, DEFAULT_LENIENT);
    }

    public static java.util.Date getDate(String as_date, String as_format, boolean ab_lenient) {
        java.util.Date ld_d;
        if ((StringUtils.isValidString(as_date)) && (StringUtils.isValidString(as_format))) {
            SimpleDateFormat lsdf_sdf = new SimpleDateFormat(as_format);

            lsdf_sdf.setLenient(ab_lenient);
            try {
                ld_d = lsdf_sdf.parse(StringUtils.getString(as_date));
            } catch (ParseException le_e) {
                ld_d = null;
            }
        } else {
            ld_d = null;
        }
        return ld_d;
    }

    public static java.util.Date getDate(Timestamp at_t) {
        return at_t != null ? new java.util.Date(at_t.getTime()) : null;
    }

    public static boolean isDateHoliday(Collection<java.util.Date> acd_holidays) {
        return isDateHoliday((Calendar) null, acd_holidays);
    }

    public static boolean isDateHoliday(Calendar ac_date, Collection<java.util.Date> acd_holidays) {
        return isHolidayByTimeDefinition(ac_date, getTimeDefinitionsFromDates(acd_holidays));
    }

    public static boolean isDateHoliday(java.util.Date ad_date, Collection<java.util.Date> acd_holidays) {
        return isDateHoliday(getCalendar(ad_date), acd_holidays);
    }

    public static Collection<java.util.Date> getDates(Collection<Calendar> acc_calendars) {
        Collection<java.util.Date> lcd_dates = null;
        if (CollectionUtils.isValidCollection(acc_calendars)) {
            Iterator<Calendar> lic_calendars = acc_calendars.iterator();
            lcd_dates = new ArrayList();
            while (lic_calendars.hasNext()) {
                lcd_dates.add(getCalendar((Calendar) lic_calendars.next()).getTime());
            }
        }
        return lcd_dates;
    }

    public static int getDayOfMonth(java.util.Date ad_d) {
        return getField(ad_d, 5);
    }

    public static int getDayOfWeek(int ai_i) {
        Calendar lc_c = getCalendar((Calendar) null);
        int li_maxDayOfWeek = lc_c.getMaximum(7);
        int li_minDayOfWeek = lc_c.getMinimum(7);

        return (li_minDayOfWeek <= ai_i) && (ai_i <= li_maxDayOfWeek) ? ai_i : li_maxDayOfWeek;
    }

    public static int getField(java.util.Date ad_d, int ai_field) {
        return getCalendar(ad_d).get(ai_field);
    }

    public static Calendar getFirstCalendarOfMonth() {
        return getFirstCalendarOfMonth((Calendar) null);
    }

    public static Calendar getFirstCalendarOfMonth(Calendar ac_c) {
        Calendar lc_c = clearCalendarFrom(getCalendar(ac_c), 11);

        lc_c.set(5, lc_c.getActualMinimum(5));

        return lc_c;
    }

    public static Calendar getFirstCalendarOfMonth(java.util.Date ad_d) {
        return getFirstCalendarOfMonth(getCalendar(ad_d));
    }

    public static java.util.Date getFirstDateOfMonth() {
        return getFirstDateOfMonth((Calendar) null);
    }

    public static java.util.Date getFirstDateOfMonth(Calendar ac_c) {
        return getFirstCalendarOfMonth(ac_c).getTime();
    }

    public static java.util.Date getFirstDateOfMonth(java.util.Date ad_d) {
        return getFirstDateOfMonth(getCalendar(ad_d));
    }

    public static java.sql.Date getFirstSQLDateOfMonth() {
        return getFirstSQLDateOfMonth((Calendar) null);
    }

    public static java.sql.Date getFirstSQLDateOfMonth(Calendar ac_c) {
        return getSQLDate(getFirstCalendarOfMonth(ac_c));
    }

    public static java.sql.Date getFirstSQLDateOfMonth(java.util.Date ad_d) {
        return getFirstSQLDateOfMonth(getCalendar(ad_d));
    }

    public static boolean isHolidayByTimeDefinition(Calendar ac_date, Collection<Long> acl_holidays) {
        boolean lb_holiday = false;
        Calendar lc_date = getCleanCalendar(ac_date);
        if (CollectionUtils.isValidCollection(acl_holidays)) {
            lb_holiday = acl_holidays.contains(NumericUtils.getLongWrapper(lc_date.getTimeInMillis()));
        }
        return lb_holiday;
    }

    public static boolean isHolidayByTimeDefinition(Collection<Long> acl_holidays) {
        return isHolidayByTimeDefinition((Calendar) null, acl_holidays);
    }

    public static boolean isHolidayByTimeDefinition(java.util.Date ad_date, Collection<Long> acl_holidays) {
        return isHolidayByTimeDefinition(getCalendar(ad_date), acl_holidays);
    }

    public static int getJulianDate(java.util.Date ad_d) {
        StringBuffer lsb_date = new StringBuffer();

        int li_year = getYear(ad_d) / 100 - 19;
        if (li_year < 0) {
            li_year = 0;
        }
        lsb_date.append(li_year);

        lsb_date.append(StringUtils.getString(ad_d, "yyDDD"));
        int li_date;
        try {
            li_date = Integer.parseInt(lsb_date.toString());
        } catch (Exception le_e) {
            li_date = 0;
        }
        return li_date;
    }

    public static Calendar getLastCalendarOfMonth() {
        return getLastCalendarOfMonth((Calendar) null);
    }

    public static Calendar getLastCalendarOfMonth(Calendar ac_c) {
        Calendar lc_c = clearCalendarFrom(getCalendar(ac_c), 11);

        lc_c.set(5, getLastDayOfMonth(lc_c));

        return lc_c;
    }

    public static Calendar getLastCalendarOfMonth(java.util.Date ad_d) {
        return getLastCalendarOfMonth(getCalendar(ad_d));
    }

    public static Calendar getLastCalendarOfYear() {
        return getLastCalendarOfYear((Calendar) null);
    }

    public static Calendar getLastCalendarOfYear(Calendar ac_c) {
        Calendar lc_c = getCalendar(ac_c);
        int li_year = lc_c.get(1);
        int li_month = lc_c.getActualMaximum(2);

        lc_c.set(2, li_month);

        int li_day = lc_c.getActualMaximum(5);

        lc_c.set(li_year, li_month, li_day);
        clearCalendarFrom(lc_c, 11);

        return lc_c;
    }

    public static Calendar getLastCalendarOfYear(java.util.Date ad_d) {
        return getLastCalendarOfYear(getCalendar(ad_d));
    }

    public static java.util.Date getLastDateOfMonth() {
        return getLastDateOfMonth((Calendar) null);
    }

    public static java.util.Date getLastDateOfMonth(Calendar ac_c) {
        return getLastCalendarOfMonth(ac_c).getTime();
    }

    public static java.util.Date getLastDateOfMonth(java.util.Date ad_d) {
        return getLastDateOfMonth(getCalendar(ad_d));
    }

    public static java.util.Date getLastDateOfYear() {
        return getLastDateOfYear((Calendar) null);
    }

    public static java.util.Date getLastDateOfYear(Calendar ac_c) {
        return getLastCalendarOfYear(ac_c).getTime();
    }

    public static java.util.Date getLastDateOfYear(java.util.Date ad_d) {
        return getLastDateOfYear(getCalendar(ad_d));
    }

    public static int getLastDayOfMonth() {
        return getLastDayOfMonth((Calendar) null);
    }

    public static int getLastDayOfMonth(Calendar ac_c) {
        return getCalendar().getActualMaximum(5);
    }

    public static int getLastDayOfMonth(java.util.Date ad_d) {
        return getLastDayOfMonth(getCalendar(ad_d));
    }

    public static int getLastDayOfMonth(int ai_month, int ai_year) {
        Calendar lc_c = getCalendar((Calendar) null);

        lc_c.clear();
        lc_c.set(2, ai_month);
        lc_c.set(1, ai_year);

        return getLastDayOfMonth(lc_c);
    }

    public static java.sql.Date getLastSQLDateOfMonth() {
        return getLastSQLDateOfMonth((Calendar) null);
    }

    public static java.sql.Date getLastSQLDateOfMonth(Calendar ac_c) {
        return getSQLDate(getLastCalendarOfMonth(ac_c));
    }

    public static java.sql.Date getLastSQLDateOfMonth(java.util.Date ad_d) {
        return getSQLDate(getLastDateOfMonth(ad_d));
    }

    public static boolean isLeapYear() {
        return isLeapYear((Calendar) null);
    }

    public static boolean isLeapYear(Calendar ac_c) {
        return isLeapYear(getCalendar(ac_c).get(1));
    }

    public static boolean isLeapYear(java.util.Date ad_d) {
        return isLeapYear(getYear(ad_d));
    }

    public static boolean isLeapYear(int ai_year) {
        boolean lb_leapYear = true;
        if (ai_year % 4 == 0) {
            if (ai_year % 100 == 0) {
                if (ai_year % 400 == 0) {
                    lb_leapYear = true;
                } else {
                    lb_leapYear = false;
                }
            } else {
                lb_leapYear = true;
            }
        } else {
            lb_leapYear = false;
        }
        return lb_leapYear;
    }

    public static Calendar getMaximumCalendar() {
        return getMaximumCalendar((Calendar) null);
    }

    public static Calendar getMaximumCalendar(Calendar ac_c) {
        return getMaximumCalendar(ac_c, DEFAULT_MAXIMUM_FIELD);
    }

    public static Calendar getMaximumCalendar(Calendar ac_c, int ai_field) {
        return setMaximumFrom(getCalendar(ac_c), ai_field);
    }

    public static Calendar getMaximumCalendar(java.util.Date ad_d) {
        return getMaximumCalendar(getCalendar(ad_d));
    }

    public static Calendar getMaximumCalendar(java.util.Date ad_d, int ai_field) {
        return getMaximumCalendar(getCalendar(ad_d), ai_field);
    }

    public static Calendar getMaximumCalendar(Collection<Calendar> acc_dates) {
        Calendar lc_max = null;
        if (CollectionUtils.isValidCollection(acc_dates)) {
            Iterator<Calendar> lid_dates = acc_dates.iterator();
            lc_max = (Calendar) lid_dates.next();
            while (lid_dates.hasNext()) {
                Calendar lc_tmp = (Calendar) lid_dates.next();
                if (lc_tmp.after(lc_max)) {
                    lc_max = lc_tmp;
                }
            }
        }
        return lc_max;
    }

    public static java.util.Date getMaximumDate() {
        return getMaximumDate((Calendar) null);
    }

    public static java.util.Date getMaximumDate(Calendar ac_c) {
        return getMaximumDate(ac_c, DEFAULT_MAXIMUM_FIELD);
    }

    public static java.util.Date getMaximumDate(Calendar ac_c, int ai_field) {
        return getMaximumCalendar(ac_c).getTime();
    }

    public static java.util.Date getMaximumDate(java.util.Date ad_d) {
        return getMaximumDate(getCalendar(ad_d));
    }

    public static java.util.Date getMaximumDate(java.util.Date ad_d, int ai_field) {
        return getMaximumDate(getCalendar(ad_d), ai_field);
    }

    public static java.util.Date getMaximumDate(Collection<java.util.Date> acd_dates) {
        java.util.Date ld_max = null;
        if (CollectionUtils.isValidCollection(acd_dates)) {
            Iterator<java.util.Date> lid_dates = acd_dates.iterator();
            ld_max = (java.util.Date) lid_dates.next();
            while (lid_dates.hasNext()) {
                java.util.Date ld_tmp = (java.util.Date) lid_dates.next();
                if (ld_tmp.after(ld_max)) {
                    ld_max = ld_tmp;
                }
            }
        }
        return ld_max;
    }

    public static Calendar getMinimumCalendar(Collection<Calendar> acc_dates) {
        Calendar lc_min = null;
        if (CollectionUtils.isValidCollection(acc_dates)) {
            Iterator<Calendar> lid_dates = acc_dates.iterator();
            lc_min = (Calendar) lid_dates.next();
            while (lid_dates.hasNext()) {
                Calendar lc_tmp = (Calendar) lid_dates.next();
                if (lc_tmp.before(lc_min)) {
                    lc_min = lc_tmp;
                }
            }
        }
        return lc_min;
    }

    public static java.util.Date getMinimumDate(Collection<java.util.Date> acd_dates) {
        java.util.Date ld_min = null;
        if (CollectionUtils.isValidCollection(acd_dates)) {
            Iterator<java.util.Date> lid_dates = acd_dates.iterator();
            ld_min = (java.util.Date) lid_dates.next();
            while (lid_dates.hasNext()) {
                java.util.Date ld_tmp = (java.util.Date) lid_dates.next();
                if (ld_tmp.before(ld_min)) {
                    ld_min = ld_tmp;
                }
            }
        }
        return ld_min;
    }

    public static int getMonth(java.util.Date ad_d) {
        return getField(ad_d, 2) + 1;
    }

    public static java.sql.Date getSQLDate() {
        return getSQLDateNotNull((Calendar) null);
    }

    public static java.sql.Date getSQLDate(Calendar ac_c) {
        return ac_c != null ? new java.sql.Date(ac_c.getTimeInMillis()) : null;
    }

    public static java.sql.Date getSQLDate(java.util.Date ad_d) {
        return ad_d != null ? new java.sql.Date(ad_d.getTime()) : null;
    }

    public static java.sql.Date getSQLDate(int ai_julianDate) {
        return getSQLDate(getDate(ai_julianDate));
    }

    public static java.sql.Date getSQLDate(java.util.Date ad_d, int ai_field, int ai_amount, boolean ab_before) {
        return getSQLDate(getDate(ad_d, ai_field, ai_amount, ab_before));
    }

    public static java.sql.Date getSQLDate(String as_date, String as_format) {
        return getSQLDate(getDate(as_date, as_format));
    }

    public static java.sql.Date getSQLDateNotNull(Calendar ac_c) {
        return getSQLDate(getCalendar(ac_c));
    }

    public static java.sql.Date getSQLDateNotNull(java.util.Date ad_d) {
        return getSQLDate(getPrivateDate(ad_d));
    }

    public static Collection<Long> getTimeDefinitionsFromCalendars(Collection<Calendar> acc_dates) {
        Collection<Long> lcl_holidays = null;
        if (CollectionUtils.isValidCollection(acc_dates)) {
            Iterator<Calendar> lic_dates = acc_dates.iterator();
            lcl_holidays = new HashSet();
            while (lic_dates.hasNext()) {
                Calendar lc_date = (Calendar) lic_dates.next();
                if (lc_date != null) {
                    lcl_holidays.add(NumericUtils.getLongWrapper(getCleanCalendar(lc_date).getTimeInMillis()));
                }
            }
        }
        return lcl_holidays;
    }

    public static Collection<Long> getTimeDefinitionsFromDates(Collection<java.util.Date> acd_dates) {
        return getTimeDefinitionsFromCalendars(getCalendars(acd_dates));
    }

    public static Timestamp getTimestamp() {
        return getTimestampNotNull((Calendar) null);
    }

    public static Timestamp getTimestamp(Calendar ac_c) {
        return ac_c != null ? getTimestamp(ac_c.getTimeInMillis()) : null;
    }

    public static Timestamp getTimestamp(java.util.Date ad_d) {
        return ad_d != null ? getTimestamp(ad_d.getTime()) : null;
    }

    public static Timestamp getTimestamp(long al_long) {
        return new Timestamp(al_long);
    }

    public static Timestamp getTimestamp(String as_date, String as_format) {
        return getTimestamp(getDate(as_date, as_format));
    }

    public static Timestamp getTimestampNotNull(java.util.Date ad_d) {
        return getTimestamp(getPrivateDate(ad_d));
    }

    public static Timestamp getTimestampNotNull(Calendar ac_c) {
        return getTimestamp(getCalendar(ac_c));
    }

    public static boolean isWeekEndDate() {
        return isWeekEndDate((Calendar) null);
    }

    public static boolean isWeekEndDate(Calendar ac_date) {
        Calendar lc_calendar = getCalendar(ac_date);
        int li_day = lc_calendar.get(7);

        return (li_day == 7) || (li_day == 1);
    }

    public static boolean isWeekEndDate(java.util.Date ad_date) {
        return isWeekEndDate(getCalendar(ad_date));
    }

    public static Collection<java.util.Date> getWeekEndDays(Calendar ac_start, Calendar ac_end) {
        Collection<java.util.Date> lcd_weekEndDays = null;
        if ((ac_start != null) && (ac_end != null)) {
            Calendar lc_c = getCalendar(ac_start);
            lcd_weekEndDays = new HashSet();
            while (lc_c.before(ac_end)) {
                if (isWeekEndDate(lc_c)) {
                    lcd_weekEndDays.add(lc_c.getTime());
                }
                lc_c.add(6, 1);
            }
        }
        return lcd_weekEndDays;
    }

    public static Collection<java.util.Date> getWeekEndDays(java.util.Date ad_start, java.util.Date ad_end) {
        return getWeekEndDays(getCalendar(ad_start), getCalendar(ad_end));
    }

    public static boolean isWorkingCalendar(Collection<Calendar> acc_holidays) {
        return isWorkingCalendar((Calendar) null, acc_holidays);
    }

    public static boolean isWorkingCalendar(Calendar ac_date, Collection<Calendar> acc_holidays) {
        return isWorkingDateByTimeDefinition(ac_date, getTimeDefinitionsFromCalendars(acc_holidays));
    }

    public static boolean isWorkingCalendar(java.util.Date ad_date, Collection<Calendar> acc_holidays) {
        return isWorkingCalendar(getCalendar(ad_date), acc_holidays);
    }

    public static boolean isWorkingDate(Collection<java.util.Date> acd_holidays) {
        return isWorkingDate((Calendar) null, acd_holidays);
    }

    public static boolean isWorkingDate(Calendar ac_date, Collection<java.util.Date> acd_holidays) {
        return isWorkingDateByTimeDefinition(ac_date, getTimeDefinitionsFromDates(acd_holidays));
    }

    public static boolean isWorkingDate(java.util.Date ad_date, Collection<java.util.Date> acd_holidays) {
        return isWorkingDate(getCalendar(ad_date), acd_holidays);
    }

    public static boolean isWorkingDateByTimeDefinition(Collection<Long> acl_holidays) {
        return isWorkingDateByTimeDefinition((Calendar) null, acl_holidays);
    }

    public static boolean isWorkingDateByTimeDefinition(Calendar ac_date, Collection<Long> acl_holidays) {
        boolean lb_answer = isWeekEndDate(ac_date);
        if (!lb_answer) {
            lb_answer = isHolidayByTimeDefinition(ac_date, acl_holidays);
        }
        return lb_answer;
    }

    public static boolean isWorkingDateByTimeDefinition(java.util.Date ad_date, Collection<Long> acl_holidays) {
        return isWorkingDateByTimeDefinition(getCalendar(ad_date), acl_holidays);
    }

    /*public static long getWorkingDays(java.util.Date ad_start, java.util.Date ad_end, Collection<java.util.Date> acc_holidays) {
        long ll_workingDays = 0L;
        if ((ad_start != null) && (ad_end != null)) {
            Calendar lc_start = getCalendar(ad_start);
            Calendar lc_end = getCalendar(ad_end);
            ll_workingDays = DurationUtils.getElapsed(ad_start, ad_end, 5);
            while (lc_start.before(lc_end)) {
                if (isDateHoliday(lc_start, acc_holidays)) {
                    ll_workingDays -= 1L;
                }
                lc_start.add(6, 1);
            }
        }
        return ll_workingDays;
    }*/

    public static int getYear(java.util.Date ad_d) {
        return getField(ad_d, 1);
    }

    public static Calendar clearCalendarFrom() {
        return clearCalendarFrom(DEFAULT_CLEAN_FIELD);
    }

    public static Calendar clearCalendarFrom(Calendar ac_c, int ai_field) {
        Calendar lc_c = getCalendar(ac_c);
        if (ac_c != null) {
            switch (ai_field) {
                case 5:
                    lc_c = clearFromDayOfMonth(lc_c);

                    break;
                case 10:
                case 11:
                    lc_c = clearFromHour(lc_c);

                    break;
                case 14:
                    lc_c = clearFromMillisecond(lc_c);

                    break;
                case 12:
                    lc_c = clearFromMinute(lc_c);

                    break;
                case 2:
                    lc_c = clearFromMonth(lc_c);

                    break;
                case 13:
                    lc_c = clearFromSecond(lc_c);

                    break;
            }
        }
        return lc_c;
    }

    public static Calendar clearCalendarFrom(java.util.Date ad_d, int ai_field) {
        return clearCalendarFrom(getCalendar(ad_d), ai_field);
    }

    public static Calendar clearCalendarFrom(int ai_field) {
        return clearCalendarFrom((Calendar) null, ai_field);
    }

    public static java.util.Date clearDateFrom() {
        return clearDateFrom(DEFAULT_CLEAN_FIELD);
    }

    public static java.util.Date clearDateFrom(Calendar ac_c, int ai_field) {
        return clearCalendarFrom(ac_c, ai_field).getTime();
    }

    public static java.util.Date clearDateFrom(java.util.Date ad_d, int ai_field) {
        return clearDateFrom(getCalendar(ad_d), ai_field);
    }

    public static java.util.Date clearDateFrom(int ai_field) {
        return clearDateFrom((Calendar) null, ai_field);
    }

    public static java.util.Date increase(java.util.Date ad_date, int ai_field, int ai_amount) {
        return getCalendar(ad_date, ai_field, ai_amount, false).getTime();
    }

    static java.util.Date getPrivateDate() {
        return getPrivateDate(null);
    }

    static java.util.Date getPrivateDate(java.util.Date ad_d) {
        return ad_d != null ? (java.util.Date) ad_d.clone() : new java.util.Date();
    }

    private static Calendar setActualMinimum(Calendar ac_c, int ai_field) {
        if (ac_c != null) {
            ac_c.set(ai_field, ac_c.getActualMinimum(ai_field));
        }
        return ac_c;
    }

    private static Calendar setMaximumDayOfMonth(Calendar ac_c) {
        setMaximumHour(ac_c);

        int li_field = 5;

        ac_c.set(li_field, ac_c.getActualMaximum(li_field));

        return ac_c;
    }

    private static Calendar setMaximumFrom(Calendar ac_c, int ai_field) {
        Calendar lc_c;
        switch (ai_field) {
            case 5:
                lc_c = setMaximumDayOfMonth(ac_c);

                break;
            case 10:
            case 11:
                lc_c = setMaximumHour(ac_c);

                break;
            case 14:
                lc_c = setMaximumMillisecond(ac_c);

                break;
            case 12:
                lc_c = setMaximumMinute(ac_c);

                break;
            case 2:
                lc_c = setMaximumMonth(ac_c);

                break;
            case 13:
                lc_c = setMaximumSecond(ac_c);

                break;
            case 3:
            case 4:
            case 6:
            case 7:
            case 8:
            case 9:
            default:
                lc_c = ac_c;
        }
        return lc_c;
    }

    private static Calendar setMaximumHour(Calendar ac_c) {
        setMaximumMinute(ac_c);

        int li_field = 10;

        ac_c.set(li_field, ac_c.getActualMaximum(li_field));

        li_field = 11;

        ac_c.set(li_field, ac_c.getActualMaximum(li_field));

        return ac_c;
    }

    private static Calendar setMaximumMillisecond(Calendar ac_c) {
        int li_field = 14;

        ac_c.set(li_field, ac_c.getActualMaximum(li_field));

        return ac_c;
    }

    private static Calendar setMaximumMinute(Calendar ac_c) {
        int li_field = 12;

        setMaximumSecond(ac_c);

        ac_c.set(li_field, ac_c.getActualMaximum(li_field));

        return ac_c;
    }

    private static Calendar setMaximumMonth(Calendar ac_c) {
        setMaximumDayOfMonth(ac_c);

        int li_field = 2;

        ac_c.set(li_field, ac_c.getActualMaximum(li_field));

        return ac_c;
    }

    private static Calendar setMaximumSecond(Calendar ac_c) {
        int li_field = 13;

        setMaximumMillisecond(ac_c);

        ac_c.set(li_field, ac_c.getActualMaximum(li_field));

        return ac_c;
    }

    private static Calendar clearFromDayOfMonth(Calendar ac_c) {
        clearFromHour(ac_c);
        setActualMinimum(ac_c, 5);

        return ac_c;
    }

    private static Calendar clearFromHour(Calendar ac_c) {
        clearFromMinute(ac_c);
        setActualMinimum(ac_c, 10);
        setActualMinimum(ac_c, 11);

        return ac_c;
    }

    private static Calendar clearFromMillisecond(Calendar ac_c) {
        setActualMinimum(ac_c, 14);

        return ac_c;
    }

    private static Calendar clearFromMinute(Calendar ac_c) {
        clearFromSecond(ac_c);
        setActualMinimum(ac_c, 12);

        return ac_c;
    }

    private static Calendar clearFromMonth(Calendar ac_c) {
        clearFromDayOfMonth(ac_c);
        setActualMinimum(ac_c, 2);

        return ac_c;
    }

    private static Calendar clearFromSecond(Calendar ac_c) {
        clearFromMillisecond(ac_c);
        setActualMinimum(ac_c, 13);

        return ac_c;
    }
}
