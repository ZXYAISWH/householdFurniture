package com.duing.login.service;

import com.alipay.api.AlipayApiException;
import com.duing.login.config.Alipay;
import com.duing.login.domain.AliPayBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 支付服务接口
 */
@Service
public class PayService {

    @Autowired
    private Alipay alipay;

    public String aliPay(AliPayBean aliPayBean) throws AlipayApiException {
        return alipay.pay(aliPayBean);
    }
}

