package com.duing.login.util;

import org.jasypt.properties.PropertyValueEncryptionUtils;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.stereotype.Component;

/**
 * 加密的工具类
 *
 * @Component 将这个工具类交给spring管理
 * @SuppressWarnings 不扫描本类规范
 */
@Component
@SuppressWarnings("all")
public final class JasyptUtil {

    /**
     * 创建加密文本对象
     */
    private static BasicTextEncryptor textEncryptor = new BasicTextEncryptor();

    /**
     * 创建加密密码对象
     */
    private static BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();

    /**
     * 优先加载密文
     */
    static {
        //设计加密的值
        textEncryptor.setPassword("duing");
    }

    /**
     * 对文本进行解密
     *
     * @return 解密后的结果
     */
    public String decryptText(String value) {
        //变成jasypt解密的格式
        value = "ENC(" + value + ")";
        //判断是否属于解密类型
        Boolean flag = PropertyValueEncryptionUtils.isEncryptedValue(value);
        //如果是属于解密的类型
        if (flag) {
            //返回解密后的值
            return PropertyValueEncryptionUtils.decrypt(value, textEncryptor);
        }
        //如果不属于解密的类型,就返回空
        return "";
    }

    /**
     * 对文本进行加密
     *
     * @return 解密后的结果
     */
    public String encryptText(String value) {
        //返回加密后的值
        return textEncryptor.encrypt(value);
    }

    /**
     * 对密码进行加密
     *
     * @param password 需要加密的密码
     * @return 加密后的结果
     */
    public String encryptPassword(String password) {
        //加密后的结果
        return passwordEncryptor.encryptPassword(password);
    }

    /**
     * @param password        没有加密的密码
     * @param encryptPassword 加密后的密码
     * @return
     */
    public Boolean checkPassword(String password, String encryptPassword) {
        //返回加密和没有加密的密码是否相等
        return passwordEncryptor.checkPassword(password, encryptPassword);
    }

}
