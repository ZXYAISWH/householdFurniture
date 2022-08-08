package com.duing.login.util;

import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

/**
 * 发送邮箱的工具类
 *
 * @Component 将这个工具类交给spring管理
 * @SuppressWarnings 不扫描本类规范
 */
@Component
@SuppressWarnings("all")
public class SendEmail {
    //创建Properties
    private static Properties properties = new Properties();

    static {
        properties.put("mail.transport.protocol", "smtp");// 连接协议
        properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
        properties.put("mail.smtp.port", 465);// 端口号
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
        properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
    }

    /**
     * 随机生成验证码
     *
     * @return 生成的验证码
     */
    public String genCodes() {
        String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            sb.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));
        }
        return sb.toString();
    }

    /**
     * 发送邮箱
     *
     * @param emailAccount 接收人邮箱
     * @return 生成的验证码
     * @throws Exception 异常
     */
    public String sendToUserEmail(String emailAccount) throws Exception {
        // 得到回话对象
        Session session = Session.getInstance(properties);
        // 获取邮件对象
        Message message = new MimeMessage(session);
        // 设置发件人邮箱地址
        message.setFrom(new InternetAddress("3260653092@qq.com"));
        // 设置收件人邮箱地址
        message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress(emailAccount)});
        //message.setRecipient(Message.RecipientType.TO, new InternetAddress("xxx@qq.com"));//一个收件人
        // 设置邮件标题
        message.setSubject("最家家居找回密码验证提醒:");
        //生成随机验证码
        String code = genCodes();
        // 设置邮件内容
        message.setText("尊敬的用户您好,您的验证请求已同意，请查收你的验证码，验证码为:" + code);//这是我们的邮件要发送的信息内容
        // 得到邮差对象
        Transport transport = session.getTransport();
        // 连接自己的邮箱账户
        transport.connect("3260653092@qq.com", "uanvzpnzzuzdcife");// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码,输入自己的即可
        // 发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        //关流
        transport.close();
        //返回验证码
        return code;
    }
}
