package com.xcgn.marry.business.utils.wxzf;


import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;

/**
 * 读取证书
 * @author ajaxgo
 *
 */
@SuppressWarnings("deprecation")
public class ReadSSl {
	private static ReadSSl readSSL = null;
	
	private ReadSSl(){
		
	}
	
	public static ReadSSl getInstance(){
		if(readSSL == null){
			readSSL = new ReadSSl();
		}
		return readSSL;
	}
	/**
	 *  读取证书
	 *  WeChatConfig.MCHID 为证书密码
	 * @return
	 * @throws Exception
	 */
	public SSLConnectionSocketFactory readCustomSSL(String path,String mchId) throws Exception{
	    KeyStore keyStore  = KeyStore.getInstance("PKCS12");
        FileInputStream instream = new FileInputStream(new File(path));
        try {
            keyStore.load(instream,mchId.toCharArray());
        } finally {
            instream.close();
        }
        SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, mchId.toCharArray()).build();
        
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory( sslcontext, new String[] { "TLSv1" }, null,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        return sslsf;
	}

}
