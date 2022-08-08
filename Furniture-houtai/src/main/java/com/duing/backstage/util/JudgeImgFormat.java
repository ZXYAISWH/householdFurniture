package com.duing.backstage.util;

import org.springframework.stereotype.Component;

/**
 * 判断图片的格式
 *
 * @Component 将这个工具类交给spring来管理
 */
@Component
@SuppressWarnings("all")
public final class JudgeImgFormat {

    /**
     * 判图片是否符合图片的格式
     *
     * @param imgName 图片的名称
     * @return 是否符合
     */
    public Boolean conformFormatToImg(String imgName) {
        //判断格式
        if (imgName.contains(".png") || imgName.contains(".jpg") || imgName.contains(".gif") || imgName.contains(".bmp") || imgName.contains(".jpeg") || imgName.contains(".pdf")) {
            //符合返回true
            return true;
        } else {
            //不符合返回false
            return false;
        }
    }

    /**
     * 组合新的图片路径
     *
     * @param urlValue 随机图片的名称
     * @param endValue 图片结尾的格式
     * @return 图片的全名
     */
    public String mainImgAllUrl(String urlValue, String endValue) {
        return urlValue + endValue;
    }
}
