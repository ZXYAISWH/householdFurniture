package com.duing.login.util;

import com.cloopen.rest.sdk.BodyType;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;

/**
 * 获取手机号验证码的工具类
 *
 * @Component 将这个工具类交给spring管理
 * @Slf4j 打印的日志信息 该注解相当于代替了以下的代码：private  final Logger logger = LoggerFactory.getLogger(当前类名.class);
 * @SuppressWarnings 不扫描本类规范
 */
@Slf4j
@Component
@SuppressWarnings("all")
public class GetPhoneVerificationCode {
    /**
     * 获取验证码
     *
     * @param phone 手机号
     * @return 验证码
     */
    public String VerificationCode(String phone) {
        //生产环境请求地址：app.cloopen.com
        String serverIp = "app.cloopen.com";
        //请求端口
        String serverPort = "8883";
        //主账号,登陆云通讯网站后,可在控制台首页看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN
        String accountSId = "8aaf070881ad8ad401820bad855117a5";
        String accountToken = "bb68351049944b2c9124c4c379f4b2fb";
        //请使用管理控制台中已创建应用的APPID
        String appId = "8aaf070881ad8ad401820bad862a17ac";
        CCPRestSmsSDK sdk = new CCPRestSmsSDK();
        sdk.init(serverIp, serverPort);
        sdk.setAccount(accountSId, accountToken);
        sdk.setAppId(appId);
        sdk.setBodyType(BodyType.Type_JSON);
        //随机生成6位数字为验证码
        String code = String.valueOf(Math.random()).substring(2, 8);
        System.out.println(code);
        //需要把验证号转发到的手机号码
        String to = phone;
        //在短信管理中选择模板ID，我选择的是1
        String templateId = "1";
        //模板参数
        String[] datas = {code, "30分钟"};
        //这里是使用了一个哈希map来存放手机号、模板ID、模板参数
        HashMap<String, Object> result = sdk.sendTemplateSMS(to, templateId, datas);
        //如果返回0000则正常发送，否则返回异常
        if ("000000".equals(result.get("statusCode"))) {
            //正常返回输出data包体信息（map）
            HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for (String key : keySet) {
                Object object = data.get(key);
                System.out.println(key + " = " + object);
            }
        } else {
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
        }
        return code;
    }

}
