package com.duing.login.util;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class OrderCodeUtils {

    /**
     * 生成编号(当前日期后六位+4位随机数组成)
     *
     * @return
     * @throws Exception
     */
    public String createOrderCode(Date date) {

        //生成格式化日期为"yymmdd"
        DateFormat format = new SimpleDateFormat("yyMMdd");
        if (null == date) {
            date = new Date();
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append(format.format(date));
        String code = buffer.toString();

        //随机生成四位数
        String timeMillis = System.currentTimeMillis() + "";
        String randomNum = timeMillis.substring(timeMillis.length() - 4);

        //生成订单编号
        String orderCode = code + randomNum;

        return orderCode;
    }

    /**
     * 随机生成年月日时分秒+随机3位数的退款单号
     *
     * @return
     */
    public String getRandomFileName() {
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmSS");
        Date date = new Date();
        String str = simpleDateFormat.format(date);
        int i = (int) (Math.random() * 900 + 100);
        System.out.println(i);
        return "TK" + str + i;
    }

    public String createTrackingNumber(Date date) {
        //生成格式化日期为"yymmdd"
        DateFormat format = new SimpleDateFormat("yyMMdd");
        if (null == date) {
            date = new Date();
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append(format.format(date));
        String code = buffer.toString();

        //随机生成四位数
        String timeMillis = System.currentTimeMillis() + "";
        String randomNum = timeMillis.substring(timeMillis.length() - 6);

        //生成订单编号
        String orderCode = code + randomNum;

        return orderCode;
    }

}

