package com.duing.backstage.service;

import com.duing.backstage.dao.AddFurnitureDetailDao;
import com.duing.backstage.domain.F_furniture_detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 做后台上传家具详情的的业务成
 * 做逻辑判断的
 *
 * @Service 说明这是一个业务成对象, 将这个控制层交给spring来管理, 底层实际用的是@Component注解,为了让层次分明,让调用者可读性强,就包装成@Service
 * @SuppressWarnings 不扫描本类规范
 */
@Service
@SuppressWarnings("all")
public class AddFurnitureDetailService {

    /**
     * 获取dao层的对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private AddFurnitureDetailDao addFurnitureDetailDao;

    /**
     * 添加家具详情
     *
     * @param furnitureKey   属性名
     * @param furnitureValue 属性值
     * @param furnitureId    家具的ID
     */
    public void addFurnitureDetail(String furnitureKey, String furnitureValue, Integer furnitureId) {
        //创建家具详情F_furniture_detail对象
        F_furniture_detail furnitureDetail = new F_furniture_detail();
        //给属性赋值
        furnitureDetail.setFurnitureId(furnitureId);
        furnitureDetail.setFurnitureDetailContexts(furnitureKey + ":" + furnitureValue);
        //执行新增操作
        addFurnitureDetailDao.insert(furnitureDetail);
    }
}
