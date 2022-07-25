package com.zhuzhuhe.tools.util;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEByteEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Created with Intellij IDEA
 * @Author :
 * @Date : 2018/5/18 - 10:37
 * @Copyright (C), 2018-2018
 * @Descripition : Jasypt安全框架加密类工具包
 */
public class JasyptUtils {
    private static final String ALGORITHM_INFO = "PBEWithMD5AndDES";

    private static final String PASSWORD_INFO = "helloWorld!";

    @Autowired
    StringEncryptor stringEncryptor;

    /**
     * Jasypt生成加密结果
     *
     * @param password 配置文件中设定的加密密码 jasypt.encryptor.password
     * @param value    待加密值
     * @return
     */
    public static String encryptPwd(String password, String value) {
        PooledPBEStringEncryptor encryptOr = new PooledPBEStringEncryptor();
        encryptOr.setConfig(cryptOr(password));
        String result = encryptOr.encrypt(value);
        return result;
    }

    /**
     * 解密
     *
     * @param password 配置文件中设定的加密密码 jasypt.encryptor.password
     * @param value    待解密密文
     * @return
     */
    public static String decyptPwd(String password, String value) {
        PooledPBEStringEncryptor encryptOr = new PooledPBEStringEncryptor();
        encryptOr.setConfig(cryptOr(password));
        String result = encryptOr.decrypt(value);
        return result;
    }

    /**
     * @param password salt
     * @return
     */
    public static SimpleStringPBEConfig cryptOr(String password) {
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(password);
        config.setAlgorithm(StandardPBEByteEncryptor.DEFAULT_ALGORITHM);
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName(null);
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        return config;
    }

    public static String encryptPwd(String value) {
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        //配置文件中配置如下的算法
        standardPBEStringEncryptor.setAlgorithm(ALGORITHM_INFO);
        //配置文件中配置的password
        standardPBEStringEncryptor.setPassword(PASSWORD_INFO);
        //要加密的文本
        return standardPBEStringEncryptor.encrypt(value);


    }
    public static String decryptPwd(String value) {
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        //配置文件中配置如下的算法
        standardPBEStringEncryptor.setAlgorithm(ALGORITHM_INFO);
        //配置文件中配置的password
        standardPBEStringEncryptor.setPassword(PASSWORD_INFO);
        //要加密的文本
        return standardPBEStringEncryptor.decrypt(value);

    }

    public static void main(String[] args) {
        System.out.println(JasyptUtils.encryptPwd("Love6091!"));
        System.out.println(JasyptUtils.decryptPwd("FK5WC0R2mK6MoTQ+BtGrquJz9HbIesvF"));
    }
}
