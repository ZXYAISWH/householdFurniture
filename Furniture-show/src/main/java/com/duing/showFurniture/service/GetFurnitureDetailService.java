package com.duing.showFurniture.service;

import com.duing.showFurniture.dao.ShowFurnitureDao;
import com.duing.showFurniture.domain.F_furniture;
import com.duing.showFurniture.domain.F_furniture_inventory;
import com.duing.showFurniture.util.GetFurnitureUtil;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 获取家具详细信息的业务层
 */
@Service
@SuppressWarnings("all")
public class GetFurnitureDetailService {

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
     * 通过家具的id,获取家具的详细信息,并且返回
     *
     * @param furnitureId 家具的id
     * @return 家具的详细信息
     */
    public Map<String, Object> getDetail(Integer furnitureId) {
        //创建map集合用来存储家具的详细信息
        Map<String, Object> detailMap = new HashMap<>();
        //通过穿过来的家具Id,获取单个家具的所有信息
        F_furniture f_furniture = showFurnitureDao.getFurniture(furnitureId);
        //通过家具的id,获取家具的小图
        List<String> list = showFurnitureDao.getAllSmallUrl(furnitureId);
        //去家具库存表获取家具的价格,库存
        F_furniture_inventory inventory = showFurnitureDao.getFurnitureInventoryInfo(furnitureId);
        //往集合中添加值
        detailMap.put("id", furnitureId);
        detailMap.put("name", f_furniture.getFurnitureName());
        detailMap.put("mainImgUrl", f_furniture.getFurnitureImg());
        detailMap.put("viceImgUrl", list);
        detailMap.put("price", inventory.getFurniturePrice());
        detailMap.put("inventory", inventory.getFurnitureInventory());
        //返回装入数据的集合
        return detailMap;
    }

    /**
     * 获取家具的评论信息
     *
     * @param furnitureId 家具的id
     * @return 获取家具的评论信息
     */
    public List<HashMap<String, Object>> getFurnitureComment(Integer furnitureId){
        //创建集合对象,用来存储数据
        List<HashMap<String, Object>> listComment = new ArrayList<>();
        //通过家具的id获取id
        List<HashMap<String, Object>> furnitureComment = showFurnitureDao.getFurnitureComment(furnitureId);
        for (HashMap<String, Object> map : furnitureComment) {
            //创建集合对象,用来存储数据
            HashMap<String, Object> mapComment = new HashMap<>();
            //获取属性
            String commentContent = (String) map.get("furniture_comment_content") ;
            Double commentScore = (Double) map.get("furniture_comment_scores");
            Date commentTime = (Date)map.get("furniture_comment_time");
            Integer userID = (Integer) map.get("user_id");
            //通过用户的id查询用户
            HashMap<String, String> userByUserId = showFurnitureDao.getUserByUserId(userID);
            //获取用户的属性
            String imgUrl = userByUserId.get("img_url");
            String nickName = userByUserId.get("nick_name");
            //将信息添加到集合中
            mapComment.put("commentContent",commentContent);
            mapComment.put("commentScore",commentScore);
            mapComment.put("commentTime",commentTime);
            mapComment.put("imgUrl",imgUrl);
            mapComment.put("nickName",nickName);
            listComment.add(mapComment);
        }
        return listComment;
    }

    /**
     * 获取家具详情时猜你喜欢的家具
     * @return 家具的详细信息
     */
    public List<Map<String, String>> getFurnitureToYouLove(){
        //获取所有的家具
        List<F_furniture> furnitureList = showFurnitureDao.selectList(null);
        //创建集合对象,存储数据
        List<F_furniture> furnitures = new ArrayList<>();
        //循环获取
        for (int i = 0;i < 5;i++) {
            //获取随机数
            int number = (int)(Math.random() * furnitureList.size());
            //装入集合
            furnitures.add(furnitureList.get(number));
        }
        //调用工具类,获取家具信息的方法
        return getFurnitureUtil.getFurnitureInfo(furnitures);
    }
}
