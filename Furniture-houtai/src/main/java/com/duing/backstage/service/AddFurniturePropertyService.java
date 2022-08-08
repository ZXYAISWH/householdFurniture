package com.duing.backstage.service;

import com.duing.backstage.dao.AddFurniturePropertyDao;
import com.duing.backstage.domain.F_furniture_property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 做后台上传家具公共表的业务成
 * 做逻辑判断的
 *
 * @Service 说明这是一个业务成对象, 将这个控制层交给spring来管理, 底层实际用的是@Component注解,为了让层次分明,让调用者可读性强,就包装成@Service
 * @SuppressWarnings 不扫描本类规范
 */
@Service
@SuppressWarnings("all")
public class AddFurniturePropertyService {

    /**
     * 获取dao层的对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private AddFurniturePropertyDao addFurniturePropertyDao;

    /**
     * 添加公共属性
     *
     * @param furnitureId     家具的id
     * @param propertyKeyId   家具属性的id
     * @param propertyValueId 家具属性值的id
     */
    public void addProperty(Integer furnitureId, Integer propertyKeyId, Integer propertyValueId) {
        //创建实体类F_furniture_property对象
        F_furniture_property property = new F_furniture_property();
        //给属性赋值
        property.setPropertyKeyId(propertyKeyId);
        property.setPropertyValueId(propertyValueId);
        property.setFurnitureId(furnitureId);
        //执行新增操作
        addFurniturePropertyDao.insert(property);
    }
}
