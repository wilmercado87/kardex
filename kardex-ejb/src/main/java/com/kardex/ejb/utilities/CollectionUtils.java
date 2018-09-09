/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
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
public class CollectionUtils {

    public static Collection getCollection(Iterator ai_i) {
        return ConverterUtils.getCollection(getObject(ai_i));
    }

    public static Collection getCollection(List al_l, int ai_index) {
        return ConverterUtils.getCollection(getObject(al_l, ai_index));
    }

    public static Collection getCollection(Map am_m, Object ao_key) {
        return ConverterUtils.getCollection(getObject(am_m, ao_key));
    }

    public static DataSource getDataSource(Iterator ai_i) {
        return ConverterUtils.getDataSource(getObject(ai_i));
    }

    public static DataSource getDataSource(List al_l, int ai_index) {
        return ConverterUtils.getDataSource(getObject(al_l, ai_index));
    }

    public static DataSource getDataSource(Map am_m, Object ao_key) {
        return ConverterUtils.getDataSource(getObject(am_m, ao_key));
    }

    public static Date getDate(Iterator ai_i) {
        return ConverterUtils.getDate(getObject(ai_i));
    }

    public static Date getDate(List al_l, int ai_index) {
        return ConverterUtils.getDate(getObject(al_l, ai_index));
    }

    public static Date getDate(Map am_m, Object ao_key) {
        return ConverterUtils.getDate(getObject(am_m, ao_key));
    }

    public static Double getDouble(Iterator ai_i) {
        return ConverterUtils.getDouble(getObject(ai_i));
    }

    public static Double getDouble(List al_l, int ai_index) {
        return ConverterUtils.getDouble(getObject(al_l, ai_index));
    }

    public static Double getDouble(Map am_m, Object ao_key) {
        return ConverterUtils.getDouble(getObject(am_m, ao_key));
    }

    public static Exception getException(Iterator ai_i) {
        return ConverterUtils.getException(getObject(ai_i));
    }

    public static Float getFloat(Iterator ai_i) {
        return ConverterUtils.getFloat(getObject(ai_i));
    }

    public static Float getFloat(List al_l, int ai_index) {
        return ConverterUtils.getFloat(getObject(al_l, ai_index));
    }

    public static Float getFloat(Map am_m, Object ao_key) {
        return ConverterUtils.getFloat(getObject(am_m, ao_key));
    }

    public static Integer getInteger(Iterator ai_i) {
        return ConverterUtils.getInteger(getObject(ai_i));
    }

    public static Integer getInteger(List al_l, int ai_index) {
        return ConverterUtils.getInteger(getObject(al_l, ai_index));
    }

    public static Integer getInteger(Map am_m, Object ao_key) {
        return ConverterUtils.getInteger(getObject(am_m, ao_key));
    }

    public static List getList(Map am_m, Object ao_key) {
        return ConverterUtils.getList(getObject(am_m, ao_key));
    }

    public static List getList(Collection ac_c) {
        return ac_c != null ? new ArrayList(ac_c) : (ac_c instanceof List) ? (List) ac_c : null;
    }

    public static Long getLong(Iterator ai_i) {
        return ConverterUtils.getLong(getObject(ai_i));
    }

    public static Long getLong(List al_l, int ai_index) {
        return ConverterUtils.getLong(getObject(al_l, ai_index));
    }

    public static Long getLong(Map am_m, Object ao_key) {
        return ConverterUtils.getLong(getObject(am_m, ao_key));
    }

    public static Session getMailSession(Map am_m, Object ao_key) {
        return ConverterUtils.getMailSession(getObject(am_m, ao_key));
    }

    public static Map getMap(Iterator ai_i) {
        return ConverterUtils.getMap(getObject(ai_i));
    }

    public static Map getMap(List al_l, int ai_index) {
        return ConverterUtils.getMap(getObject(al_l, ai_index));
    }

    public static Map getMap(Map am_m, Object ao_key) {
        return ConverterUtils.getMap(getObject(am_m, ao_key));
    }

    public static Object getObject(Enumeration ae_e) {
        return ae_e != null ? ae_e.nextElement() : null;
    }

    public static Object getObject(Iterator ai_i) {
        return ai_i != null ? ai_i.next() : null;
    }

    public static Object getObject(List al_l, int ai_index) {
        Object lo_o = null;
        if (al_l != null) {
            if ((ai_index >= 0) && (ai_index < al_l.size())) {
                lo_o = al_l.get(ai_index);
            }
        }
        return lo_o;
    }

    public static Object getObject(Map am_m, Object ao_key) {
        return (am_m != null) && (ao_key != null) ? am_m.get(ao_key) : null;
    }

    public static Queue getQueue(Iterator ai_i) {
        return ConverterUtils.getQueue(getObject(ai_i));
    }

    public static Queue getQueue(List al_l, int ai_index) {
        return ConverterUtils.getQueue(getObject(al_l, ai_index));
    }

    public static Queue getQueue(Map am_m, Object ao_key) {
        return ConverterUtils.getQueue(getObject(am_m, ao_key));
    }

    public static QueueConnectionFactory getQueueConnectionFactory(Iterator ai_i) {
        return ConverterUtils.getQueueConnectionFactory(getObject(ai_i));
    }

    public static QueueConnectionFactory getQueueConnectionFactory(List al_l, int ai_index) {
        return ConverterUtils.getQueueConnectionFactory(getObject(al_l, ai_index));
    }

    public static QueueConnectionFactory getQueueConnectionFactory(Map am_m, Object ao_key) {
        return ConverterUtils.getQueueConnectionFactory(getObject(am_m, ao_key));
    }

    public static Short getShort(Iterator ai_i) {
        return ConverterUtils.getShort(getObject(ai_i));
    }

    public static Short getShort(List al_l, int ai_index) {
        return ConverterUtils.getShort(getObject(al_l, ai_index));
    }

    public static Short getShort(Map am_m, Object ao_key) {
        return ConverterUtils.getShort(getObject(am_m, ao_key));
    }

    public static String getString(Iterator ai_i) {
        return ConverterUtils.getString(getObject(ai_i));
    }

    public static String getString(Enumeration ae_e) {
        return ConverterUtils.getString(getObject(ae_e));
    }

    public static String getString(List al_l, int ai_index) {
        return ConverterUtils.getString(getObject(al_l, ai_index));
    }

    public static String getString(Map am_m, Object ao_key) {
        return ConverterUtils.getString(getObject(am_m, ao_key));
    }

    public static StringBuffer getStringBuffer(Iterator ai_i) {
        return ConverterUtils.getStringBuffer(getObject(ai_i));
    }

    public static StringBuffer getStringBuffer(List al_l, int ai_index) {
        return ConverterUtils.getStringBuffer(getObject(al_l, ai_index));
    }

    public static StringBuffer getStringBuffer(Map am_m, Object ao_key) {
        return ConverterUtils.getStringBuffer(getObject(am_m, ao_key));
    }

    public static boolean isValidCollection(Collection ac_c) {
        return (ac_c != null) && (!ac_c.isEmpty());
    }

    public static boolean isValidCollection(Object[] loa_a) {
        return (loa_a != null) && (loa_a.length > 0);
    }

    public static boolean isValidCollection(Map am_m) {
        return (am_m != null) && (!am_m.isEmpty());
    }

    public static double incrementDouble(Map am_m, Object ao_key, double ad_d) {
        double ld_d = NumericUtils.increment(getDouble(am_m, ao_key), ad_d);

        am_m.put(ao_key, NumericUtils.getDoubleWrapper(ld_d));

        return ld_d;
    }

    public static double incrementDouble(Map am_m, Object ao_key) {
        return incrementDouble(am_m, ao_key, 1.0D);
    }

    public static float incrementFloat(Map am_m, Object ao_key, float af_f) {
        float lf_f = NumericUtils.increment(getFloat(am_m, ao_key), af_f);

        am_m.put(ao_key, NumericUtils.getFloatWrapper(lf_f));

        return lf_f;
    }

    public static float incrementFloat(Map am_m, Object ao_key) {
        return incrementFloat(am_m, ao_key, 1.0F);
    }

    public static int incrementInteger(Map am_m, Object ao_key, int ai_i) {
        int li_i = NumericUtils.increment(getInteger(am_m, ao_key), ai_i);

        am_m.put(ao_key, NumericUtils.getInteger(li_i));

        return li_i;
    }

    public static int incrementInteger(Map am_m, Object ao_key) {
        return incrementInteger(am_m, ao_key, 1);
    }

    public static long incrementLong(Map am_m, Object ao_key, long al_l) {
        long ll_l = NumericUtils.increment(getLong(am_m, ao_key), al_l);

        am_m.put(ao_key, NumericUtils.getLongWrapper(ll_l));

        return ll_l;
    }

    public static long incrementLong(Map am_m, Object ao_key) {
        return incrementLong(am_m, ao_key, 1L);
    }

    public static short incrementShort(Map am_m, Object ao_key, short as_s) {
        short ls_s = NumericUtils.increment(getShort(am_m, ao_key), as_s);

        am_m.put(ao_key, NumericUtils.getShortWrapper(ls_s));

        return ls_s;
    }

    public static short incrementShort(Map am_m, Object ao_key) {
        return incrementShort(am_m, ao_key, NumericUtils.getShort(1));
    }

    public static void initDouble(Map am_m, Object ao_key, Double ad_d) {
        if (getDouble(am_m, ao_key) == null) {
            am_m.put(ao_key, ad_d);
        }
    }

    public static void initFloat(Map am_m, Object ao_key, Float af_f) {
        if (getFloat(am_m, ao_key) == null) {
            am_m.put(ao_key, af_f);
        }
    }

    public static void initInteger(Map am_m, Object ao_key, Integer ai_i) {
        if (getInteger(am_m, ao_key) == null) {
            am_m.put(ao_key, ai_i);
        }
    }

    public static void initLong(Map am_m, Object ao_key, Long al_l) {
        if (getLong(am_m, ao_key) == null) {
            am_m.put(ao_key, al_l);
        }
    }

    public static void initShort(Map am_m, Object ao_key, Short as_s) {
        if (getShort(am_m, ao_key) == null) {
            am_m.put(ao_key, as_s);
        }
    }

    public static Collection removeDuplicates(Collection ac_c) {
        return isValidCollection(ac_c) ? new HashSet(ac_c) : ac_c;
    }

    public static Collection sort(Collection ac_collection) {
        return sort(ac_collection, null, false);
    }

    public static Collection sort(Collection ac_collection, boolean ab_reverse) {
        return sort(ac_collection, null, ab_reverse);
    }

    public static Collection sort(Collection ac_collection, Comparator ac_comparator) {
        return sort(ac_collection, ac_comparator, false);
    }

    public static Collection sort(Collection ac_collection, Comparator ac_comparator, boolean ab_reverse) {
        List ll_list = null;
        if (isValidCollection(ac_collection)) {
            if ((ac_collection instanceof List)) {
                ll_list = (List) ac_collection;
            } else {
                ll_list = Collections.synchronizedList(new ArrayList(ac_collection));
            }
            if (ac_comparator != null) {
                Collections.sort(ll_list, ac_comparator);
            } else {
                Collections.sort(ll_list);
            }
            if (ab_reverse) {
                Collections.reverse(ll_list);
            }
        }
        return ll_list;
    }
}
