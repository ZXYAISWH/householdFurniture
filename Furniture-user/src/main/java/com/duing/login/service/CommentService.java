package com.duing.login.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duing.login.dao.CommentDao;
import com.duing.login.dao.OrderDao;
import com.duing.login.dao.OrderFurnitureDao;
import com.duing.login.domain.F_furniture_comment;
import com.duing.login.domain.F_user_order;
import com.duing.login.domain.F_user_order_furniture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private OrderDao orderDao;


    @Autowired
    private OrderFurnitureDao orderFurnitureDao;

    /**
     * 获取所有未评论的家具
     *
     * @param account 用户的账号
     * @return 家具的信息
     */
    public List<HashMap<String, Object>> getUserAllWaitFurniture(String account) {
        //创建集合对象,存储信息
        List<HashMap<String, Object>> commentList = new ArrayList<>();
        //通过账号获取用户的id
        Integer uId = commentDao.selectUserId(account);
        //创建QueryWrapper对象
        QueryWrapper<F_user_order> wrapper = new QueryWrapper<>();
        //判断订单用户外键等于用户的id
        wrapper.eq("user_id", uId);
        //执行查询操作
        List<F_user_order> orders = orderDao.selectList(wrapper);
        System.out.println(orders);
        //循环获取
        comment:
        for (F_user_order order : orders) {
            //创建集合对象
            HashMap<String, Object> map = new HashMap<>();
            //获取属性
            Byte isComment = order.getIsComment();
            Byte isShip = order.getIsShip();
            System.out.println("@@" + isShip);
            //判断是否评论
            if (isComment == null || isComment == 1) {
                //判断是否收获
                if (isShip == 0) {
                    //获取属性
                    String orderNo = order.getOrderNo();
                    Integer orderId = order.getOrderId();
                    //通过订单的id查询订单家具信息
                    F_user_order_furniture furniture = orderFurnitureDao.selectOrderFurnitureByOrderId(orderId);
                    //获取数学系
                    Double Price = furniture.getFurniturePrice();
                    Integer furnitureId = furniture.getFurnitureId();
                    //通过家具的id查询家具的信息
                    HashMap<String, String> furnitureMap = orderDao.selectFurniture(furnitureId);
                    //获取属性
                    String imgUrl = furnitureMap.get("furniture_img");
                    String name = furnitureMap.get("furniture_name");
                    //往集合中赋值
                    map.put("orderNo", orderNo);
                    map.put("price", Price);
                    map.put("imgUrl", imgUrl);
                    map.put("name", name);
                    //添加至list集合中
                    commentList.add(map);
                } else {
                    //执行下一次循环
                    continue comment;
                }
            } else {
                //执行下一次循环
                continue comment;
            }
        }
        //返回集合对象
        return commentList;
    }


    /**
     * 获取所有未评论的家具
     *
     * @param account 用户的账号
     * @return 家具的信息
     */
    public List<HashMap<String, Object>> getUserAllYetFurniture(String account) {
        //创建集合对象,存储信息
        List<HashMap<String, Object>> commentList = new ArrayList<>();
        //通过账号获取用户的id
        Integer uId = commentDao.selectUserId(account);
        //创建QueryWrapper对象
        QueryWrapper<F_user_order> wrapper = new QueryWrapper<>();
        //判断订单用户外键等于用户的id
        wrapper.eq("user_id", uId);
        //执行查询操作
        List<F_user_order> orders = orderDao.selectList(wrapper);
        //循环获取订单
        for (F_user_order order : orders) {
            //创建集合对象
            HashMap<String, Object> map = new HashMap<>();
            //获取属性
            Byte isComment = order.getIsComment();
            //判断是否评论
            if (isComment != null && isComment == 0) {
                //获取属性
                String orderNo = order.getOrderNo();
                Integer orderId = order.getOrderId();
                //通过订单的id查询订单家具信息
                F_user_order_furniture furniture = orderFurnitureDao.selectOrderFurnitureByOrderId(orderId);
                //获取数学系
                Double Price = furniture.getFurniturePrice();
                Integer furnitureId = furniture.getFurnitureId();
                //通过家具的id查询家具的信息
                HashMap<String, String> furnitureMap = orderDao.selectFurniture(furnitureId);
                //获取属性
                String imgUrl = furnitureMap.get("furniture_img");
                String name = furnitureMap.get("furniture_name");
                //往集合中赋值
                map.put("orderNo", orderNo);
                map.put("price", Price);
                map.put("imgUrl", imgUrl);
                map.put("name", name);
                //添加至list集合中
                commentList.add(map);
            } else {
                //执行下一次循环
                continue;
            }
        }
        //返回集合
        return commentList;
    }


    /**
     * 家具评论
     *
     * @param score          评论的分数
     * @param commentContent 评论的内容
     * @param orderCode      家具的编号
     * @param account        用户的账号
     */
    public void furnitureComment(Integer score, String commentContent, String orderCode, String account) {
        //获取用户的id
        Integer uId = commentDao.selectUserId(account);
        //创建QueryWrapper对象
        QueryWrapper<F_user_order> wrapper = new QueryWrapper<>();
        //判断家具的编号和评论家具的编号相等
        wrapper.eq("order_no", orderCode);
        //执行查询操作
        F_user_order order = orderDao.selectOne(wrapper);
        //给属性赋值
        order.setIsComment(Byte.parseByte("0"));
        //执行修改操作
        orderDao.update(order, wrapper);
        //获取属性
        Integer orderId = order.getOrderId();
        //通过订单的id查询获取订单家具的信息
        F_user_order_furniture furniture = orderFurnitureDao.selectOrderFurnitureByOrderId(orderId);
        //获取属性
        Integer furnitureId = furniture.getFurnitureId();
        //创建评论对象
        F_furniture_comment comment = new F_furniture_comment();
        //给属性赋值
        comment.setUserId(uId);
        comment.setFurnitureCommentContent(commentContent);
        comment.setFurnitureCommentScores(Double.parseDouble(score + ""));
        comment.setFurnitureCommentTime(new Date());
        comment.setFurnitureId(furnitureId);
        //执行新增操作
        commentDao.insert(comment);
    }

}
