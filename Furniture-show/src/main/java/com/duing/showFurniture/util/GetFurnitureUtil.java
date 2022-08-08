package com.duing.showFurniture.util;

import com.duing.showFurniture.dao.ShowFurnitureDao;
import com.duing.showFurniture.domain.F_furniture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取家具的工具类
 * 用来解决代码冗余
 */
@Component
public class GetFurnitureUtil {

    /**
     * 获取展示家具的dao层
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private ShowFurnitureDao showFurnitureDao;

    /**
     * 获取家具信息的方法
     * 用来解决代码冗余的问题
     *
     * @param furnitures 一些家具
     * @return 家具的详细信息
     */
    public List<Map<String, String>> getFurnitureInfo(List<F_furniture> furnitures) {
        //创建集合对象,用来存储数据
        List<Map<String, String>> listMap = new ArrayList();
        //循环随机获取家具
        for (F_furniture furniture : furnitures) {
            Map<String, String> furnitureMap = new HashMap<>();
            //获取一些随机商品的ID
            Integer furnitureId = furniture.getFurnitureId();
            //获取主图的url
            String imgUrl = furniture.getFurnitureImg();
            //获取家具的名称
            String furnitureName = furniture.getFurnitureName();
            //获取家具的价格
            Double price = showFurnitureDao.getFurniturePrice(furnitureId);
            //装入集合
            furnitureMap.put("id", furnitureId + "");
            furnitureMap.put("img", imgUrl);
            furnitureMap.put("name", furnitureName);
            furnitureMap.put("price", price + "");
            listMap.add(furnitureMap);
        }
        return listMap;
    }


}
