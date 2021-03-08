package com.util;

import com.alibaba.fastjson.JSONObject;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {
    public static final String DATETIME_FOMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String Mill_DATETIME_FORMAT_4_MONITOR = "yyyyMMdd HH:mm:ss";
    public static  String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FOMAT);
        return sdf.format(date);
    }

    public static Date parse(String time){
        SimpleDateFormat sdf = new SimpleDateFormat(Mill_DATETIME_FORMAT_4_MONITOR);
        Date date = null;
        try {
            date = sdf.parse(time);
        } catch (Exception e) {
            System.out.println("日期转换异常");
        }
        System.out.println(date);
        return date;
    }

    public static void main(String[] args) {

        parse("20210303 17:54:05");
//        System.out.println(formatDate(new Date(1609840000L)));
//
//        Map map = new HashMap();
//        map.put("a","1");
//        map.put("b","2");
//        map.put("v","3");
//        System.out.println(JSONObject.toJSONString(map));
//
//
//        String s = regInageToBase64String("http://10.10.1.200:8889/group1/M00/00/00/rBsAB16Fj-GAGsD7AAEsjxA4zGo437.jpg");
//        System.out.println(s);
//        Date monthDateAfter = getMonthDateAfter(new Date(), 1);
//        String s = formatDate(monthDateAfter);
//        System.out.println(s);
    }

    public static Date getMonthDateAfter(Date startDate,Integer number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.MONTH,number);
        Date date = calendar.getTime();
        return date;
    }
    /**
     *
     * @param imgUrl
     * @return
     */
    public static  String regInageToBase64String(String imgUrl) {
        URL url = null;
        InputStream is = null;
        ByteArrayOutputStream outStream = null;
        HttpURLConnection httpUrl = null;
        try {
            url = new URL(imgUrl);
            httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            httpUrl.getInputStream();
            is = httpUrl.getInputStream();

            outStream = new ByteArrayOutputStream();
            //创建一个Buffer字符串
            byte[] buffer = new byte[1024];
            //每次读取的字符串长度，如果为-1，代表全部读取完毕
            int len = 0;
            //使用一个输入流从buffer里把数据读取出来
            while ((len = is.read(buffer)) != -1) {
                //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
                outStream.write(buffer, 0, len);
            }
            // 对字节数组Base64编码
            return new BASE64Encoder().encode(outStream.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outStream != null) {
                try {
                    outStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpUrl != null) {
                httpUrl.disconnect();
            }
        }
        return imgUrl;
    }
}
