package com.duing.backstage.util;

import org.springframework.stereotype.Component;

/**
 * 随机家具编号的工具类
 */
@Component
@SuppressWarnings("all")
public final class RandomProductNumber {

    /**
     * 1-9 | a-z | A-Z
     */
    private String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * 随机生成商品ID
     *
     * @param count 生成的次数
     * @return 返回随机字符串
     */
    public String productID(int count) {
        //获取字符串的长度
        int length = allChar.length();
        //定义返回的值
        String product = "";
        //循环
        for (int i = 0; i < count; i++) {
            //随机一个int类型的数值
            int value = (int) (Math.random() * length);
            //获取字符串中的一个值
            char key = allChar.charAt(value);
            //拼接在一起
            product = product.concat(key + "");
        }
        //返回随机的值
        return "best" + product;
    }
}
