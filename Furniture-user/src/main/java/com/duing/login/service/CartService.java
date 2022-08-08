package com.duing.login.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duing.login.dao.CartDao;
import com.duing.login.dao.OrderDao;
import com.duing.login.domain.F_user_shopping_car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class CartService {

    /**
     * 获取添加购物车的dao层对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private CartDao cartDao;

    /**
     * 获取订单的dao层对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private OrderDao orderDao;

    /**
     * 添加购物车
     *
     * @param id      家具的id
     * @param number  订单家具的数量
     * @param account 用户的账号
     */
    public void addCart(Integer id, Integer number, String account) {
        //通过账号获取用户的id
        Integer userId = orderDao.getUserId(account);
        //创建购物车对象
        F_user_shopping_car car = new F_user_shopping_car();
        //给属性赋值
        car.setUserId(userId);
        car.setFurnitureId(id);
        car.setCreateTime(new Date());
        car.setFurnitureNumber(number);
        //执行新增操作
        cartDao.insert(car);
    }


    /**
     * 获取用户购物车的方法
     *
     * @param account 用户的账号
     * @return 家具的信息
     */
    public List<HashMap<String, Object>> getAllCarFurniture(String account) {
        //创建集合对象,用来储存家具信息
        List<HashMap<String, Object>> listCart = new ArrayList<>();
        //通过账号获取用户的id
        Integer userId = orderDao.getUserId(account);
        //创建QueryWrapper对象
        QueryWrapper<F_user_shopping_car> wrapper = new QueryWrapper<>();
        //判断购物车的用户等于用户的id
        wrapper.eq("user_id", userId);
        //执行查询操作
        List<F_user_shopping_car> f_user_shopping_cars = cartDao.selectList(wrapper);
        //循环获取
        for (F_user_shopping_car car : f_user_shopping_cars) {
            //创建集合对象,用来储存家具属性
            HashMap<String, Object> mapCart = new HashMap<>();
            //获取属性
            Integer furnitureId = car.getFurnitureId();
            Integer number = car.getFurnitureNumber();
            Integer carId = car.getCarId();
            //通过家具的id,获取家具的信息
            HashMap<String, String> map = orderDao.selectFurniture(furnitureId);
            //获取属性
            String name = map.get("furniture_name");
            String imgUrl = map.get("furniture_img");
            //通过家具的id查询家具详情信息
            HashMap<String, Integer> furnitureDetailMap = orderDao.selectFurnitureDetail(furnitureId);
            //获取属性
            Integer propertyKeyId = furnitureDetailMap.get("property_key_id");
            Integer propertyValueId = furnitureDetailMap.get("property_value_id");
            //通过属性的id获取属性的信息
            HashMap<String, String> propertyKeyMap = orderDao.selectPropertyKey(propertyKeyId);
            //通过属性值的id获取属性值的信息
            HashMap<String, String> propertyValueMap = orderDao.selectPropertyValue(propertyValueId);
            //获取属性
            String propertyKey = propertyKeyMap.get("property_key_title");
            String propertyValue = propertyValueMap.get("property_value_title");
            //执行查询操作,查询家具的价格
            Double price = cartDao.selectFurniturePrice(furnitureId);
            //往集合中赋值
            mapCart.put("number", number);
            mapCart.put("furnitureId", furnitureId);
            mapCart.put("carId", carId);
            mapCart.put("name", name);
            mapCart.put("imgUrl", imgUrl);
            mapCart.put("propertyKey", propertyKey);
            mapCart.put("propertyValue", propertyValue);
            mapCart.put("price", price);
            //添加至集合
            listCart.add(mapCart);
        }
        //返回
        return listCart;
    }

    /**
     * 删除购物车信息
     *
     * @param cartId 购物车的id
     */
    public void deleteCartFurniture(Integer cartId) {
        //执行删除操作
        cartDao.deleteById(cartId);
    }
}
