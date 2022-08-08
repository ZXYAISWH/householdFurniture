package com.duing.login.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duing.login.dao.AddressDao;
import com.duing.login.dao.OrderDao;
import com.duing.login.dao.OrderFurnitureDao;
import com.duing.login.dao.OrderLogisticsDao;
import com.duing.login.domain.*;
import com.duing.login.util.GetOrderUtil;
import com.duing.login.util.OrderCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
@SuppressWarnings("all")
public class OrderService {

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
     * 获取订单编号工具类对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private OrderCodeUtils orderCodeUtils;

    /**
     * 获取订单工具类对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private GetOrderUtil getOrderUtil;


    /**
     * 获取地址dao层对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private AddressDao addressDao;

    /**
     * 获取物流层对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private OrderLogisticsDao orderLogisticsDao;

    /**
     * 获取所有用户的收获地址
     *
     * @param account 用户的账号
     * @return 所有的地址对象
     */
    public List<F_user_address> getUserAllAddress(String account) {
        //通过用户的账号获取id
        Integer uId = orderDao.getUserId(account);
        //通过id查询所有的收货地址,并返回
        return orderDao.getUserAddress(uId);
    }

    /**
     * 订单购买家具的详细信息
     *
     * @param id      购买家具的id
     * @param price   购买家具的价格
     * @param number  购买家具的数量
     * @param account 用户的账号
     * @return 家具的编号
     */
    public String orderFurnitureDetailInfo(String id, String price, String number, String account) {
        //通过账号获取用户的id
        Integer uId = orderDao.getUserId(account);
        //创建日期对象
        Date date = new Date();
        //获取随机的家具订单编号
        String orderCode = orderCodeUtils.createOrderCode(date);
        //创建用户订单对象
        F_user_order userOrder = new F_user_order();
        //给属性赋值
        userOrder.setCreateTime(date);
        userOrder.setOrderNo(orderCode);
        userOrder.setIsPay(Byte.parseByte("1"));
        userOrder.setUserId(uId);
        //执行新增操作
        orderDao.insert(userOrder);
        //创建QueryWrapper对象
        QueryWrapper<F_user_order> queryWrapper = new QueryWrapper<>();
        //判断订单编号和随机订单编号相等的数据
        queryWrapper.eq("order_no", orderCode);
        //执行查询操作
        F_user_order order = orderDao.selectOne(queryWrapper);
        //获取订单的id
        Integer orderId = order.getOrderId();
        //创建订单家具对象
        F_user_order_furniture orderFurniture = new F_user_order_furniture();
        //给属性赋值
        orderFurniture.setOrderId(orderId);
        orderFurniture.setFurnitureNumber(Integer.parseInt(number));
        orderFurniture.setCreateTime(date);
        orderFurniture.setFurnitureId(Integer.parseInt(id));
        orderFurniture.setFurniturePrice(Double.parseDouble(price));

        //执行新增操作
        orderFurnitureDao.insert(orderFurniture);
        //通过订单的id查询订单家具,获取家具对象
        F_user_order_furniture furniture = orderFurnitureDao.selectOrderFurnitureByOrderId(orderId);
        //创建订单物流对象
        F_user_order_logistics logistics = new F_user_order_logistics();
        //给属性赋值
        logistics.setOrderFurnitureId(furniture.getOrderFurnitureId());
        //执行新增操作
        orderLogisticsDao.insert(logistics);
        //返回订单编号
        return orderCode;
    }

    /**
     * 获取订单详细信息的方法
     *
     * @param orderCode 订单的编号
     * @return 订单信息
     */
    public HashMap<String, Object> getOrderDetail(String orderCode) {
        //创建集合对象,用来储存订单信息
        HashMap<String, Object> orderInfo = new HashMap<>();
        //调用工具类通过订单编号查询订单的方法
        F_user_order order = getOrderUtil.getOrderByOrderCode(orderCode);
        //获取订单的id
        Integer orderId = order.getOrderId();
        //通过订单的id,获取订单家具的信息
        F_user_order_furniture orderFurniture = orderFurnitureDao.selectOrderFurnitureByOrderId(orderId);
        //获取订单的数量
        Integer number = orderFurniture.getFurnitureNumber();
        //获取订单的家具价格
        Double price = orderFurniture.getFurniturePrice();
        //获取家具的id
        Integer furnitureId = orderFurniture.getFurnitureId();
        //通过家具的id查询家具的信息
        HashMap<String, String> furnitureMap = orderDao.selectFurniture(furnitureId);
        //获取到家具的大图url
        String imgUrl = furnitureMap.get("furniture_img");
        //获取家具的名称
        String furnitureName = furnitureMap.get("furniture_name");
        //通过家具的id查询家具的属性
        HashMap<String, Integer> furnitureDetailMap = orderDao.selectFurnitureDetail(furnitureId);
        //获取属性key的id
        Integer propertyKeyId = furnitureDetailMap.get("property_key_id");
        //获取属性value的id
        Integer propertyValueId = furnitureDetailMap.get("property_value_id");
        //通过属性key的id,查询属性表
        HashMap<String, String> propertyKeyMap = orderDao.selectPropertyKey(propertyKeyId);
        //通过属性value的id,查询属性值表
        HashMap<String, String> propertyValueMap = orderDao.selectPropertyValue(propertyValueId);
        //获取属性
        String propertyKey = propertyKeyMap.get("property_key_title");
        //获取属性值
        String propertyValue = propertyValueMap.get("property_value_title");
        //将数据装入集合对象
        orderInfo.put("orderCode", orderCode);
        orderInfo.put("number", number);
        orderInfo.put("price", price);
        orderInfo.put("imgUrl", imgUrl);
        orderInfo.put("furnitureName", furnitureName);
        orderInfo.put("propertyKey", propertyKey);
        orderInfo.put("propertyValue", propertyValue);
        //返回集合
        return orderInfo;
    }

    /**
     * 订单支付
     *
     * @param code      家具的编号
     * @param addressId 地址的id
     * @param payType   支付的类型
     * @param price     支付家具的价格
     */
    public AliPayBean orderFurniturePay(String code, Integer addressId, String payType, Double price) {
        //创建对象
        AliPayBean alipayBean = new AliPayBean();
        //创建日期对象
        Date date = new Date();
        //通过地址的id,获取地址的信息
        F_user_address address = addressDao.selectById(addressId);
        //创建QueryWrapper对象
        QueryWrapper<F_user_order> queryWrapper = new QueryWrapper<>();
        //查询订单编号和需要查询的订单编号相等的订单
        queryWrapper.eq("order_no", code);
        //执行查询操作,并且返回数据
        F_user_order order = orderDao.selectOne(queryWrapper);
        //获取订单的id
        Integer orderId = order.getOrderId();
        //给属性赋值
        order.setPayPrice(price);
        order.setIsPay(Byte.parseByte("0"));
        order.setPayTime(date);
        order.setTurnoverTime(date);
        order.setIsShip(Byte.parseByte("1"));
        order.setShipNumber(orderCodeUtils.createTrackingNumber(date));
        //执行修改操作
        orderDao.update(order, queryWrapper);
        //通过订单id查询订单家具信息
        F_user_order_furniture furniture = orderFurnitureDao.selectOrderFurnitureByOrderId(orderId);
        System.out.println("数量:" + furniture.getFurnitureNumber());
        System.out.println("id:" + furniture.getFurnitureId());
        //调用dao层添加销量的方法
        orderDao.addClicks(furniture.getFurnitureNumber(), furniture.getFurnitureId());
        //减少家具的库存
        orderDao.reduceInventory(furniture.getFurnitureNumber(), furniture.getFurnitureId());
        //获取家具的信息
        HashMap<String, String> furnitureMap = orderDao.selectFurniture(furniture.getFurnitureId());
        //创建QueryWrapper对象
        QueryWrapper<F_user_order_furniture> queryWrapper1 = new QueryWrapper<>();
        //判断订单的id等于查询订单家具的id
        queryWrapper1.eq("order_id", orderId);
        //设置支付类型
        furniture.setPayType(payType);
        //执行修改操作
        orderFurnitureDao.update(furniture, queryWrapper1);
        //创建QueryWrapper对象
        QueryWrapper<F_user_order_logistics> queryWrapper2 = new QueryWrapper<>();
        //判断物流的家具的外键等于订单家具的主键
        queryWrapper2.eq("order_furniture_id", furniture.getOrderFurnitureId());
        //创建物流订单
        F_user_order_logistics logistics = new F_user_order_logistics();
        //给属性赋值
        logistics.setLogisticsAddressName(address.getAddressName());
        logistics.setLogisticsAddressProvince(address.getAddressProvince());
        logistics.setLogisticsAddressCity(address.getAddressCity());
        logistics.setLogisticsAddressCounty(address.getAddressCounty());
        logistics.setLogisticsAddressPhone(address.getAddressPhone());
        logistics.setLogisticsAddressDetail(address.getAddressDetail());
        logistics.setOrderFurnitureId(furniture.getOrderFurnitureId());
        logistics.setLogisticsFee(Double.parseDouble("0"));
        //执行修改操作
        orderLogisticsDao.update(logistics, queryWrapper2);
        //给属性赋值
        alipayBean.setOut_trade_no(code);
        alipayBean.setSubject(furnitureMap.get("furniture_name"));
        alipayBean.setTotal_amount(price + "");
        alipayBean.setBody(furnitureMap.get("description"));
        return alipayBean;
    }

    /**
     * 获取用户所有的订单
     *
     * @param account 用户的账号
     * @return 订单信息
     */
    public List<HashMap<String, Object>> getAllUserOrder(String account) {
        //通过账号获取用户的id
        Integer uId = orderDao.getUserId(account);
        //创建QueryWrapper对象
        QueryWrapper<F_user_order> queryWrapper = new QueryWrapper<>();
        //判断user_id等于需要查询的id
        queryWrapper.eq("user_id", uId);
        //执行查询操作
        List<F_user_order> orders = orderDao.selectList(queryWrapper);
        //调用工具类,获取订单信息
        return getOrderUtil.getOrderInfo(orders);
    }

    /**
     * 获取用户所有未付款的订单
     *
     * @param account 用户的账号
     * @return 返回用户全部没有付款的订单
     */
    public List<HashMap<String, Object>> obligation(String account) {
        //通过账号获取用户id
        Integer uId = orderDao.getUserId(account);
        //创建QueryWrapper对象
        QueryWrapper<F_user_order> queryWrapper = new QueryWrapper<>();
        //判断订单用户的外检等于查询订单的用户的id
        queryWrapper.eq("user_id", uId);
        //并且还是未支付的订单
        queryWrapper.eq("is_pay", "1");
        //查询所有的订单
        List<F_user_order> orders = orderDao.selectList(queryWrapper);
        //调用工具类,获取订单信息
        return getOrderUtil.getOrderInfo(orders);
    }

    /**
     * 获取用户所有未收货的订单
     *
     * @param account 用户的账号
     * @return 返回用户所有未收货的订单
     */
    public List<HashMap<String, Object>> waitReceive(String account) {
        //通过账号获取用户id
        Integer uId = orderDao.getUserId(account);
        //创建QueryWrapper对象
        QueryWrapper<F_user_order> queryWrapper = new QueryWrapper<>();
        //判断订单用户的外检等于查询订单的用户的id
        queryWrapper.eq("user_id", uId);
        //并且还是未收货的订单
        queryWrapper.eq("is_ship", "1");
        //查询所有的订单
        List<F_user_order> orders = orderDao.selectList(queryWrapper);
        //调用工具类,获取订单信息
        return getOrderUtil.getOrderInfo(orders);
    }

    /**
     * 获取已收货订单的详情
     *
     * @param orderId 订单的id
     * @return 订单的详情
     */
    public HashMap<String, Object> getOrderDetailByOrderId(Integer orderId) {
        //创建集合对象用来储存数据
        HashMap<String, Object> map = new HashMap<>();
        //创建QueryWrapper对象
        QueryWrapper<F_user_order> queryWrapper = new QueryWrapper();
        //判断订单的id等于要查询订单的id
        queryWrapper.eq("order_id", orderId);
        //执行查询操作
        F_user_order order = orderDao.selectOne(queryWrapper);
        //获取订单的编号
        String orderNo = order.getOrderNo();
        //通过订单的id获取订单家具表
        F_user_order_furniture orderFurniture = orderFurnitureDao.selectOrderFurnitureByOrderId(orderId);
        //获取属性
        Integer orderFurnitureId = orderFurniture.getOrderFurnitureId();
        Integer furnitureId = orderFurniture.getFurnitureId();
        String payType = orderFurniture.getPayType();
        Double price = orderFurniture.getFurniturePrice();
        Integer number = orderFurniture.getFurnitureNumber();
        //通过家具id查询家具信息
        HashMap<String, String> furnitureMap = orderDao.selectFurniture(furnitureId);
        //获取属性
        String furnitureName = furnitureMap.get("furniture_name");
        String imgUrl = furnitureMap.get("furniture_img");
        //创建QueryWrapper对象
        QueryWrapper<F_user_order_logistics> queryWrapper1 = new QueryWrapper<>();
        //判断订单家具的id等于订单物流的id
        queryWrapper1.eq("order_furniture_id", orderFurnitureId);
        //执行查询操作
        F_user_order_logistics logistics = orderLogisticsDao.selectOne(queryWrapper1);
        //获取属性
        String name = logistics.getLogisticsAddressName();
        String phone = logistics.getLogisticsAddressPhone();
        String province = logistics.getLogisticsAddressProvince();
        String city = logistics.getLogisticsAddressCity();
        String county = logistics.getLogisticsAddressCounty();
        String detail = logistics.getLogisticsAddressDetail();
        //往集合中添加值
        map.put("orderNo", orderNo);
        map.put("payType", payType);
        map.put("furnitureName", furnitureName);
        map.put("imgUrl", imgUrl);
        map.put("name", name);
        map.put("phone", phone);
        map.put("province", province);
        map.put("city", city);
        map.put("county", county);
        map.put("detail", detail);
        map.put("price", price);
        map.put("number", number);
        //返回集合
        return map;
    }

    /**
     * 确认收获的方法
     *
     * @param orderNo 订单的编号
     */
    public void confirmReceipt(String orderNo) {
        //创建QueryWrapper对象
        QueryWrapper<F_user_order> queryWrapper = new QueryWrapper<>();
        //判断订单的编号等于需要收获的订单编号
        queryWrapper.eq("order_no", orderNo);
        //执行查询操作
        F_user_order order = orderDao.selectOne(queryWrapper);
        //给属性赋值
        order.setReceiptTime(new Date());
        order.setIsShip(Byte.parseByte("0"));
        order.setTurnoverTime(new Date());
        //执行修改操作
        orderDao.update(order, queryWrapper);
    }

    /**
     * 获取未支付订单的信息
     *
     * @param orderNo
     * @return
     */
    public HashMap<String, Object> nowPay(String orderNo) {
        //创建集合对象
        HashMap<String, Object> map = new HashMap<>();
        //创建QueryWrapper对象
        QueryWrapper<F_user_order> queryWrapper = new QueryWrapper();
        //判断订单的编号等于需要查询的订单编号
        queryWrapper.eq("order_no", orderNo);
        //执行查询操作
        F_user_order order = orderDao.selectOne(queryWrapper);
        //获取订单的id
        Integer orderId = order.getOrderId();
        //通过订单的id查询订单家具信息
        F_user_order_furniture furniture = orderFurnitureDao.selectOrderFurnitureByOrderId(orderId);
        //获取属性
        Integer number = furniture.getFurnitureNumber();
        Double price = furniture.getFurniturePrice();
        Integer furnitureId = furniture.getFurnitureId();
        //通过家具的id查询家具
        HashMap<String, String> furnitureMap = orderDao.selectFurniture(furnitureId);
        //获取属性
        String imgUrl = furnitureMap.get("furniture_img");
        String name = furnitureMap.get("furniture_name");
        //通过家具的id查询家具详情信息
        HashMap<String, Integer> furnitureDetailMap = orderDao.selectFurnitureDetail(furnitureId);
        //获取属性key的id
        Integer propertyKeyId = furnitureDetailMap.get("property_key_id");
        //获取属性value的id
        Integer propertyValueId = furnitureDetailMap.get("property_value_id");
        //通过属性的id获取属性的信息
        HashMap<String, String> propertyKeyMap = orderDao.selectPropertyKey(propertyKeyId);
        //通过属性值的id获取属性值的信息
        HashMap<String, String> propertyValueMap = orderDao.selectPropertyValue(propertyValueId);
        //获取属性
        String propertyKey = propertyKeyMap.get("property_key_title");
        String propertyValue = propertyValueMap.get("property_value_title");
        //往集合赋值
        map.put("orderCode", orderNo);
        map.put("imgUrl", imgUrl);
        map.put("furnitureName", name);
        map.put("number", number);
        map.put("price", price);
        map.put("propertyKey", propertyKey);
        map.put("propertyValue", propertyValue);
        System.out.println(map);
        //返回集合
        return map;
    }


    /**
     * 支付订单的方法
     *
     * @param code      家具的编号
     * @param addressId 地址的id
     * @param payType   支付的类型
     * @param price     支付家具的价格
     */
    public AliPayBean orderNowPay(Integer is, String code, Integer addressId, String payType, Double price) {
        if(is == 1){
            return pay(code, addressId, payType, price);
        }else if(is == 2){
            return orderFurniturePay(code, addressId, payType, price);
        }
        return null;
    }

    /**
     * 支付方法
     * @param code      家具的编号
     * @param addressId 地址的id
     * @param payType   支付的类型
     * @param price     支付家具的价格
     * @return 返回支付对象
     */
    public AliPayBean pay(String code, Integer addressId, String payType, Double price){
        AliPayBean alipayBean = new AliPayBean();
        //创建日期对象
        Date date = new Date();
        //创建QueryWrapper对象
        QueryWrapper<F_user_order> queryWrapper = new QueryWrapper();
        //判断订单的编号等于要查询的编号
        queryWrapper.eq("order_no", code);
        //执行查询操作
        F_user_order order = orderDao.selectOne(queryWrapper);
        //给属性赋值
        order.setIsShip(Byte.parseByte("1"));
        order.setPayPrice(price);
        order.setIsPay(Byte.parseByte("0"));
        order.setPayTime(date);
        //执行修改操作
        orderDao.update(order, queryWrapper);
        //获取订单的id
        Integer orderId = order.getOrderId();
        //修改支付的方式
        orderFurnitureDao.updateOrderFurnitureInfo(payType, orderId);
        //通过订单的id查询订单家具
        F_user_order_furniture furniture = orderFurnitureDao.selectOrderFurnitureByOrderId(orderId);
        //获取订单家具的id
        Integer orderFurnitureId = furniture.getOrderFurnitureId();
        //获取订单的数量
        Integer number = furniture.getFurnitureNumber();
        //获取订单的家具id
        Integer furnitureId = furniture.getFurnitureId();
        //获取家具的信息
        HashMap<String, String> furnitureMap = orderDao.selectFurniture(furnitureId);
        System.out.println("数量:" + number);
        System.out.println("id:" + furnitureId);
        //调用dao层添加销量的方法
        orderDao.addClicks(number,furnitureId);
        //减少家具的库存
        orderDao.reduceInventory(number,furnitureId);
        //通过地址id查询地址
        F_user_address address = addressDao.selectById(addressId);
        //创建QueryWrapper对象
        QueryWrapper<F_user_order_logistics> wrapper = new QueryWrapper<>();
        //判断查询的id和订单家具的id相等
        wrapper.eq("order_furniture_id", orderFurnitureId);
        //执行查询操作
        F_user_order_logistics logistics = orderLogisticsDao.selectOne(wrapper);
        //给属性赋值
        logistics.setLogisticsAddressName(address.getAddressName());
        logistics.setLogisticsAddressProvince(address.getAddressProvince());
        logistics.setLogisticsAddressCity(address.getAddressCity());
        logistics.setLogisticsAddressCounty(address.getAddressCounty());
        logistics.setLogisticsAddressPhone(address.getAddressPhone());
        logistics.setLogisticsAddressDetail(address.getAddressDetail());
        logistics.setOrderFurnitureId(furniture.getOrderFurnitureId());
        logistics.setLogisticsFee(Double.parseDouble("0"));
        //执行修改操作
        orderLogisticsDao.update(logistics, wrapper);
        //给属性赋值
        alipayBean.setOut_trade_no(code);
        alipayBean.setSubject(furnitureMap.get("furniture_name"));
        alipayBean.setTotal_amount(price + "");
        alipayBean.setBody(furnitureMap.get("description"));
        //返回对象
        return alipayBean;
    }

}
