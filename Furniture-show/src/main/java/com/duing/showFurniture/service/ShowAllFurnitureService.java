package com.duing.showFurniture.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duing.showFurniture.dao.ShowFurnitureDao;
import com.duing.showFurniture.domain.F_furniture;
import com.duing.showFurniture.util.GetFurnitureUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 做所有家具展示的业务层
 *
 * @Service 说明这是一个控制层对象, 将这个控制层交给spring来管理, 底层实际用的是@Component注解,为了让层次分明,让调用者可读性强,就包装成@Service注解
 * @SuppressWarnings 不扫描本类规范
 */
@Service
public class ShowAllFurnitureService {

    /**
     * 获取展示家具的dao层
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private ShowFurnitureDao showFurnitureDao;

    /**
     * 获取家具的工具类
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private GetFurnitureUtil getFurnitureUtil;

    /**
     * 通过家具的销量获取家具
     *
     * @return 家具数据
     */
    public List<Map<String, String>> getSomeFurnitureToIndex() {
        //创建集合对象,用来存储数据
        List<Map<String, String>> listMap = new ArrayList();
        //获取销量前22的所有的家具
        List<F_furniture> furnitures = showFurnitureDao.selectFurnitureByClicks();
        //调用工具类,获取家具信息的方法
        return getFurnitureUtil.getFurnitureInfo(furnitures);
    }

    /**
     * 获取所有家具的方法
     *
     * @return 所有家具信息
     */
    public List<Map<String, String>> getAllFurniture() {
        //获取所有的家具
        List<F_furniture> furnitures = showFurnitureDao.selectList(null);
        //调用工具类,获取家具信息的方法
        return getFurnitureUtil.getFurnitureInfo(furnitures);
    }

    /**
     * 所有家具按照什么排序(价格/销量/新品)
     *
     * @param value 排序的方式
     * @return 所有家具信息
     */
    public List<Map<String, String>> getAllFurnitureOrderBy(String value) {
        //通过不同方式排序,获取顺序不同结果的家具
        List<F_furniture> furnitures = showFurnitureDao.selectListOrderBy(value);
        //调用工具类,获取家具信息的方法
        return getFurnitureUtil.getFurnitureInfo(furnitures);
    }

    /**
     * 获取干花花艺家具的方法
     *
     * @return 所有干花花艺家具的信息
     */
    public List<Map<String, String>> getAllFurnitureToProList() {
        //创建QueryWrapper对象
        QueryWrapper<F_furniture> queryWrapper = new QueryWrapper<>();
        //判断获取所有家具的id等于干花花艺类型家具的id
        queryWrapper.eq("classify_id", this.selectFurnitureClassifyId("干花花艺"));
        //执行查询操作
        List<F_furniture> furnitures = showFurnitureDao.selectList(queryWrapper);
        //调用工具类,获取家具信息的方法
        return getFurnitureUtil.getFurnitureInfo(furnitures);
    }

    /**
     * 干花花艺家具按照什么排序(价格/销量/新品)
     *
     * @param value 排序的方式
     * @return 所有家具信息
     */
    public List<Map<String, String>> getAllFurnitureToProListOrderBy(String value) {
        //通过不同排序的方式,获取不同顺序干花花艺家具的信息
        List<F_furniture> furnitures = showFurnitureDao.selectListToProListOrderBy(value);
        //调用工具类,获取家具信息的方法
        return getFurnitureUtil.getFurnitureInfo(furnitures);
    }

    /**
     * 获取花瓶花器家具的方法
     *
     * @return 所有花瓶花器家具的信息
     */
    public List<Map<String, String>> getAllFurnitureToVaseProList() {
        //创建QueryWrapper对象
        QueryWrapper<F_furniture> queryWrapper = new QueryWrapper<>();
        //判断获取所有家具的id等于花瓶花器类型家具的id
        queryWrapper.eq("classify_id", this.selectFurnitureClassifyId("花瓶花器"));
        //执行查询操作
        List<F_furniture> furnitures = showFurnitureDao.selectList(queryWrapper);
        //调用工具类,获取家具信息的方法
        return getFurnitureUtil.getFurnitureInfo(furnitures);
    }

    /**
     * 花瓶花器家具按照什么排序(价格/销量/新品)
     *
     * @param value 排序的方式
     * @return 所有家具信息
     */
    public List<Map<String, String>> getAllFurnitureToVaseProListOrderBy(String value) {
        //通过不同排序的方式,获取不同顺序花瓶花器家具的信息
        List<F_furniture> furnitures = showFurnitureDao.selectListToProListOrderBy(value);
        //调用工具类,获取家具信息的方法
        return getFurnitureUtil.getFurnitureInfo(furnitures);
    }

    /**
     * 获取桌布罩件家具的方法
     *
     * @return 所有桌布罩件家具的信息
     */
    public List<Map<String, String>> getAllFurnitureToZbProList() {
        //创建QueryWrapper对象
        QueryWrapper<F_furniture> queryWrapper = new QueryWrapper<>();
        //判断获取所有家具的id等于桌布罩件类型家具的id
        queryWrapper.eq("classify_id", this.selectFurnitureClassifyId("桌布罩件"));
        //获取所有的家具
        List<F_furniture> furnitures = showFurnitureDao.selectList(queryWrapper);
        //调用工具类,获取家具信息的方法
        return getFurnitureUtil.getFurnitureInfo(furnitures);
    }

    /**
     * 桌布罩件家具按照什么排序(价格/销量/新品)
     *
     * @param value 排序的方式
     * @return 所有家具信息
     */
    public List<Map<String, String>> getAllFurnitureToZbProListOrderBy(String value) {
        //通过不同排序的方式,获取不同顺序桌布罩件家具的信息
        List<F_furniture> furnitures = showFurnitureDao.selectListToZbProListOrderBy(value);
        //调用工具类,获取家具信息的方法
        return getFurnitureUtil.getFurnitureInfo(furnitures);
    }

    /**
     * 获取抱枕靠垫家具的方法
     *
     * @return 所有抱枕靠垫家具的信息
     */
    public List<Map<String, String>> getAllFurnitureToBzProList() {
        //创建QueryWrapper对象
        QueryWrapper<F_furniture> queryWrapper = new QueryWrapper<>();
        //判断获取所有家具的id等于枕靠垫家类型家具的id
        queryWrapper.eq("classify_id", this.selectFurnitureClassifyId("抱枕靠垫"));
        //获取所有的家具
        List<F_furniture> furnitures = showFurnitureDao.selectList(queryWrapper);
        //调用工具类,获取家具信息的方法
        return getFurnitureUtil.getFurnitureInfo(furnitures);
    }

    /**
     * 抱枕靠垫家具按照什么排序(价格/销量/新品)
     *
     * @param value 排序的方式
     * @return 所有家具信息
     */
    public List<Map<String, String>> getAllFurnitureToBzProListOrderBy(String value) {
        //通过不同排序的方式,获取不同顺序桌布罩件家具的信息
        List<F_furniture> furnitures = showFurnitureDao.selectListToBzProListOrderBy(value);
        //调用工具类,获取家具信息的方法
        return getFurnitureUtil.getFurnitureInfo(furnitures);
    }

    /**
     * 获取墙饰壁挂家具的方法
     *
     * @return 所有墙饰壁挂家具的信息
     */
    public List<Map<String, String>> getAllFurnitureToPaint() {
        //创建QueryWrapper对象
        QueryWrapper<F_furniture> queryWrapper = new QueryWrapper<>();
        //判断获取所有家具的id等于墙饰壁挂类型家具的id
        queryWrapper.eq("classify_id", this.selectFurnitureClassifyId("墙式壁挂"));
        //获取所有的家具
        List<F_furniture> furnitures = showFurnitureDao.selectList(queryWrapper);
        //调用工具类,获取家具信息的方法
        return getFurnitureUtil.getFurnitureInfo(furnitures);
    }

    /**
     * 获取蜡艺香薰家具的方法
     *
     * @return 所有蜡艺香薰家具的信息
     */
    public List<Map<String, String>> getAllFurnitureToPerFume() {
        //创建QueryWrapper对象
        QueryWrapper<F_furniture> queryWrapper = new QueryWrapper<>();
        //判断获取所有家具的id等于蜡艺香薰类型家具的id
        queryWrapper.eq("classify_id", this.selectFurnitureClassifyId("蜡艺香薰"));
        //获取所有的家具
        List<F_furniture> furnitures = showFurnitureDao.selectList(queryWrapper);
        //调用工具类,获取家具信息的方法
        return getFurnitureUtil.getFurnitureInfo(furnitures);
    }

    /**
     * 通过不同类型的家具
     *
     * @param furnitureType 家具类型
     * @return 类型所对应的id
     */
    public Integer selectFurnitureClassifyId(String furnitureType) {
        //调用dao层通过家具查询id的方法
        return showFurnitureDao.selectFurnitureClassifyId(furnitureType);
    }

    /**
     * 通过关键字查询家具
     * @param value 关键字
     * @return 家具的信息
     */
    public List<Map<String, String>> getFurnitureByKeyWord(String value){
        //调用dao层模糊查询的方法
        List<F_furniture> furnitures = showFurnitureDao.getFurnitureByKeyWord(value);
        //调用工具类,获取家具信息的方法
        return getFurnitureUtil.getFurnitureInfo(furnitures);
    }
}
