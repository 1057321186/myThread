package com.test;

import com.google.common.collect.Maps;
import com.pojo.dto.StudentDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestMain {
    public static void main(String[] args) {
//        StudentDTO  dto = new StudentDTO();
//        if (null == dto.getName()) {
//            System.out.println("true");
//        }
//        dto.setName("嘿嘿");
//        List<StudentDTO> list = new ArrayList<>();
//        list.add(dto);
//        list.add(dto);
//        List<String> collect = list.stream().map(x -> x.getName()).collect(Collectors.toList());
//        collect.forEach(x -> System.out.println(x));

        List<String> list = new ArrayList<>();

        String str = "asdfasd/dsd//";
        String s = checkQrCodeUrl(str);
        System.out.println(s);

        Map map = Maps.newHashMap();
        System.out.println(map.size());


    }



    static String checkQrCodeUrl(String url) {
        if (url.length() > 1) {
            char lostChar = url.charAt(url.length() - 1);
            if ("/".equals(String.valueOf(lostChar))) {
                String substring = url.substring(0, url.length() - 1);
                return substring;
            }

        }
        return url;
    }
}
