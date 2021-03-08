package com.project.a;

import com.pojo.dto.StudentDTO;

public class Main2 {
    public static void main(String[] args) {
        StudentDTO studentDTO = new StudentDTO();
        String name = studentDTO.getName();
        System.out.println(name);
    }
    private String signatureByHaLuo(String appId, String timestamp, String nonceStr, String signKey) {
        //32位小写MD5值
        String sign = appId + timestamp + nonceStr + signKey;
//        return DigestUtils.md5DigestAsHex(sign.getBytes());
        return null;
    }
}
