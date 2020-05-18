package com.aking.encry.util;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;
import java.util.Arrays;

/**
 * @ClassName HMACDemo
 * @Description
 * @Author yk
 * @Date 2020/5/18 15:40
 * @Version 1.0
 **/
@Slf4j
public class HMACDemo {

    /**
     * 生成秘钥
     * @param hmacN: HmacMD5,HmacSHA1,HmacSHA256,HmacSHA384,HmacSHA512,HmacMD2,HmacMD4,HmacSHA224
     * @return
     * @throws Exception
     */
    public static byte[] initHmacKey(String hmacN) throws Exception {
        //加入BouncyCastleProvider的支持
        Security.addProvider(new BouncyCastleProvider());
        //初始化KeyGenerator
        KeyGenerator keyGenerator = KeyGenerator.getInstance(hmacN);
        //产生密钥
        SecretKey secretKey = keyGenerator.generateKey();
        //获取密钥
        return secretKey.getEncoded();
    }

    /**
     * Hmac消息摘要
     *
     * @param data 待做摘要处理的数据
     * @param key  密钥
     * @return byte[] 消息摘要
     * @return hmacN
     */
    public static byte[] encodeHmac(byte[] data, byte[] key, String hmacN) throws Exception {
        //加入BouncyCastleProvider的支持
        Security.addProvider(new BouncyCastleProvider());
        //还原密钥，因为密钥是以 byte 形式为消息传递算法所拥有
        SecretKey secretKey = new SecretKeySpec(key, hmacN);
        //实例化Mac
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        //初始化Mac
        mac.init(secretKey);
        //执行消息摘要处理
        return mac.doFinal(data);
    }

    /**
     * Hmac 消息摘要
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static String encodeHmacHex(byte[] data, byte[] key, String hmacN) throws Exception {
        //执行消息摘要处理
        byte[] b = encodeHmac(data, key, hmacN);
        //做十六进制转换
        return new String(Hex.encode(b));
    }


    public static void main(String[] args) throws Exception {
        String str = "Python大星";
        String hmacN1 = "HmacMD5";
        /**
         * 初始化密钥
         * byte[] key1 = HMACDemo.initHmacKey("HmacMD5")
         */
        byte[] key1 = new byte[]{-19, -23, 66, -95, 46, -62, 77, 91, -24, 39, 123, -43, -57, 72, 80, 74, -62, -119, 68, 24, 118, 41, -56, 126, -16, 100, 59, -64, 62, 100, 83, 51, -67, -71, -128, 33, -65, 29, 83, -123, 89, 69, -58, 105, -9, -58, 64, -41, -86, -14, -13, 84, -93, -99, 13, -13, 87, -108, -55, -61, -23, -51, 50, 124};

        log.info("初始化密钥：{}", key1);
        //获取摘要信息
        byte[] data1 = HMACDemo.encodeHmac(str.getBytes(), key1, hmacN1);
        String dataHex1 = new String(Hex.encode(data1));
        log.info("原文：" + str);
        // 0b81d2504769295d73417ed40c373ced
        log.info("BouncyCastle HmacMD5算法摘要 HEX：{}", dataHex1);
    }
}
