import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class Mail extends Authenticator {
    public static String myEmailSMTPHost = "smtp.163.com";
    private static String sendAccount = "***@163.com";
    private static String pa = "*****";
    private static String receiveAccount = "***@163.com";


    public static void main(String[] args) throws UnsupportedEncodingException, MessagingException {

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");//使用协议
        props.setProperty("mail.smtp.host", myEmailSMTPHost);//发件人邮箱服务地址
        props.setProperty("mail.smtp.auth", "true");//需要请求认证
        props.setProperty("mail.smtp.port", "465");//ssl端口
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        Session session = Session.getInstance(props, new Mail());
        session.setDebug(true);
        MimeMessage mime = createMimeMessage(session, sendAccount, receiveAccount);
        Transport transport = session.getTransport();//根据session获得邮件传输对象
        transport.connect(sendAccount, pa);
        transport.send(mime, mime.getAllRecipients());
        transport.close();
    }

    private static MimeMessage createMimeMessage(Session session, String sendAccount, String receiveAccount) throws MessagingException, UnsupportedEncodingException {
        MimeMessage mime = new MimeMessage(session);
        mime.setFrom(sendAccount);
        mime.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveAccount, "hello", "UTF-8"));
        mime.setSubject("hello", "UTF-8");
        mime.setContent("test mail", "text/html; charset=UTF-8");
        mime.setSentDate(new Date());
        mime.saveChanges();
        return mime;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        String username = "***@163.com";
        String pa = "*****";
        if (username != null && username.length() > 0 && pa != null && pa.length() > 0) {
            return new PasswordAuthentication(username, pa);
        }
        return null;
    }
}

