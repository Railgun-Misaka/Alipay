package com.alipay.bean;


/**
 * 退款实体类
 * @author Fly
 *
 */
public class AlipayTradeRefund {
	
	/*********************不能为空***********************/
	
	//订单支付时传入的商户订单号,不能和 trade_no同时为空。 
	private long out_trade_no ;
	
	//支付宝交易号，和out_trade_no不能同时为空 
	private long trade_no ;
	
	//需要退款的金额，该金额不能大于订单金额,单位为元，支持两位小数
	private float refund_amount ;
	
	/*********************允许为空***********************/
	
	//订单退款币种信息    RMB USD
	private String refund_currency ;
	
	//退款的原因说明   最大长度256
	private String refund_reason ;
	
	//标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传。 
	private String out_request_no ;

	public long getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(long out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public long getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(long trade_no) {
		this.trade_no = trade_no;
	}

	public float getRefund_amount() {
		return refund_amount;
	}

	public void setRefund_amount(float refund_amount) {
		this.refund_amount = refund_amount;
	}

	public String getRefund_currency() {
		return refund_currency;
	}

	public void setRefund_currency(String refund_currency) {
		this.refund_currency = refund_currency;
	}

	public String getRefund_reason() {
		return refund_reason;
	}

	public void setRefund_reason(String refund_reason) {
		this.refund_reason = refund_reason;
	}

	public String getOut_request_no() {
		return out_request_no;
	}

	public void setOut_request_no(String out_request_no) {
		this.out_request_no = out_request_no;
	}
	
}
