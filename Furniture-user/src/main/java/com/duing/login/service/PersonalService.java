package com.duing.login.service;

import com.duing.login.dao.UserDao;
import com.duing.login.domain.F_user;
import com.duing.login.util.JasyptUtil;
import com.duing.login.util.RedisUtils;
import com.duing.login.util.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * 用户信息的业务层
 *
 * @Service 代表业务层
 * @SuppressWarnings 不扫描本类规范
 */
@Service
@SuppressWarnings("all")
public class PersonalService {

    /**
     * 获取dao层的对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private UserDao userDao;

    /**
     * 获取redis的工具类
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 获取jasypt的工具类
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private JasyptUtil jasyptUtil;

    /**
     * 获取发送邮箱的工具类
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private SendEmail sendEmail;

    /**
     * 通过账号查询用户的信息
     *
     * @param account 账号
     * @return 用户信息
     */
    public F_user getUserInfo(String account) {
        //去数据库查询用户的信息
        F_user f_user = userDao.getUserInfo(account);
        //将查询出来的信息返回
        return f_user;
    }

    /**
     * 修改用户图像
     *
     * @param uploadImg 文件上传对象
     * @param account   账号
     */
    public void uploadImgUrl(MultipartFile uploadImg, String account) {
        //获取文件的名字
        String name = uploadImg.getOriginalFilename();
        //判断文件的格式是否符合图片格式
        if (name.contains("png") || name.contains("jpg") || name.contains("gif") || name.contains("bmp") || name.contains("jpeg") || name.contains("pdf")) {
            //截图图片的格式
            name = name.substring(name.lastIndexOf("."));
            //获取随机图片url
            String fileName = sendEmail.genCodes() + name;
            //创建File对象
            File file = new File("E:\\IdeaProject\\Furniture\\Furniture-web\\src\\main\\resources\\static\\img\\picture\\" + fileName);
            try {
                //上传
                uploadImg.transferTo(file);
                //获取输入流
                InputStream inputStream = new FileInputStream(file);
                //获取图片的大小
                int size = (int) file.length();
                //创建byte类型的数值,用来转载数据
                byte[] bytes = new byte[size];
                //获取输出流
                OutputStream outputStream = new FileOutputStream(new File("E:\\IdeaProject\\Furniture\\Furniture-web\\target\\classes\\static\\img\\picture\\" + fileName));
                //读取资源放入byte类型的数组里
                inputStream.read(bytes);
                //文件读写
                outputStream.write(bytes);
                //关流
                inputStream.close();
                outputStream.close();
                //调用dao层执行数据库操作
                userDao.uploadUserImgUrl(fileName, account);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 修改用户的信息
     *
     * @param f_user  用户信息
     * @param account 用户账号
     */
    public void changeUserInfo(F_user f_user, String account) {
        //调用dao层修改用户信息的方法
        userDao.changeUserInfo(f_user.getBirthday(), f_user.getNickName(), f_user.getSex(), account);
    }

    /**
     * 修改用户账号地区
     *
     * @param region  地区
     * @param account 账号
     */
    public void changeUserRegion(String region, String account) {
        //调用dao层修改地区的方法
        userDao.changeUserRegion(region, account);
    }

    /**
     * 修改密码
     *
     * @param oldPass 旧密码
     * @param newPass 新密码
     * @param account 账号
     * @return 修改的结果
     */
    public String changePassword(String oldPass, String newPass, String account) {
        //获取redis的用户信息
        F_user user = (F_user) redisUtils.get(account);
        //判断是否为空
        if (user != null) {
            //获取用户的密码
            String oldUserDecryptPass = user.getPassword();
            //解密
            String oldUserPass = jasyptUtil.decryptText(oldUserDecryptPass);
            //解密后的密码和用户输入的原密码比较
            if (oldUserPass.equals(oldPass)) {
                //加密需要被修改的密码
                String newUserDecryptPass = jasyptUtil.encryptText(newPass);
                //将加密后的放入对象中
                user.setPassword(newUserDecryptPass);
                //存入redis
                redisUtils.set(account, user);
            } else {
                //否则就是密码错误
                return "密码错误";
            }
        }
        //通过账号获取数据库的用户信息
        F_user f_user = userDao.selectPasswordIsTure(account);
        //判断是否存在
        if (f_user != null) {
            //获取用户的密码
            String oldUserDecryptPass = f_user.getPassword();
            //解密
            String oldUserPass = jasyptUtil.decryptText(oldUserDecryptPass);
            //解密后的密码和用户输入的原密码比较
            if (oldUserPass.equals(oldPass)) {
                //加密需要被修改的密码
                String newUserDecryptPass = jasyptUtil.encryptText(newPass);
                //修改密码
                userDao.changePass(newUserDecryptPass, account);
                //返回密码正确
                return "密码正确";
            } else {
                //返回密码错误
                return "密码错误";
            }
        }
        //返回null
        return null;
    }
}
