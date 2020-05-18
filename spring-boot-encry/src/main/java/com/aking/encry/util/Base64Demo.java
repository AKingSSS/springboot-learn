package com.aking.encry.util;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

/**
 * @ClassName Base64Demo
 * @Description
 * @Author yk
 * @Date 2020/5/18 11:52
 * @Version 1.0
 **/
@Slf4j
public class Base64Demo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // 使用基本编码
        String base64encodedString =
                Base64.getEncoder().encodeToString("Python大星".getBytes());
        log.info("Base64 编码字符串 (基本) : {}", base64encodedString);
        // 解码
        byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
        log.info("原始字符串: {}", new String(base64decodedBytes, "utf-8"));
        // Base64 编码字符串 (URL)
        String urlEncodedBytes = Base64.getEncoder().encodeToString("Python大星".getBytes());
        log.info("Base64 编码字符串 (URL) : {}", urlEncodedBytes);
        // Base64 编码字符串 (MIME)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(UUID.randomUUID().toString());
        }
        String mimeEncodedString = Base64.getMimeEncoder().encodeToString(sb.toString().getBytes());
        System.out.println("Base64 编码字符串 (MIME) :" + mimeEncodedString);
    }
}
