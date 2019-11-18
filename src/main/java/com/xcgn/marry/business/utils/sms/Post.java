package com.xcgn.marry.business.utils.sms;

import com.alibaba.fastjson.JSONObject;

public class Post {
	private String username = "sxzy@sxzy";
	private String password = "6gbHkzBG";

	Post(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String doSendsms(String phone, String text) throws Exception {
		/**
		 * HTTP-POST请求参数：发送短信 密码可明文，可密文：version为空，密码明文传输，为1.0，密码MD5加密传输
		 * 短信内容，可GBK，UTF8传输：encode为空或0,内容gbk编码传输；encode为1，内容以utf-8编码传输
		 * msgtype=1为短短信，4为长短信，长短信包含短短信
		 * 
		 */
		String passwordMD5 = Md5Encrypt.md5(password);
		JSONObject postdata = new JSONObject();
		postdata.put("username", username);
		postdata.put("password", passwordMD5);
		postdata.put("to", phone);
		postdata.put("text", text);
		postdata.put("subID", "");
		postdata.put("msgType", 4);
		postdata.put("encode", 1);
		postdata.put("version", "1.0");

		String sr = HttpRequest.sendPost("http://211.147.239.62:9050/cgi-bin/sendsms", postdata);
		return sr;
	}

	public void doGetmomessage() throws Exception {
		/**
		 * HTTP-POST请求参数：获取上行信息 密码必须为MD5密文 pagesize为一次获取最大条数，最大为500
		 */

		String passwordMD5 = Md5Encrypt.md5(password);

		JSONObject postdata = new JSONObject();
		postdata.put("username", username);
		postdata.put("password", passwordMD5);
		postdata.put("pagesize", 20);

		String sr = HttpRequest.sendPost("http://211.147.239.62:18088/cgi-bin/getresponse", postdata);

		System.out.println("result ----->  " + sr);
	}

	public void doGetresponse() throws Exception {
		/**
		 * HTTP-POST请求参数：获取提交报告 密码必须为MD5密文 pagesize为一次获取最大条数，最大为500
		 * 
		 */

		String passwordMD5 = Md5Encrypt.md5(password);

		JSONObject postdata = new JSONObject();
		postdata.put("username", username);
		postdata.put("password", passwordMD5);
		postdata.put("pagesize", 20);

		String sr = HttpRequest.sendPost("http://211.147.239.62:18088/cgi-bin/getresponse", postdata);

		System.out.println("result ----->  " + sr);
	}

	public void doGetreport() throws Exception {
		/**
		 * HTTP-POST请求参数：获取状态报告 密码必须为MD5密文 pagesize为一次获取最大条数，最大为500
		 * 
		 */

		String passwordMD5 = Md5Encrypt.md5(password);

		JSONObject postdata = new JSONObject();
		postdata.put("username", username);
		postdata.put("password", passwordMD5);
		postdata.put("pagesize", 20);

		String sr = HttpRequest.sendPost("http://211.147.239.62:18088/cgi-bin/getresponse", postdata);

		System.out.println("result ----->  " + sr);
	}

	public void doGetacountinfo() throws Exception {
		/**
		 * HTTP-POST请求参数：获取账号信息 密码必须为MD5密文
		 * 
		 */

		String passwordMD5 = Md5Encrypt.md5(password);

		JSONObject postdata = new JSONObject();
		postdata.put("username", username);
		postdata.put("password", passwordMD5);

		String sr = HttpRequest.sendPost("http://211.147.239.62:18088/cgi-bin/getbusinesstype", postdata);

		System.out.println("result ----->  " + sr);
	}

	public void doGetbusinesstype() throws Exception {
		/**
		 * POST请求参数：获取业务类型 密码必须为MD5密文
		 * 
		 */

		String passwordMD5 = Md5Encrypt.md5(password);

		JSONObject postdata = new JSONObject();
		postdata.put("username", username);
		postdata.put("password", passwordMD5);

		String sr = HttpRequest.sendPost("http://211.147.239.62:18088/cgi-bin/getbusinesstype", postdata);
		System.out.println("result ----->  " + sr);
	}

}
