/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.utilities;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.sql.DataSource;

/**
 *
 * @author ADMIN
 */
public class ConverterUtils {

    public static Boolean getBoolean(Object ao_o) {
        return (ao_o != null) && ((ao_o instanceof Boolean)) ? (Boolean) ao_o : null;
    }

    public static Calendar getCalendar(Object ao_o) {
        return (ao_o != null) && ((ao_o instanceof Calendar)) ? (Calendar) ao_o : null;
    }

    public static Collection getCollection(Object ao_o) {
        return (ao_o != null) && ((ao_o instanceof Collection)) ? (Collection) ao_o : null;
    }

    public static DataSource getDataSource(Object ao_o) {
        return (ao_o != null) && ((ao_o instanceof DataSource)) ? (DataSource) ao_o : null;
    }

    public static Date getDate(Object ao_o) {
        return (ao_o != null) && ((ao_o instanceof Date)) ? (Date) ao_o : null;
    }

    public static Double getDouble(Object ao_o) {
        return (ao_o != null) && ((ao_o instanceof Double)) ? (Double) ao_o : null;
    }

    public static Exception getException(Object ao_o) {
        return (ao_o != null) && ((ao_o instanceof Exception)) ? (Exception) ao_o : null;
    }

    public static Float getFloat(Object ao_o) {
        return (ao_o != null) && ((ao_o instanceof Float)) ? (Float) ao_o : null;
    }

    public static Integer getInteger(Object ao_o) {
        return (ao_o != null) && ((ao_o instanceof Integer)) ? (Integer) ao_o : null;
    }

    public static List getList(Object ao_o) {
        return (ao_o != null) && ((ao_o instanceof List)) ? (List) ao_o : null;
    }

    public static Long getLong(Object ao_o) {
        return (ao_o != null) && ((ao_o instanceof Long)) ? (Long) ao_o : null;
    }

    public static Session getMailSession(Object ao_o) {
        return (ao_o != null) && ((ao_o instanceof Session)) ? (Session) ao_o : null;
    }

    public static Map getMap(Object ao_o) {
        return (ao_o != null) && ((ao_o instanceof Map)) ? (Map) ao_o : null;
    }

    public static Queue getQueue(Object ao_o) {
        return (ao_o != null) && ((ao_o instanceof Queue)) ? (Queue) ao_o : null;
    }

    public static QueueConnectionFactory getQueueConnectionFactory(Object ao_o) {
        return (ao_o != null) && ((ao_o instanceof QueueConnectionFactory)) ? (QueueConnectionFactory) ao_o : null;
    }

    public static Short getShort(Object ao_o) {
        return (ao_o != null) && ((ao_o instanceof Short)) ? (Short) ao_o : null;
    }

    public static String getString(Object ao_o) {
        return (ao_o != null) && ((ao_o instanceof String)) ? (String) ao_o : null;
    }

    public static StringBuffer getStringBuffer(Object ao_o) {
        return (ao_o != null) && ((ao_o instanceof StringBuffer)) ? (StringBuffer) ao_o : null;
    }
}
