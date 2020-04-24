package com.alipay.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.AlipayApiException;
import com.alipay.bean.AlipayTradePay;
import com.alipay.bean.AlipayTradeRefund;
import com.alipay.util.AlipayUtil;

@RestController
public class AlipayController {
	
	private Logger logger = LoggerFactory.getLogger(getClass()); 	
	
	@PostMapping("/order/alipayTradePay")
	public String tradePay(AlipayTradePay alipay) throws AlipayApiException {
		logger.info(alipay.toString());
		return AlipayUtil.tradePay(alipay);
	}
	
	@PostMapping("/order/alipayTradeRefund")
	public String tradeRefund(AlipayTradeRefund alipay) throws AlipayApiException {
		return AlipayUtil.tradeRefund(alipay);
	}
}
