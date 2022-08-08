package com.duing.backstage.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duing.backstage.dao.AddFurnitureDao;
import com.duing.backstage.domain.F_furniture;
import com.duing.backstage.util.JudgeImgFormat;
import com.duing.backstage.util.RandomBigImgUrl;
import com.duing.backstage.util.RandomProductNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.Date;

/**
 * 做后台上传家具的的业务成
 * 做逻辑判断的
 *
 * @Service 说明这是一个业务成对象, 将这个控制层交给spring来管理, 底层实际用的是@Component注解,为了让层次分明,让调用者可读性强,就包装成@Service
 * @SuppressWarnings 不扫描本类规范
 */
@Service
@SuppressWarnings("all")
public class AddFurnitureService {

    /**
     * 获取dao层的对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private AddFurnitureDao addFurnitureDao;

    /**
     * 获取工具类RandomBigImgUrl对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private RandomBigImgUrl randomBigImgUrl;

    /**
     * 获取判断家具的图片是否符合图片格式
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private JudgeImgFormat judgeImgFormat;

    /**
     * 获取随机商品编号的工具类
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private RandomProductNumber randomProductNumber;

    /**
     * 添加家居
     *
     * @param furnitureBigImg 文件对象
     * @param classifyID      家居类型的ID
     * @param furnitureName   家居的名称
     * @param keyWordSearch   家居的关键字搜索
     * @param description     家居的描述
     * @return 商品的唯一编号
     */
    public String addFurniture(MultipartFile furnitureBigImg, Integer classifyID, String furnitureName, String keyWordSearch, String description) {
        String furnitureNo = "";
        try {
            //获取图片的名称
            String mainImgName = furnitureBigImg.getOriginalFilename();
            //判断是否符合图片格式
            Boolean flag = judgeImgFormat.conformFormatToImg(mainImgName);
            //判断
            if (flag) {
                //随机生成图片的名称,长度为20
                String mainImgUrl = randomBigImgUrl.productBigUrl(20);
                //获取最后一个点的索引下标
                int index = mainImgName.lastIndexOf(".");
                //获取图片的格式
                String imgFormat = mainImgName.substring(index);
                //随机的名称加上图片的格式,组装成新的图片名称
                String imgName = judgeImgFormat.mainImgAllUrl(mainImgUrl, imgFormat);
                //创建文件对象

                File file = new File("E:\\IdeaProject\\Furniture\\Furniture-web\\src\\main\\resources\\static\\img\\furniture\\" + imgName);
                File file1 = new File("E:\\IdeaProject\\Furniture\\Furniture-web\\target\\classes\\static\\img\\furniture\\" + imgName);
                //进行文件上传
                furnitureBigImg.transferTo(file);
                InputStream inputStream = new FileInputStream(file);
                int size = (int) file.length();
                byte[] bytes = new byte[size];
                OutputStream outputStream = new FileOutputStream(file1);
                inputStream.read(bytes);
                outputStream.write(bytes);
                outputStream.flush();
                outputStream.close();
                inputStream.close();
                //获取随机的家具编号
                furnitureNo = randomProductNumber.productID(25);
                //创建家具对象
                F_furniture furniture = new F_furniture();
                //给属性赋值
                furniture.setFurnitureName(furnitureName);
                furniture.setKeyWord(keyWordSearch);
                furniture.setClassifyId(classifyID);
                furniture.setFurnitureNo(furnitureNo);
                furniture.setDescription(description);
                furniture.setAddTime(new Date(System.currentTimeMillis()));
                furniture.setFurnitureImg(imgName);
                furniture.setStatus(Byte.parseByte("0"));
                furniture.setClicks(0);
                //进行新增操作
                addFurnitureDao.insert(furniture);
                //返回随机商品的编号
                return furnitureNo;
            } else {
                //不符合就返回空
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            //出现异常就返回空
            return null;
        }
    }

    /**
     * 通过家具的编号获取家具对象
     *
     * @param furnitureNO 家具编号
     * @return 家具的ID
     */
    public Integer getFurnitureID(String furnitureNO) {
        //创建queryWrapper对象
        QueryWrapper<F_furniture> queryWrapper = new QueryWrapper<>();
        //列名的值等于(家具的编号)furnitureNO
        queryWrapper.eq("furniture_no", furnitureNO);
        //调用dao层查询的方法
        F_furniture furniture = addFurnitureDao.selectOne(queryWrapper);
        System.out.println(furniture);
        //返回家具的ID
        return furniture.getFurnitureId();
    }
}
