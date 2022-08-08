import org.junit.jupiter.api.Test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class TestMain {
    @Test
    public void run() throws MessagingException {
// 创建Properties 类用于记录邮箱的一些属性
        Properties props = new Properties();
        // 表示SMTP发送邮件，必须进行身份验证
        props.put("mail.smtp.auth", "true");
        //此处填写SMTP服务器
        props.put("mail.smtp.host", "smtp.qq.com");
        //端口号，QQ邮箱端口587
        props.put("mail.smtp.port", "587");
        // 此处填写，写信人的账号
        props.put("mail.user", "3260653092@qq.com");
        // 此处填写16位STMP口令
        props.put("mail.password", "uanvzpnzzuzdcife");

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("3260653092@qq.com");
                String password = props.getProperty("zxy520swh");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
        message.setFrom(form);

        // 设置收件人的邮箱
        InternetAddress to = new InternetAddress("mail.user");
        message.setRecipient(RecipientType.TO, to);

        // 设置邮件标题
        message.setSubject("test");

        // 设置邮件的内容体
        message.setContent("springEmail", "text/html;charset=UTF-8");

        Transport ts = mailSession.getTransport();
        // 最后当然就是发送邮件啦
        ts.sendMessage(message, message.getAllRecipients());
    }

    @Test
    public void sendEmail() throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");// 连接协议
        properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
        properties.put("mail.smtp.port", 465);// 端口号
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
        properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
        // 得到回话对象
        Session session = Session.getInstance(properties);
        // 获取邮件对象
        Message message = new MimeMessage(session);
        // 设置发件人邮箱地址
        message.setFrom(new InternetAddress("3260653092@qq.com"));
        // 设置收件人邮箱地址
        message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress("2639796229@qq.com")});
        //message.setRecipient(Message.RecipientType.TO, new InternetAddress("xxx@qq.com"));//一个收件人
        // 设置邮件标题
        message.setSubject("汽车商城预约试驾提醒:");
        // 设置邮件内容
        message.setText("尊敬的用户您好,您的预约试驾请求已同意，请在自邮件发送日起三日内前往本辖区内官方体验店，详情请咨询12345678");//这是我们的邮件要发送的信息内容
        // 得到邮差对象
        Transport transport = session.getTransport();
        // 连接自己的邮箱账户
        transport.connect("3260653092@qq.com", "uanvzpnzzuzdcife");// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码,输入自己的即可
        // 发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    @Test
    public void genCodes() {
        String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            sb.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));
        }
    }

    @Test
    public void test11() {
        String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int length = allChar.length();
        for (int i = 0; i < 100; i++) {
            int value = (int) (Math.random() * length);
            char key = allChar.charAt(value);
            System.out.println(key);
        }
//
    }

    @Test
    public void orderNo() {
        Date date = new Date();
        //生成格式化日期为"yymmdd"
        DateFormat format = new SimpleDateFormat("yyMMdd");
        if (null == date) {
            date = new Date();
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append(format.format(date));
        String code = buffer.toString();

        //随机生成四位数
        String timeMillis = System.currentTimeMillis() + "";
        String randomNum = timeMillis.substring(timeMillis.length() - 4);

        //生成订单编号
        String orderCode = code + randomNum;
        System.out.println(orderCode);
    }


    @Test
    public void isComment() {

    }

}
