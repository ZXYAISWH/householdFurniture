package com.duing.backstage.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duing.backstage.dao.AddFurniturePropertyValueDao;
import com.duing.backstage.domain.F_furniture_property_value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 做后台上传家具属性值的业务成
 * 做逻辑判断的
 *
 * @Service 说明这是一个业务成对象, 将这个控制层交给spring来管理, 底层实际用的是@Component注解,为了让层次分明,让调用者可读性强,就包装成@Service
 * @SuppressWarnings 不扫描本类规范
 */
@Service
@SuppressWarnings("all")
public class AddFurniturePropertyValueService {

    /**
     * 获取dao层的对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private AddFurniturePropertyValueDao addFurniturePropertyValueDao;

    /**
     * 添加家具属性值
     *
     * @param furniturePropertyValue
     * @param propertyId
     */
    public void addFurniturePropertyValue(String furniturePropertyValue, Integer propertyKeyId) {
        //创建属性值F_furniture_property_value对象
        F_furniture_property_value propertyValue = new F_furniture_property_value();
        //给属性赋值
        propertyValue.setPropertyKeyId(propertyKeyId);
        propertyValue.setPropertyValueTitle(furniturePropertyValue);
        //执行新增操作
        addFurniturePropertyValueDao.insert(propertyValue);
    }

    /**
     * 获取家具属性值ID
     *
     * @param propertyKeyId 属性ID
     * @return 属性值ID
     */
    public Integer getPropertyValueId(Integer propertyKeyId) {
        //创建QueryWrapper对象
        QueryWrapper<F_furniture_property_value> queryWrapper = new QueryWrapper<>();
        //列property_key_id的值等于propertyKeyId
        queryWrapper.eq("property_key_id", propertyKeyId);
        //执行查询操作
        F_furniture_property_value propertyValue = addFurniturePropertyValueDao.selectOne(queryWrapper);
        //返回属性值的id
        return propertyValue.getPropertyValueId();
    }
}
