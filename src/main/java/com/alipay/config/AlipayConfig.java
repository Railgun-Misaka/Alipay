package com.alipay.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

/**
 * 公共参数
 * @author Fly
 *
 */
@Configuration
@PropertySource("alipay.properties")
public class AlipayConfig {
	
	@Value("${app_id}") 
	private long app_id ;

	@Value("${merchant_private_key}") 
	private String merchant_private_key ;

	@Value("${alipay_public_key}") 
	private String alipay_public_key ;

	@Value("${notify_url}") 
	private String notify_url ;

	@Value("${return_url}") 
	private String return_url ;

	@Value("${sign_type}") 
	private String sign_type ;

	@Value("${charset}") 
	private String charset ;

	@Value("${gatewayUrl}") 
	private String gatewayUrl ;

	@Value("${log_path}") 
	private String log_path ;
	
	@Bean
	public AlipayClient getAlipayClient() {
		
		AlipayClient alipayClient = new DefaultAlipayClient(
				gatewayUrl,//支付宝网关
				app_id + "",//appid
				merchant_private_key,//商户私钥
                "json",
                charset,//字符编码格式
                alipay_public_key,//支付宝公钥
                sign_type//签名方式
        );
		
		return alipayClient ;
	}
	
	public long getApp_id() {
		return app_id;
	}

	public void setApp_id(long app_id) {
		this.app_id = app_id;
	}

	public String getMerchant_private_key() {
		return merchant_private_key;
	}

	public void setMerchant_private_key(String merchant_private_key) {
		this.merchant_private_key = merchant_private_key;
	}

	public String getAlipay_public_key() {
		return alipay_public_key;
	}

	public void setAlipay_public_key(String alipay_public_key) {
		this.alipay_public_key = alipay_public_key;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getReturn_url() {
		return return_url;
	}

	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getGatewayUrl() {
		return gatewayUrl;
	}

	public void setGatewayUrl(String gatewayUrl) {
		this.gatewayUrl = gatewayUrl;
	}

	public String getLog_path() {
		return log_path;
	}

	public void setLog_path(String log_path) {
		this.log_path = log_path;
	}
}

