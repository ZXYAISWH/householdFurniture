package com.duing.backstage.service;

import com.duing.backstage.dao.AddFurnitureInventoryDao;
import com.duing.backstage.domain.F_furniture_inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 做后台上传家具库存的的业务成
 * 做逻辑判断的
 *
 * @Service 说明这是一个业务成对象, 将这个控制层交给spring来管理, 底层实际用的是@Component注解,为了让层次分明,让调用者可读性强,就包装成@Service
 * @SuppressWarnings 不扫描本类规范
 */
@Service
@SuppressWarnings("all")
public class AddFurnitureInventoryService {

    /**
     * 获取dao层的对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private AddFurnitureInventoryDao addFurnitureInventoryDao;

    /**
     * 添加家具的库存
     *
     * @param price       家具的价格
     * @param inventory   家具的库存
     * @param furnitureId 家具的id
     */
    public void addFurnitureInventory(String price, String inventory, Integer furnitureId) {
        //创建实体类furnitureInventory对象
        F_furniture_inventory furnitureInventory = new F_furniture_inventory();
        //给属性赋值
        furnitureInventory.setFurnitureInventory(Integer.parseInt(inventory));
        furnitureInventory.setFurniturePrice(Double.parseDouble(price));
        furnitureInventory.setFurnitureId(furnitureId);
        //执行新增操作
        addFurnitureInventoryDao.insert(furnitureInventory);
    }
}
