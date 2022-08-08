package com.duing.backstage.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duing.backstage.dao.AddFurnitureTypeDao;
import com.duing.backstage.domain.F_furniture_classify;
import com.duing.backstage.util.RandomProductNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 做后台上传家具类型的的业务成
 * 做逻辑判断的
 *
 * @Service 说明这是一个业务成对象, 将这个控制层交给spring来管理, 底层实际用的是@Component注解,为了让层次分明,让调用者可读性强,就包装成@Service
 * @SuppressWarnings 不扫描本类规范
 */
@Service
@SuppressWarnings("all")
public class AddFurnitureTypeService {

    /**
     * 获取dao层的对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private AddFurnitureTypeDao addFurnitureTypeDao;

    /**
     * 获取随机商品编号的工具类对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private RandomProductNumber randomProductNumber;

    /**
     * 添加家具类型
     *
     * @param furnitureTypeName 类型名称
     * @return 添加结果
     */
    public String addFurnitureType(String furnitureTypeName) {
        //创建F_furniture_classify实体类对象
        F_furniture_classify classify = new F_furniture_classify();
        //放入类型的名称
        classify.setClassifyName(furnitureTypeName);
        //放入创建的当前时间
        classify.setClassifyAddTime(new Date(System.currentTimeMillis()));
        //放入库存
        classify.setClassifyInventory(0);
        //调用dao层添加的方法
        int count = addFurnitureTypeDao.insert(classify);
        //对数据库受影响的行数金进行判断
        if (count != 0) {
            //返回添加成功
            return "添加成功";
        } else {
            //返回添加失败
            return "添加失败";
        }
    }

    /**
     * 获取所有的家具类型
     *
     * @return 家具的类型
     */
    public List<String> getAllFurnitureType() {
        //获取所有的商品类型
        List<F_furniture_classify> classifies = addFurnitureTypeDao.selectList(null);
        //创建集合对象,用来储存商品类型的
        List<String> types = new ArrayList<>();
        //循环获取商品类型对象
        for (F_furniture_classify classify : classifies) {
            //获取每个商品类型对象的商品
            types.add(classify.getClassifyName());
        }
        //返回集合对象
        return types;
    }

    /**
     * 通过家具的类型,获取家具类型的Id
     *
     * @return 家具类型的ID
     */
    public Integer getFuritureTypeId(String classifyType) {
        //创建QueryWrapper对象
        QueryWrapper<F_furniture_classify> queryWrapper = new QueryWrapper<>();
        //判断classify_name的值等于type
        queryWrapper.eq("classify_name", classifyType);
        //调取mybatisPlus的查询单条的方法,返回家具类型的对象
        F_furniture_classify classify = addFurnitureTypeDao.selectOne(queryWrapper);
        //返回家具类型的ID
        return classify.getClassifyId();
    }
}
