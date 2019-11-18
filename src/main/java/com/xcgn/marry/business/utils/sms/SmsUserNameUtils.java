package com.xcgn.marry.business.utils.sms;

public class SmsUserNameUtils {
	private String userName;
	private String password;

	SmsUserNameUtils(String sign) {

		if ("【快到账】".equals(sign)) {
			this.userName = "kdz@sxzy";
			this.password = "UJZd4i7W";
		}

		if ("【嗨借】".equals(sign)) {
			this.userName = "hj@sxzy";
			this.password = "01vxKtLA";
		}

		if ("【壭洡钱包】".equals(sign)) {
			this.userName = "sl@sxzy";
			this.password = "dhB5g6hX";
		}

		if ("【嗨花呗】".equals(sign)) {
			this.userName = "hhb@sxzy";
			this.password = "vXsSw3O9";
		}

		if ("【嗨秒到】".equals(sign)) {
			this.userName = "hmd@sxzy";
			this.password = "cY2M5Xcb";
		}

		if ("【嗨用呗】".equals(sign)) {
			this.userName = "hyb@sxzy";
			this.password = "mfAF9o7U";
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
