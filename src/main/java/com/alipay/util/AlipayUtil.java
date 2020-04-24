package com.alipay.util;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.alipay.bean.AlipayTradePay;
import com.alipay.bean.AlipayTradeRefund;
import com.alipay.config.AlipayConfig;

public class AlipayUtil {
	
	private static AlipayConfig alipayConfig = SpringUtil.getBean(AlipayConfig.class) ;

    //1、获得初始化的AlipayClient
	private static AlipayClient alipayClient = SpringUtil.getBean(AlipayClient.class) ;
			
	
	public static String tradePay(AlipayTradePay alipay) throws AlipayApiException {
		
		//2、设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        //页面跳转同步通知页面路径
        alipayRequest.setReturnUrl(alipayConfig.getReturn_url());
        // 服务器异步通知页面路径
        alipayRequest.setNotifyUrl(alipayConfig.getNotify_url());
        //封装参数
        alipayRequest.setBizContent(JSON.toJSONString(alipay));
        //3、请求支付宝进行付款，并获取支付结果
        //封装参数，生成对应的跳转界面
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        System.out.println(result);
        return result ;
	}
	
	public static String tradeRefund(AlipayTradeRefund alipay) throws AlipayApiException {
		
		AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
		request.setBizContent(JSON.toJSONString(alipay));
		AlipayTradeRefundResponse response = alipayClient.execute(request);
		if(response.isSuccess())
			return "success";
		else 
			return "failed";
	}
}
