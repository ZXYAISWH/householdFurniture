package com.duing.backstage.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duing.backstage.dao.AddFurniturePropertyKeyDao;
import com.duing.backstage.domain.F_furniture_property_key;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 做后台上传家具属性的业务成
 * 做逻辑判断的
 *
 * @Service 说明这是一个业务成对象, 将这个控制层交给spring来管理, 底层实际用的是@Component注解,为了让层次分明,让调用者可读性强,就包装成@Service
 * @SuppressWarnings 不扫描本类规范
 */
@Service
@SuppressWarnings("all")
public class AddFurniturePropertyKeyService {

    /**
     * 获取dao层的对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private AddFurniturePropertyKeyDao addFurniturePropertyKeyDao;

    /**
     * 添加家具属性值
     *
     * @param furniturePropertyKey 属性值
     * @param furnitureId          家具的Id
     */
    public void addFurniturePropertyKey(String furniturePropertyKey, Integer furnitureId) {
        //创建家具属性值F_furniture_property_key对象
        F_furniture_property_key propertyKey = new F_furniture_property_key();
        //给属性赋值
        propertyKey.setFurnitureId(furnitureId);
        propertyKey.setPropertyKeyTitle(furniturePropertyKey);
        //执行新增操作
        addFurniturePropertyKeyDao.insert(propertyKey);
    }

    /**
     * 获取属性的Id
     *
     * @param furnitureId 家具的id
     * @return 属性的id
     */
    public Integer getPropertyId(Integer furnitureId) {
        //创建QueryWrapper对象
        QueryWrapper<F_furniture_property_key> queryWrapper = new QueryWrapper<>();
        //判断列furniture_id等于家具Id
        queryWrapper.eq("furniture_id", furnitureId);
        //通过id查询
        F_furniture_property_key propertyKey = addFurniturePropertyKeyDao.selectOne(queryWrapper);
        //返回属性的Id
        return propertyKey.getPropertyKeyId();
    }
}
