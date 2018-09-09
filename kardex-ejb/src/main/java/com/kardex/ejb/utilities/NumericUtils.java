/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kardex.ejb.utilities;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author ADMIN
 */
public class NumericUtils {

    public static double DEFAULT_DOUBLE_VALUE = 0.0D;
    public static float DEFAULT_FLOAT_VALUE = 0.0F;
    public static int DEFAULT_INT_VALUE = 0;
    public static long DEFAULT_LONG_VALUE = 0L;
    public static short DEFAULT_SHORT_VALUE = 0;

    public static BigDecimal getBigDecimal(double ad_d) {
        return new BigDecimal(ad_d);
    }

    public static BigDecimal getBigDecimal(float af_f) {
        return new BigDecimal(af_f);
    }

    public static BigDecimal getBigDecimal(int ai_i) {
        return new BigDecimal(ai_i);
    }

    public static BigDecimal getBigDecimal(long al_l) {
        return new BigDecimal(al_l);
    }

    public static BigInteger getBigInteger(int ai_i) {
        return new BigInteger(getInteger(ai_i).toString());
    }

    public static BigInteger getBigInteger(long al_l) {
        return new BigInteger(getLongWrapper(al_l).toString());
    }

    public static boolean getBoolean(double ad_d) {
        return ad_d != 0.0D;
    }

    public static boolean getBoolean(Double ad_d) {
        return (ad_d != null) && (getBoolean(getDouble(ad_d)));
    }

    public static boolean getBoolean(float af_f) {
        return af_f != 0.0D;
    }

    public static boolean getBoolean(Float af_f) {
        return (af_f != null) && (getBoolean(getFloat(af_f)));
    }

    public static boolean getBoolean(int ai_i) {
        return ai_i != 0;
    }

    public static boolean getBoolean(Integer ai_i) {
        return (ai_i != null) && (getBoolean(getInt(ai_i)));
    }

    public static boolean getBoolean(long al_l) {
        return al_l != 0L;
    }

    public static boolean getBoolean(Long al_l) {
        return (al_l != null) && (getBoolean(getLong(al_l)));
    }

    public static boolean getBoolean(short as_s) {
        return as_s != getShort(0);
    }

    public static boolean getBoolean(Short as_s) {
        return (as_s != null) && (getBoolean(getShort(as_s)));
    }

    public static boolean getBoolean(String as_s) {
        boolean lb_b = StringUtils.isValidString(as_s);
        if (lb_b) {
            String ls_s = StringUtils.getStringLowerCase(as_s);

            lb_b = (ls_s.equals("t")) || (ls_s.equals("true")) || (ls_s.equals("on")) || (ls_s.equals("1"));
        }
        return lb_b;
    }

    public static double getDouble(boolean ab_b) {
        return ab_b ? 1.0D : 0.0D;
    }

    public static double getDouble(Boolean ab_b) {
        return ab_b != null ? getDouble(ab_b.booleanValue()) : 0.0D;
    }

    public static double getDouble(Double ad_d) {
        return getDouble(ad_d, DEFAULT_DOUBLE_VALUE);
    }

    public static double getDouble(Double ad_d, double ad_default) {
        return ad_d != null ? ad_d.doubleValue() : ad_default;
    }

    public static double getDouble(float af_f) {
        return getDouble(getFloatWrapper(af_f));
    }

    public static double getDouble(Float af_f) {
        return getDouble(af_f, DEFAULT_DOUBLE_VALUE);
    }

    public static double getDouble(Float af_f, double ad_default) {
        return af_f != null ? af_f.doubleValue() : ad_default;
    }

    public static double getDouble(int ai_i) {
        return getDouble(getInteger(ai_i));
    }

    public static double getDouble(Integer ai_i) {
        return getDouble(ai_i, DEFAULT_DOUBLE_VALUE);
    }

    public static double getDouble(Integer ai_i, double ad_default) {
        return ai_i != null ? ai_i.doubleValue() : ad_default;
    }

    public static double getDouble(long al_l) {
        return getDouble(getLongWrapper(al_l));
    }

    public static double getDouble(Long al_l) {
        return getDouble(al_l, DEFAULT_DOUBLE_VALUE);
    }

    public static double getDouble(Long al_l, double ad_default) {
        return al_l != null ? al_l.doubleValue() : ad_default;
    }

    public static double getDouble(short as_s) {
        return getDouble(getShortWrapper(as_s));
    }

    public static double getDouble(Short as_s) {
        return getDouble(as_s, DEFAULT_DOUBLE_VALUE);
    }

    public static double getDouble(Short as_s, double ad_default) {
        return as_s != null ? as_s.doubleValue() : ad_default;
    }

    public static double getDouble(String as_s) {
        return getDouble(as_s, DEFAULT_DOUBLE_VALUE);
    }

    public static double getDouble(String as_s, double ad_default) {
        return getDouble(getDoubleWrapper(as_s, ad_default), ad_default);
    }

    public static Double getDoubleWrapper(boolean ab_b) {
        return getDoubleWrapper(getDouble(ab_b));
    }

    public static Double getDoubleWrapper(Boolean ab_b) {
        return getDoubleWrapper(getDouble(ab_b));
    }

    public static Double getDoubleWrapper(double ad_d) {
        return new Double(ad_d);
    }

    public static Double getDoubleWrapper(float af_f) {
        return getDoubleWrapper(getFloatWrapper(af_f));
    }

    public static Double getDoubleWrapper(Float af_f) {
        return getDoubleWrapper(af_f, DEFAULT_DOUBLE_VALUE);
    }

    public static Double getDoubleWrapper(Float af_f, double ad_default) {
        return getDoubleWrapper(getDouble(af_f, ad_default));
    }

    public static Double getDoubleWrapper(int ai_i) {
        return getDoubleWrapper(getInteger(ai_i));
    }

    public static Double getDoubleWrapper(Integer ai_i) {
        return getDoubleWrapper(ai_i, DEFAULT_DOUBLE_VALUE);
    }

    public static Double getDoubleWrapper(Integer ai_i, double ad_default) {
        return getDoubleWrapper(getDouble(ai_i, ad_default));
    }

    public static Double getDoubleWrapper(long al_l) {
        return getDoubleWrapper(getLongWrapper(al_l));
    }

    public static Double getDoubleWrapper(Long al_l) {
        return getDoubleWrapper(al_l, DEFAULT_DOUBLE_VALUE);
    }

    public static Double getDoubleWrapper(Long al_l, double ad_default) {
        return getDoubleWrapper(getDouble(al_l, ad_default));
    }

    public static Double getDoubleWrapper(short as_s) {
        return getDoubleWrapper(getShortWrapper(as_s));
    }

    public static Double getDoubleWrapper(Short as_s) {
        return getDoubleWrapper(as_s, DEFAULT_DOUBLE_VALUE);
    }

    public static Double getDoubleWrapper(Short as_s, double ad_default) {
        return getDoubleWrapper(getDouble(as_s, ad_default));
    }

    public static Double getDoubleWrapper(String as_s) {
        return getDoubleWrapper(as_s, DEFAULT_DOUBLE_VALUE);
    }

    public static Double getDoubleWrapper(String as_s, double ad_default) {
        Double ld_d;
        try {
            ld_d = Double.valueOf(StringUtils.getString(as_s));
        } catch (Exception le_e) {
            ld_d = getDoubleWrapper(ad_default);
        }
        return ld_d;
    }

    public static float getFloat(boolean ab_b) {
        return ab_b ? 1.0F : 0.0F;
    }

    public static float getFloat(Boolean ab_b) {
        return ab_b != null ? getFloat(ab_b.booleanValue()) : 0.0F;
    }

    public static float getFloat(double ad_d) {
        return getFloat(getDoubleWrapper(ad_d));
    }

    public static float getFloat(Double ad_d) {
        return getFloat(ad_d, DEFAULT_FLOAT_VALUE);
    }

    public static float getFloat(Double ad_d, float af_default) {
        return ad_d != null ? ad_d.floatValue() : af_default;
    }

    public static float getFloat(Float af_f) {
        return getFloat(af_f, DEFAULT_FLOAT_VALUE);
    }

    public static float getFloat(Float af_f, float af_default) {
        return af_f != null ? af_f.floatValue() : af_default;
    }

    public static float getFloat(int ai_i) {
        return getFloat(getInteger(ai_i));
    }

    public static float getFloat(Integer ai_i) {
        return getFloat(ai_i, DEFAULT_FLOAT_VALUE);
    }

    public static float getFloat(Integer ai_i, float af_default) {
        return ai_i != null ? ai_i.floatValue() : af_default;
    }

    public static float getFloat(long al_l) {
        return getFloat(getLongWrapper(al_l));
    }

    public static float getFloat(Long al_l) {
        return getFloat(al_l, DEFAULT_FLOAT_VALUE);
    }

    public static float getFloat(Long al_l, float af_default) {
        return al_l != null ? al_l.floatValue() : af_default;
    }

    public static float getFloat(short as_s) {
        return getFloat(getShortWrapper(as_s));
    }

    public static float getFloat(Short as_s) {
        return getFloat(as_s, DEFAULT_FLOAT_VALUE);
    }

    public static float getFloat(Short as_s, float af_default) {
        return as_s != null ? as_s.floatValue() : af_default;
    }

    public static float getFloat(String as_s) {
        return getFloat(as_s, DEFAULT_FLOAT_VALUE);
    }

    public static float getFloat(String as_s, float af_f) {
        return getFloat(getFloatWrapper(as_s, af_f), af_f);
    }

    public static Float getFloatWrapper(boolean ab_b) {
        return getFloatWrapper(getFloat(ab_b));
    }

    public static Float getFloatWrapper(Boolean ab_b) {
        return getFloatWrapper(getFloat(ab_b));
    }

    public static Float getFloatWrapper(double ad_d) {
        return getFloatWrapper(getDoubleWrapper(ad_d));
    }

    public static Float getFloatWrapper(Double ad_d) {
        return getFloatWrapper(ad_d, DEFAULT_FLOAT_VALUE);
    }

    public static Float getFloatWrapper(Double ad_d, float af_default) {
        return getFloatWrapper(getFloat(ad_d, af_default));
    }

    public static Float getFloatWrapper(float af_f) {
        return new Float(af_f);
    }

    public static Float getFloatWrapper(String as_s) {
        return getFloatWrapper(as_s, DEFAULT_FLOAT_VALUE);
    }

    public static Float getFloatWrapper(int ai_i) {
        return getFloatWrapper(getInteger(ai_i));
    }

    public static Float getFloatWrapper(Integer ai_i) {
        return getFloatWrapper(ai_i, DEFAULT_FLOAT_VALUE);
    }

    public static Float getFloatWrapper(Integer ai_i, float af_default) {
        return getFloatWrapper(getFloat(ai_i, af_default));
    }

    public static Float getFloatWrapper(long al_l) {
        return getFloatWrapper(getLongWrapper(al_l));
    }

    public static Float getFloatWrapper(Long al_l) {
        return getFloatWrapper(al_l, DEFAULT_FLOAT_VALUE);
    }

    public static Float getFloatWrapper(Long al_l, float af_default) {
        return getFloatWrapper(getFloat(al_l, af_default));
    }

    public static Float getFloatWrapper(short as_s) {
        return getFloatWrapper(getShortWrapper(as_s));
    }

    public static Float getFloatWrapper(Short as_s) {
        return getFloatWrapper(as_s, DEFAULT_FLOAT_VALUE);
    }

    public static Float getFloatWrapper(Short as_s, float af_default) {
        return getFloatWrapper(getFloat(as_s, af_default));
    }

    public static Float getFloatWrapper(String as_s, float af_default) {
        Float lf_f;
        try {
            lf_f = Float.valueOf(StringUtils.getString(as_s));
        } catch (Exception le_e) {
            lf_f = getFloatWrapper(af_default);
        }
        return lf_f;
    }

    public static int getInt(boolean ab_b) {
        return ab_b ? 1 : 0;
    }

    public static int getInt(Boolean ab_b) {
        return ab_b != null ? getInt(ab_b.booleanValue()) : 0;
    }

    public static int getInt(double ad_d) {
        return getInt(getDoubleWrapper(ad_d));
    }

    public static int getInt(Double ad_d) {
        return getInt(ad_d, DEFAULT_INT_VALUE);
    }

    public static int getInt(Double ad_d, int ai_default) {
        return ad_d != null ? ad_d.intValue() : ai_default;
    }

    public static int getInt(float af_f) {
        return getInt(getFloatWrapper(af_f));
    }

    public static int getInt(Float af_f) {
        return getInt(af_f, DEFAULT_INT_VALUE);
    }

    public static int getInt(Float af_f, int ai_default) {
        return af_f != null ? af_f.intValue() : ai_default;
    }

    public static int getInt(Integer ai_i) {
        return getInt(ai_i, DEFAULT_INT_VALUE);
    }

    public static int getInt(Integer ai_i, int ai_default) {
        return ai_i != null ? ai_i.intValue() : ai_default;
    }

    public static int getInt(long al_l) {
        return getInt(getLongWrapper(al_l));
    }

    public static int getInt(Long al_l) {
        return getInt(al_l, DEFAULT_INT_VALUE);
    }

    public static int getInt(Long al_l, int ai_default) {
        return al_l != null ? al_l.intValue() : ai_default;
    }

    public static int getInt(short as_s) {
        return getInt(getShortWrapper(as_s));
    }

    public static int getInt(Short as_s) {
        return getInt(as_s, DEFAULT_INT_VALUE);
    }

    public static int getInt(Short as_s, int ai_default) {
        return as_s != null ? as_s.intValue() : ai_default;
    }

    public static int getInt(String as_s) {
        return getInt(as_s, DEFAULT_INT_VALUE);
    }

    public static int getInt(String as_s, int ai_default) {
        return getInt(getInteger(as_s, ai_default), ai_default);
    }

    public static Integer getInteger(boolean ab_b) {
        return getInteger(getInt(ab_b));
    }

    public static Integer getInteger(Boolean ab_b) {
        return getInteger(getInt(ab_b));
    }

    public static Integer getInteger(double ad_d) {
        return getInteger(getDoubleWrapper(ad_d));
    }

    public static Integer getInteger(Double ad_d) {
        return getInteger(ad_d, DEFAULT_INT_VALUE);
    }

    public static Integer getInteger(Double ad_d, int ai_default) {
        return getInteger(getInt(ad_d, ai_default));
    }

    public static Integer getInteger(float af_f) {
        return getInteger(getFloatWrapper(af_f));
    }

    public static Integer getInteger(Float af_f) {
        return getInteger(af_f, DEFAULT_INT_VALUE);
    }

    public static Integer getInteger(Float af_f, int ai_default) {
        return getInteger(getInt(af_f, ai_default));
    }

    public static Integer getInteger(int ai_i) {
        return new Integer(ai_i);
    }

    public static Integer getInteger(long al_l) {
        return getInteger(getLongWrapper(al_l));
    }

    public static Integer getInteger(Long al_l) {
        return getInteger(al_l, DEFAULT_INT_VALUE);
    }

    public static Integer getInteger(Long al_l, int ai_default) {
        return getInteger(getInt(al_l, ai_default));
    }

    public static Integer getInteger(short as_s) {
        return getInteger(getShortWrapper(as_s));
    }

    public static Integer getInteger(Short as_s) {
        return getInteger(as_s, DEFAULT_INT_VALUE);
    }

    public static Integer getInteger(Short as_s, int ai_default) {
        return getInteger(getInt(as_s, ai_default));
    }

    public static Integer getInteger(String as_s) {
        return getInteger(as_s, DEFAULT_INT_VALUE);
    }

    public static Integer getInteger(String as_s, int ai_default) {
        Integer li_i;
        try {
            li_i = Integer.valueOf(StringUtils.getString(as_s));
        } catch (Exception le_e) {
            li_i = getInteger(ai_default);
        }
        return li_i;
    }

    public static long getLong(boolean ab_b) {
        return ab_b ? 1L : 0L;
    }

    public static long getLong(Boolean ab_b) {
        return ab_b != null ? getLong(ab_b.booleanValue()) : 0L;
    }

    public static long getLong(double ad_d) {
        return getLong(getDoubleWrapper(ad_d));
    }

    public static long getLong(Double ad_d) {
        return getLong(ad_d, DEFAULT_LONG_VALUE);
    }

    public static long getLong(Double ad_d, long al_default) {
        return ad_d != null ? ad_d.longValue() : al_default;
    }

    public static long getLong(float af_f) {
        return getLong(getFloatWrapper(af_f));
    }

    public static long getLong(Float af_f) {
        return getLong(af_f, DEFAULT_LONG_VALUE);
    }

    public static long getLong(Float af_f, long al_default) {
        return af_f != null ? af_f.longValue() : al_default;
    }

    public static long getLong(int ai_i) {
        return getLong(getInteger(ai_i));
    }

    public static long getLong(Integer ai_i) {
        return getLong(ai_i, DEFAULT_LONG_VALUE);
    }

    public static long getLong(Integer ai_i, long al_default) {
        return ai_i != null ? ai_i.longValue() : al_default;
    }

    public static long getLong(Long al_l) {
        return getLong(al_l, DEFAULT_LONG_VALUE);
    }

    public static long getLong(Long al_l, long al_default) {
        return al_l != null ? al_l.longValue() : al_default;
    }

    public static long getLong(short as_s) {
        return getLong(getShortWrapper(as_s));
    }

    public static long getLong(Short as_s) {
        return getLong(as_s, DEFAULT_LONG_VALUE);
    }

    public static long getLong(Short as_s, long al_default) {
        return as_s != null ? as_s.longValue() : al_default;
    }

    public static long getLong(String as_s) {
        return getLong(as_s, DEFAULT_LONG_VALUE);
    }

    public static long getLong(String as_s, long al_default) {
        return getLong(getLongWrapper(as_s, al_default), al_default);
    }

    public static Long getLongWrapper(boolean ab_b) {
        return getLongWrapper(getLong(ab_b));
    }

    public static Long getLongWrapper(Boolean ab_b) {
        return getLongWrapper(getLong(ab_b));
    }

    public static Long getLongWrapper(double ad_d) {
        return getLongWrapper(getDoubleWrapper(ad_d));
    }

    public static Long getLongWrapper(Double ad_d) {
        return getLongWrapper(ad_d, DEFAULT_LONG_VALUE);
    }

    public static Long getLongWrapper(Double ad_d, long al_default) {
        return getLongWrapper(getLong(ad_d, al_default));
    }

    public static Long getLongWrapper(float af_f) {
        return getLongWrapper(getFloatWrapper(af_f));
    }

    public static Long getLongWrapper(Float af_f) {
        return getLongWrapper(af_f, DEFAULT_LONG_VALUE);
    }

    public static Long getLongWrapper(Float af_f, long al_default) {
        return getLongWrapper(getLong(af_f, al_default));
    }

    public static Long getLongWrapper(int ai_i) {
        return getLongWrapper(getInteger(ai_i));
    }

    public static Long getLongWrapper(Integer ai_i) {
        return getLongWrapper(ai_i, DEFAULT_LONG_VALUE);
    }

    public static Long getLongWrapper(Integer ai_i, long al_default) {
        return getLongWrapper(getLong(ai_i, al_default));
    }

    public static Long getLongWrapper(long al_l) {
        return new Long(al_l);
    }

    public static Long getLongWrapper(short as_s) {
        return getLongWrapper(getShortWrapper(as_s));
    }

    public static Long getLongWrapper(Short as_s) {
        return getLongWrapper(as_s, DEFAULT_LONG_VALUE);
    }

    public static Long getLongWrapper(Short as_s, long al_default) {
        return getLongWrapper(getLong(as_s, al_default));
    }

    public static Long getLongWrapper(String as_s) {
        return getLongWrapper(as_s, DEFAULT_LONG_VALUE);
    }

    public static Long getLongWrapper(String as_s, long al_default) {
        Long ll_l;
        try {
            ll_l = Long.valueOf(StringUtils.getString(as_s));
        } catch (Exception le_e) {
            ll_l = getLongWrapper(al_default);
        }
        return ll_l;
    }

    public static Double getNextDouble(Double ad_d) {
        return getDoubleWrapper(increment(ad_d));
    }

    public static Float getNextFloat(Float af_f) {
        return getFloatWrapper(increment(af_f));
    }

    public static Integer getNextInteger(Integer ai_i) {
        return getInteger(increment(ai_i));
    }

    public static Long getNextLong(Long al_l) {
        return getLongWrapper(increment(al_l));
    }

    public static Short getNextShort(Short as_s) {
        return getShortWrapper(increment(as_s));
    }

    public static double getPositiveDouble(double ad_d) {
        return ad_d < 0.0D ? 0.0D : ad_d;
    }

    public static double getPositiveDouble(String as_s) {
        return getPositiveDouble(getDouble(as_s));
    }

    public static float getPositiveFloat(float af_f) {
        return af_f < 0.0F ? 0.0F : af_f;
    }

    public static double getPositiveFloat(String as_s) {
        return getPositiveFloat(getFloat(as_s));
    }

    public static int getPositiveInt(int ai_i) {
        return ai_i < 0 ? 0 : ai_i;
    }

    public static int getPositiveInt(String as_s) {
        return getPositiveInt(getInt(as_s));
    }

    public static long getPositiveLong(long al_l) {
        return al_l < 0L ? 0L : al_l;
    }

    public static long getPositiveLong(String as_s) {
        return getPositiveLong(getLong(as_s));
    }

    public static short getPositiveShort(short as_s) {
        return as_s < 0 ? getShort(0) : as_s;
    }

    public static short getPositiveShort(String as_s) {
        return getPositiveShort(getShort(as_s));
    }

    public static Double getPreviousDouble(Double ad_d) {
        return getDoubleWrapper(increment(ad_d, -1.0D));
    }

    public static Float getPreviousFloat(Float af_f) {
        return getFloatWrapper(increment(af_f, -1.0F));
    }

    public static Integer getPreviousInteger(Integer ai_i) {
        return getInteger(increment(ai_i, -1));
    }

    public static Long getPreviousLong(Long al_l) {
        return getLongWrapper(increment(al_l, -1L));
    }

    public static Short getPreviousShort(Short as_s) {
        return getShortWrapper(increment(as_s, getShort(-1)));
    }

    public static short getShort(boolean ab_b) {
        return ab_b ? getShort(1) : getShort(0);
    }

    public static short getShort(Boolean ab_b) {
        return ab_b != null ? getShort(ab_b.booleanValue()) : getShort(0);
    }

    public static short getShort(double ad_d) {
        return getShort(getDoubleWrapper(ad_d));
    }

    public static short getShort(Double ad_d) {
        return getShort(ad_d, DEFAULT_SHORT_VALUE);
    }

    public static short getShort(Double ad_d, short as_default) {
        return ad_d != null ? ad_d.shortValue() : as_default;
    }

    public static short getShort(float af_f) {
        return getShort(getFloatWrapper(af_f));
    }

    public static short getShort(Float af_f) {
        return getShort(af_f, DEFAULT_SHORT_VALUE);
    }

    public static short getShort(Float af_f, short as_default) {
        return af_f != null ? af_f.shortValue() : as_default;
    }

    public static short getShort(int ai_i) {
        return getShort(getInteger(ai_i));
    }

    public static short getShort(Integer ai_i) {
        return getShort(ai_i, DEFAULT_SHORT_VALUE);
    }

    public static short getShort(Integer ai_i, short as_default) {
        return ai_i != null ? ai_i.shortValue() : as_default;
    }

    public static short getShort(long al_l) {
        return getShort(getLongWrapper(al_l));
    }

    public static short getShort(Long al_l) {
        return getShort(al_l, DEFAULT_SHORT_VALUE);
    }

    public static short getShort(Long al_l, short as_default) {
        return al_l != null ? al_l.shortValue() : as_default;
    }

    public static short getShort(Short as_s) {
        return getShort(as_s, DEFAULT_SHORT_VALUE);
    }

    public static short getShort(Short as_s, short as_default) {
        return as_s != null ? as_s.shortValue() : as_default;
    }

    public static short getShort(String as_s) {
        return getShort(as_s, DEFAULT_SHORT_VALUE);
    }

    public static short getShort(String as_s, short as_default) {
        return getShort(getShortWrapper(as_s, as_default), as_default);
    }

    public static Short getShortWrapper(boolean ab_b) {
        return getShortWrapper(getShort(ab_b));
    }

    public static Short getShortWrapper(Boolean ab_b) {
        return getShortWrapper(getShort(ab_b));
    }

    public static Short getShortWrapper(double ad_d) {
        return getShortWrapper(getDoubleWrapper(ad_d));
    }

    public static Short getShortWrapper(Double ad_d) {
        return getShortWrapper(ad_d, DEFAULT_SHORT_VALUE);
    }

    public static Short getShortWrapper(Double ad_d, short as_default) {
        return getShortWrapper(getShort(ad_d, as_default));
    }

    public static Short getShortWrapper(float af_f) {
        return getShortWrapper(getFloatWrapper(af_f));
    }

    public static Short getShortWrapper(Float af_f) {
        return getShortWrapper(af_f, DEFAULT_SHORT_VALUE);
    }

    public static Short getShortWrapper(Float af_f, short as_default) {
        return getShortWrapper(getShort(af_f, as_default));
    }

    public static Short getShortWrapper(int ai_i) {
        return getShortWrapper(getInteger(ai_i));
    }

    public static Short getShortWrapper(Integer ai_i) {
        return getShortWrapper(ai_i, DEFAULT_SHORT_VALUE);
    }

    public static Short getShortWrapper(Integer ai_i, short as_default) {
        return getShortWrapper(getShort(ai_i, as_default));
    }

    public static Short getShortWrapper(long al_l) {
        return getShortWrapper(getLongWrapper(al_l));
    }

    public static Short getShortWrapper(Long al_l) {
        return getShortWrapper(al_l, DEFAULT_SHORT_VALUE);
    }

    public static Short getShortWrapper(Long al_l, short as_default) {
        return getShortWrapper(getShort(al_l, as_default));
    }

    public static Short getShortWrapper(short as_s) {
        return new Short(as_s);
    }

    public static Short getShortWrapper(String as_s) {
        return getShortWrapper(as_s, DEFAULT_SHORT_VALUE);
    }

    public static Short getShortWrapper(String as_s, short as_default) {
        Short ls_s;
        try {
            ls_s = Short.valueOf(StringUtils.getString(as_s));
        } catch (Exception le_e) {
            ls_s = getShortWrapper(as_default);
        }
        return ls_s;
    }

    public static boolean isValidDouble(Double ad_d) {
        return isValidDouble(ad_d, DEFAULT_DOUBLE_VALUE);
    }

    public static boolean isValidDouble(Double ad_d, double ad_compare) {
        return (ad_d != null) && (getDouble(ad_d) >= ad_compare);
    }

    public static boolean isValidFloat(Float af_f) {
        return isValidFloat(af_f, DEFAULT_FLOAT_VALUE);
    }

    public static boolean isValidFloat(Float af_f, float af_compare) {
        return (af_f != null) && (getFloat(af_f) >= af_compare);
    }

    public static boolean isValidInteger(Integer ai_i) {
        return isValidInteger(ai_i, DEFAULT_INT_VALUE);
    }

    public static boolean isValidInteger(Integer ai_i, int ai_compare) {
        return (ai_i != null) && (getInt(ai_i) >= ai_compare);
    }

    public static boolean isValidLong(Long al_l, long al_compare) {
        return (al_l != null) && (getInt(al_l) >= al_compare);
    }

    public static boolean isValidLong(Long al_l) {
        return isValidLong(al_l, DEFAULT_LONG_VALUE);
    }

    public static boolean isValidShort(Short as_s) {
        return isValidShort(as_s, DEFAULT_SHORT_VALUE);
    }

    public static boolean isValidShort(Short as_s, short as_compare) {
        return (as_s != null) && (getShort(as_s) >= as_compare);
    }

    public static double increment(Double ad_d) {
        return increment(ad_d, 1.0D);
    }

    public static double increment(Double ad_d, double ad_increment) {
        return ad_d == null ? ad_increment : getDouble(ad_d) + ad_increment;
    }

    public static float increment(Float af_f) {
        return increment(af_f, 1.0F);
    }

    public static float increment(Float af_f, float af_increment) {
        return af_f == null ? af_increment : getFloat(af_f) + af_increment;
    }

    public static int increment(Integer ai_i) {
        return increment(ai_i, 1);
    }

    public static int increment(Integer ai_i, int ai_increment) {
        return ai_i == null ? ai_increment : getInt(ai_i) + ai_increment;
    }

    public static long increment(Long al_l) {
        return increment(al_l, 1L);
    }

    public static long increment(Long al_l, long al_increment) {
        return al_l == null ? al_increment : getLong(al_l) + al_increment;
    }

    public static short increment(Short as_s) {
        return increment(as_s, getShort(1));
    }

    public static short increment(Short as_s, short as_increment) {
        return as_s == null ? as_increment : getShort(getShort(as_s) + as_increment);
    }

    public static short max(short as_s1, short as_s2) {
        return as_s1 > as_s2 ? as_s1 : as_s2;
    }

    public static double max(double ad_d1, double ad_d2) {
        return ad_d1 > ad_d2 ? ad_d1 : ad_d2;
    }

    public static short min(short as_s1, short as_s2) {
        return as_s1 < as_s2 ? as_s1 : as_s2;
    }

    public static double min(double ad_d1, double ad_d2) {
        return ad_d1 < ad_d2 ? ad_d1 : ad_d2;
    }

}
