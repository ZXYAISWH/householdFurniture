package com.duing.backstage.service;

import com.duing.backstage.dao.AddFurnitureSmallImgDao;
import com.duing.backstage.domain.F_furniture_small_image;
import com.duing.backstage.util.JudgeImgFormat;
import com.duing.backstage.util.RandomSmallImgUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.Date;

/**
 * 做后台上传家具小图的业务成
 * 做逻辑判断的
 *
 * @Service 说明这是一个业务成对象, 将这个控制层交给spring来管理, 底层实际用的是@Component注解,为了让层次分明,让调用者可读性强,就包装成@Service
 * @SuppressWarnings 不扫描本类规范
 */
@Service
@SuppressWarnings("all")
public class AddFurnitureSmallImgService {

    /**
     * 获取dao层的对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private AddFurnitureSmallImgDao addFurnitureSmallImgDao;

    /**
     * 获取工具类RandomSmallImgUrl对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private RandomSmallImgUrl randomSmallImgUrl;

    /**
     * 获取判断家具的图片是否符合图片格式
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private JudgeImgFormat judgeImgFormat;

    /**
     * 添加家具的小图
     *
     * @param multipartFile 文件上传对象
     * @param furnitureId   家具的ID
     */
    public void addFurnitureSmallImg(MultipartFile[] multipartFiles, Integer furnitureId) {
        try {
            //循环获取文件上传对象
            for (MultipartFile multipartFile : multipartFiles) {
                //获取文件的名称
                String smallImgName = multipartFile.getOriginalFilename();
                //判断文件是否符合图片格式
                Boolean flag = judgeImgFormat.conformFormatToImg(smallImgName);
                //判断
                if (flag) {
                    //获取图片的格式
                    smallImgName = smallImgName.substring(smallImgName.lastIndexOf("."));
                    //获取随机小图的名称
                    String smallImgUrl = randomSmallImgUrl.productSmallUrl(20);
                    //组合成图片的全称
                    String imgName = judgeImgFormat.mainImgAllUrl(smallImgUrl, smallImgName);
                    //创建文件对象
                    File file = new File("E:\\IdeaProject\\Furniture\\Furniture-web\\src\\main\\resources\\static\\img\\furniture\\" + imgName);
                    File file1 = new File("E:\\IdeaProject\\Furniture\\Furniture-web\\target\\classes\\static\\img\\furniture\\" + imgName);
                    //文件上传
                    multipartFile.transferTo(file);
                    //创建输入流
                    InputStream inputStream = new FileInputStream(file);
                    int size = (int) file.length();
                    byte[] bytes = new byte[size];
                    //获取输出流
                    OutputStream outputStream = new FileOutputStream(file1);
                    inputStream.read(bytes);
                    outputStream.write(bytes);
                    outputStream.flush();
                    outputStream.close();
                    inputStream.close();
                    //执行文件上传操作

                    //创建F_furniture_small_image对象
                    F_furniture_small_image smallImage = new F_furniture_small_image();
                    smallImage.setSmallImgUrl(imgName);
                    smallImage.setFurnitureId(furnitureId);
                    smallImage.setImgAddTime(new Date(System.currentTimeMillis()));
                    //添加至数据库
                    addFurnitureSmallImgDao.insert(smallImage);
                } else {
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
