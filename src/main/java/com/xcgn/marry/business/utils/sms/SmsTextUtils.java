package com.xcgn.marry.business.utils.sms;

/**
 * @author 短信文本发送
 *
 */
public enum SmsTextUtils {
	tk("尊敬的用户，您的退款申请已经通过审核，预计款项会在1-3个工作日到账，请注意查收，如有问题请联系客服"),
	
	pay1("尊敬的用户，您的账户管理费支付成功，可在app内查看，如有疑问，请联系官方电话 0755-36375410"),
	
	pay2("尊敬的用户，您的VIP融资咨询费已支付成功，可在app内查看，如有疑问，请联系官方电话 0755-36375410"),
	
	sq("尊敬的用户，您的退款申请提交成功，预计1-2日内为您审核，如有问题请联系客服"),
	
	ju("尊敬的用户，您的退款审核未通过，请联系在线客服查看原因，修改后再次上传即可，给您带来的不便敬请谅解。");
	
	private String text;

	SmsTextUtils(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
