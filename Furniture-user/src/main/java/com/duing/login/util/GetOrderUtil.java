package com.duing.login.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duing.login.dao.OrderDao;
import com.duing.login.dao.OrderFurnitureDao;
import com.duing.login.domain.F_user_order;
import com.duing.login.domain.F_user_order_furniture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 获取订单的工具类
 */
@Component
public class GetOrderUtil {

    /**
     * 获取订单的dao层对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private OrderDao orderDao;

    /**
     * 获取订单家具的dao层对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private OrderFurnitureDao orderFurnitureDao;


    /**
     * 通过订单编号获取订单
     *
     * @param orderCode 订单编号
     */
    public F_user_order getOrderByOrderCode(String orderCode) {
        //创建QueryWrapper对象
        QueryWrapper<F_user_order> queryWrapper = new QueryWrapper<>();
        //查询订单编号和需要查询的订单编号相等的订单
        queryWrapper.eq("order_no", orderCode);
        //执行查询操作,并且返回数据
        return orderDao.selectOne(queryWrapper);
    }

    /**
     * 获取订单的信息
     *
     * @param orders
     * @return
     */
    public List<HashMap<String, Object>> getOrderInfo(List<F_user_order> orders) {
        //创建集合对象用来转载数据
        List<HashMap<String, Object>> orderList = new ArrayList<>();
        //循环获取订单
        for (F_user_order order : orders) {
            //创建map集合,装载订单的属性
            HashMap<String, Object> orderMap = new HashMap<>();
            //获取订单的id
            Integer orderId = order.getOrderId();
            //获取订单的属性
            Byte ship = order.getIsShip();
            Byte pay = order.getIsPay();
            String orderNo = order.getOrderNo();
            Date orderTime = order.getCreateTime();
            Byte isComment = order.getIsComment();
            //通过订单的id查询订单家具
            F_user_order_furniture furniture = orderFurnitureDao.selectOrderFurnitureByOrderId(orderId);
            //获取属性
            //获取订单家具属性
            Integer number = furniture.getFurnitureNumber();
            Double price = furniture.getFurniturePrice();
            String payType = furniture.getPayType();
            Integer furnitureId = furniture.getFurnitureId();
            //通过家具的id获取家具
            HashMap<String, String> map = orderDao.selectFurniture(furnitureId);
            //获取属性
            String furnitureName = map.get("furniture_name");
            String imgUrl = map.get("furniture_img");
            //往集合中添加值
            orderMap.put("orderNo", orderNo);
            orderMap.put("orderId", orderId);
            orderMap.put("isComment", isComment);
            orderMap.put("furnitureName", furnitureName);
            orderMap.put("ship", ship);
            orderMap.put("pay", pay);
            orderMap.put("orderTime", orderTime);
            orderMap.put("number", number);
            orderMap.put("price", price);
            orderMap.put("payType", payType);
            orderMap.put("imgUrl", imgUrl);
            //装入list集合中
            orderList.add(orderMap);
        }
        return orderList;
    }
}
