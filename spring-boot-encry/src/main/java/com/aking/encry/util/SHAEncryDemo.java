package com.aking.encry.util;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @ClassName SHAEncryDemo
 * @Description
 * @Author yk
 * @Date 2020/5/18 15:18
 * @Version 1.0
 **/
@Slf4j
public class SHAEncryDemo {
    /**
     *
     * @param data
     * @param shaN: SHA,SHA-1,SHA-224,SHA-256,SHA-384,SHA-512
     * @return
     * @throws Exception
     */
    public static byte[] encryptSHA(byte[] data, String shaN) throws Exception {

        MessageDigest sha = MessageDigest.getInstance(shaN);
        sha.update(data);
        return sha.digest();
    }

    public static String encryptFlychordPwd(String str) {
        byte[] outputData = new byte[0];
        try {
            outputData =  encryptSHA(str.getBytes(), "SHA-256");
            return new BigInteger(1, outputData).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        //加密123456
        log.info(encryptFlychordPwd("123456"));
    }
}
