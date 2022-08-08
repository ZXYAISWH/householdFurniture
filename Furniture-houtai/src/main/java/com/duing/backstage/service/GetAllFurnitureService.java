package com.duing.backstage.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.duing.backstage.dao.AddFurnitureDao;
import com.duing.backstage.dao.AddFurnitureInventoryDao;
import com.duing.backstage.dao.AddFurnitureTypeDao;
import com.duing.backstage.domain.F_furniture;
import com.duing.backstage.domain.F_furniture_classify;
import com.duing.backstage.domain.F_furniture_inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GetAllFurnitureService {

    /**
     * 获取dao层对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private AddFurnitureDao addFurnitureDao;

    /**
     * 获取dao层对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private AddFurnitureInventoryDao addFurnitureInventoryDao;

    /**
     * 获取dao层对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private AddFurnitureTypeDao addFurnitureTypeDao;


    /**
     * 获取所有的家具
     */
    public List<Map<String, Object>> getAllFurniture() {
        //创建集合对象
        List<Map<String, Object>> furnitureList = new ArrayList<>();
        //获取所有的家具
        List<F_furniture> furnitures = addFurnitureDao.selectList(null);
        //循环获取家具所有信息
        for (F_furniture furniture : furnitures) {
            //调用通用代码的方法
            Map<String, Object> oneFurnitureInfo = getOneFurnitureInfo(furniture);
            //添加至集合
            furnitureList.add(oneFurnitureInfo);
        }
        return furnitureList;
    }

    /**
     * 获取家具的详细信息
     *
     * @param id 家具id
     * @return 家具的信息
     */
    public Map<String, Object> getFurnitureInfo(Integer id) {
        //通过家具查询家具
        F_furniture furniture = addFurnitureDao.selectById(id);
        //调用通用代码的方法
        return getOneFurnitureInfo(furniture);
    }

    /**
     * 公共代码
     *
     * @param furniture 家具对象
     * @return 家具的信息
     */
    public Map<String, Object> getOneFurnitureInfo(F_furniture furniture) {
        //创建集合对象
        Map<String, Object> furnitureMap = new HashMap<>();
        //获取属性
        Integer furnitureId = furniture.getFurnitureId();
        String furnitureName = furniture.getFurnitureName();
        Date addTime = furniture.getAddTime();
        Integer clicks = furniture.getClicks();
        Byte status = furniture.getStatus();
        String keyWord = furniture.getKeyWord();
        String description = furniture.getDescription();
        //创建QueryWrapper多对象
        QueryWrapper<F_furniture_inventory> queryWrapper = new QueryWrapper();
        //判断家具的id等于库存的id
        queryWrapper.eq("furniture_id", furnitureId);
        //执行查询操作
        F_furniture_inventory furnitureInventory = addFurnitureInventoryDao.selectOne(queryWrapper);
        //获取属性
        Double furniturePrice = furnitureInventory.getFurniturePrice();
        Integer inventory = furnitureInventory.getFurnitureInventory();
        //装入集合中
        furnitureMap.put("furnitureId", furnitureId);
        furnitureMap.put("furnitureName", furnitureName);
        furnitureMap.put("addTime", addTime);
        furnitureMap.put("clicks", clicks);
        furnitureMap.put("furniturePrice", furniturePrice);
        furnitureMap.put("inventory", inventory);
        furnitureMap.put("status", status);
        furnitureMap.put("keyWord", keyWord);
        furnitureMap.put("description", description);
        //返回集合对象
        return furnitureMap;
    }

    /**
     * 用来下架家具
     *
     * @param id 家具的id
     */
    public void soldOutFurniture(Integer id) {
        //调用dao层的方法
        addFurnitureDao.soldOutFurniture(id);
    }

    /**
     * 用来上架家具
     *
     * @param id 家具的id
     */
    public void soldInFurniture(Integer id) {
        //调用dao层的方法
        addFurnitureDao.soldInFurniture(id);
    }

    /**
     * 用来删除家具
     *
     * @param id 家具的id
     */
    public void deleteFurniture(Integer id) {
        //调用dao层的方法
        addFurnitureDao.deleteFurniture(id);
    }

    /**
     * 修改家具信息的方法
     *
     * @param furniture 家具信息对象
     * @param inventory 家具库存对象
     */
    public void updateFurnitureInfo(F_furniture furniture, F_furniture_inventory inventory) {
        //创建UpdateWrapper对象
        UpdateWrapper<F_furniture> wrapperFurniture = new UpdateWrapper<>();
        UpdateWrapper<F_furniture_inventory> wrapperInventory = new UpdateWrapper<>();
        //判断修改的id和需要修的家具id一致
        wrapperFurniture.eq("furniture_id", furniture.getFurnitureId());
        wrapperInventory.eq("furniture_id", furniture.getFurnitureId());
        //执行修改操作
        addFurnitureDao.update(furniture, wrapperFurniture);
        addFurnitureInventoryDao.update(inventory, wrapperInventory);
    }

    /**
     * 获取所有家具的类型
     *
     * @return 所有家具的类型
     */
    public List<String> getAllFurnitureType() {
        //创建集合对象,获取所有家具的类型
        List<String> listType = new ArrayList<>();
        //获取所有家具类型的信息
        List<F_furniture_classify> classifies = addFurnitureTypeDao.selectList(null);
        //循环获取
        for (F_furniture_classify classify : classifies) {
            //获取家具的类型
            String type = classify.getClassifyName();
            //装入集合中
            listType.add(type);
        }
        //返回集合
        return listType;
    }

    /**
     * 通过家具类型获取家具
     *
     * @param type 家具的类型
     * @return 属于家具类型的家具
     */
    public List<Map<String, Object>> getFurnitureByType(String type) {
        //创建集合对象
        List<Map<String, Object>> furnitureList = new ArrayList<>();
        if ("全部家具".equals(type)) {
            //获取所有的家具
            List<F_furniture> furnitures = addFurnitureDao.selectList(null);
            //循环获取家具所有信息
            for (F_furniture furniture : furnitures) {
                //调用通用代码的方法
                Map<String, Object> oneFurnitureInfo = getOneFurnitureInfo(furniture);
                //添加至集合
                furnitureList.add(oneFurnitureInfo);
            }
        } else {
            //创建QueryWrapper对象
            QueryWrapper<F_furniture_classify> wrapperClassify = new QueryWrapper<>();
            QueryWrapper<F_furniture> wrapperFurniture = new QueryWrapper<>();
            //判断选择的家具类型等于数据库列的类型
            wrapperClassify.eq("classify_name",type);
            //执行查询操作
            F_furniture_classify  classify = addFurnitureTypeDao.selectOne(wrapperClassify);
            //判断家具的列等于需要查询类型的家具的列
            wrapperFurniture.eq("classify_id",classify.getClassifyId());
            //查询所有数据这种类型的家具
            List<F_furniture> furnitures = addFurnitureDao.selectList(wrapperFurniture);
            //循环获取家具所有信息
            for (F_furniture furniture : furnitures) {
                //调用通用代码的方法
                Map<String, Object> oneFurnitureInfo = getOneFurnitureInfo(furniture);
                //添加至集合
                furnitureList.add(oneFurnitureInfo);
            }
        }
        return furnitureList;
    }
}
