package com.util;

import com.google.common.collect.Range;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MathUtil {

    // 地球半径，平均半径为6371km
    private static final Integer RADIUS = 6378137;

    /**
     * 设置精度,默认保留两位小数点
     * @param a
     * @return
     */
    public static final BigDecimal setPrecision(BigDecimal a) {
        if (a == null) {
            return null;
        }
        BigDecimal temp = new BigDecimal(a.setScale(2,BigDecimal.ROUND_HALF_UP).toString());
        return temp;
    }

    /**
     * 设置精度,保留number位小数点
     * @param a
     * @param number
     * @return
     */
    public static final BigDecimal setPrecision(BigDecimal a, int number) {
        if (a == null ) {
            return null;
        }
        BigDecimal temp = new BigDecimal(a.setScale(number,BigDecimal.ROUND_HALF_UP).toString());
        return temp;
    }

    /**
     * 设置精度,保留number位小数点
     * @param a
     * @param number
     * @return
     */
    public static final String setPrecision(String a, int number) {
        if (a == null || "".equals(a)) {
            return a;
        }
        BigDecimal decimal = new BigDecimal(a);
        BigDecimal temp = new BigDecimal(decimal.setScale(number,BigDecimal.ROUND_HALF_UP).toString());
        return temp.toString();
    }

    /**
     * 比较大小
     * @param one
     * @param two
     * @return
     */
    public static final int compareTo(BigDecimal one, BigDecimal two) {
        int i = one.compareTo(two);
        return i;
    }

    /**
     * 相除，保留2位小数
     * @param m
     * @param n
     * @return
     */
    public static final BigDecimal divide(BigDecimal m, BigDecimal n) {
        BigDecimal divide = m.divide(n, 2, BigDecimal.ROUND_HALF_UP);
        return divide;
    }

    /**
     * 相除，保留指定的小数位
     * @param m
     * @param n
     * @param scale 精度
     * @return
     */
    public static final BigDecimal divideWithScale(BigDecimal m, BigDecimal n,int scale) {
        BigDecimal divide = m.divide(n, scale, BigDecimal.ROUND_HALF_UP);
        return divide;
    }

    /**
     * 用给定值除以100，并保留指定的小数位
     * @param m
     * @param scale 精度
     * @return
     */
    public static final BigDecimal divide100WithScale(BigDecimal m,int scale) {
        BigDecimal n = new BigDecimal("100");
        BigDecimal divide = m.divide(n, scale, BigDecimal.ROUND_HALF_UP);
        return divide;
    }

    /**
     * 用给定值除以100，并保留2小数位
     * @param m
     * @return
     */
    public static final BigDecimal divide100(BigDecimal m) {
        BigDecimal n = new BigDecimal("100");
        BigDecimal divide = m.divide(n, 2, BigDecimal.ROUND_HALF_UP);
        return divide;
    }

    /**
     * 相除，保留2位小数
     * @param m
     * @param n
     * @return
     */
    public static final BigDecimal divide(Integer m, Integer n) {
        BigDecimal a = new BigDecimal(m);
        BigDecimal b = new BigDecimal(n);
        BigDecimal divide = a.divide(b, 2, BigDecimal.ROUND_HALF_UP);
        return divide;
    }


    /**
     * 两个数相减，并保留2位小数
     * @param m
     * @param n
     * @return
     */
    public static final BigDecimal sub(BigDecimal m, BigDecimal n) {
        BigDecimal subtract = m.subtract(n);
        BigDecimal decimal = setPrecision(subtract);
        return decimal;
    }

    /**
     * 将金额分转换成元对应的字符串(保留2位小数)
     * @param payMoney
     * @return
     */
    public static final String fen2yuan(String payMoney) {
        BigDecimal temp = new BigDecimal("100");
        BigDecimal decimal = new BigDecimal(payMoney);
        BigDecimal result = decimal.divide(temp,2,BigDecimal.ROUND_HALF_UP);
        return result.toString();
    }

    /**
     * 将元转分字符串
     * @param payMoney
     * @return
     */
    public static final Integer yuan2Fen(String payMoney) {
        BigDecimal temp = new BigDecimal("100");
        BigDecimal decimal = new BigDecimal(payMoney);
        BigDecimal result = decimal.multiply(temp).setScale(0, BigDecimal.ROUND_HALF_UP);
        int ret = Integer.parseInt(result.toString());
        return ret;
    }

    /**
     * 判断a是否在[m,n]之间
     * @param a
     * @param m
     * @param n
     * @return
     */
    public static boolean isBetween(BigDecimal a,BigDecimal m, BigDecimal n) {
        Range<BigDecimal> closed = Range.closed(m, n);
        boolean contains = closed.contains(a);
        return contains;
    }


    public static boolean isBetween4LeftOpen(BigDecimal a,BigDecimal m, BigDecimal n) {
        Range<BigDecimal> closed = Range.openClosed(m, n);
        boolean contains = closed.contains(a);
        return contains;
    }

    /**
     * 判断是否one是否大于等于two
     * @param one
     * @param two
     * @return
     */
    public static boolean isGreaterEqual(BigDecimal one, BigDecimal two) {
        int i = one.compareTo(two);
        if (i >= 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否one是否大于等于0
     * @param one
     * @return
     */
    public static boolean isGreaterEqualZero(BigDecimal one) {
        BigDecimal zero = BigDecimal.ZERO;
        int i = one.compareTo(zero);
        if (i >= 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否one是否小于two
     * @param one
     * @param two
     * @return
     */
    public static boolean isLessThan(BigDecimal one, BigDecimal two) {
        int i = one.compareTo(two);
        if (i < 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断m是否小于0
     * @param m
     * @return
     */
    public static boolean isLessThanZero(BigDecimal m) {
        BigDecimal zero = BigDecimal.ZERO;
        int i = m.compareTo(zero);
        if (i < 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断m是否大于0
     * @param m
     * @return
     */
    public static boolean isGreateThanZero(BigDecimal m) {
        BigDecimal zero = BigDecimal.ZERO;
        int i = m.compareTo(zero);
        if (i > 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否one是否等于two
     * @param one
     * @param two
     * @return
     */
    public static boolean isEqual(BigDecimal one, BigDecimal two) {
        int i = one.compareTo(two);
        if (i == 0) {
            return true;
        }
        return false;
    }

    /**
     * 返回某数相反数
     * @param m
     * @return
     */
    public static BigDecimal negate(BigDecimal m) {
        return m.negate();
    }

    /**
     * 返回某数的绝对值
     * @param m
     * @return
     */
    public static BigDecimal abs(BigDecimal m) {
        BigDecimal abs = m.abs();
        return abs;
    }

    /**
     * 判断是否为0
     * @param decimal
     * @return
     */
    public static boolean isZero(BigDecimal decimal) {
        BigDecimal zero = BigDecimal.ZERO;
        int i = zero.compareTo(decimal);
        if (i == 0) {
            return true;
        }
        return false;
    }

    /**
     * 根据经纬度算出附近的正方形的四个角的经纬度
     * @param longitude 精度
     * @param latitude 纬度
     * @param distance 附近多少米
     * @return
     */
    public static Map<String, double[]> returnLLSquarePoint(double longitude, double latitude, double distance) {
        Map<String, double[]> squareMap = new HashMap();
        // 计算经度弧度,从弧度转换为角度
        double dLongitude = 2 * (Math.asin(Math.sin(distance / (2 * RADIUS)) / Math.cos(Math.toRadians(latitude))));
        dLongitude = Math.toDegrees(dLongitude);
        // 计算纬度角度
        double dLatitude = distance / RADIUS;
        dLatitude = Math.toDegrees(dLatitude);
        // 正方形
        double[] leftTopPoint = {longitude - dLongitude,latitude + dLatitude};
        double[] rightTopPoint = {longitude + dLongitude,latitude + dLatitude};
        double[] leftBottomPoint = {longitude - dLongitude,latitude - dLatitude};
        double[] rightBottomPoint = {longitude + dLongitude,latitude - dLatitude};
        squareMap.put("leftTopPoint", leftTopPoint);
        squareMap.put("rightTopPoint", rightTopPoint);
        squareMap.put("leftBottomPoint", leftBottomPoint);
        squareMap.put("rightBottomPoint", rightBottomPoint);
        return squareMap;
    }
    public static void main(String[] args) {
        BigDecimal totalFee = new BigDecimal("1.1234");
        System.out.println(totalFee);
        totalFee = MathUtil.setPrecision(totalFee);
        System.out.println(totalFee);

        String concat = "electric:too:low:alarm:key".concat(":").concat(":");
        System.out.println(concat);
    }
}
