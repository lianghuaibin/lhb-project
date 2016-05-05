package com.lhb.wechat.util;

import com.lhb.utils.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 字符串工具
 * @author Administrator
 * 
 */
@Component
public class StringDomain {
	

	private static final String OAUTH_LINK_SCHEME = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=";
	private static final String OAUTH_LINK_REDIRECT = "&redirect_uri=";
	private static final String OAUTH_LINK_PARAM = "&response_type=code&scope=snsapi_base&state=";
	private static final String OAUTH_LINK_TAIL = "#wechat_redirect";
	
	@Autowired
	private SystemConstant systemConstant;
	

	/**
	 * 对资源文件添加nginx的IP地址与端口前缀，App端使用
	 * @param urlRelative 资源文件的相对路径
	 * @return 添加IP前缀后的内容
	 */
	public String appendNginxUrl(String urlRelative){
		return (systemConstant.getNginxAddr() + urlRelative);
	}
	
	public String getOauthLink(String action,String param){
		StringBuilder url = new StringBuilder(OAUTH_LINK_SCHEME);
		url.append(systemConstant.getAppID()).append(OAUTH_LINK_REDIRECT).append(systemConstant.getServerAddr())
		.append(SystemConstant.CTX.split("/")[1]).append(action)
		.append(OAUTH_LINK_PARAM).append(param).append(OAUTH_LINK_TAIL);
		return url.toString();
	}

	/**
	 * 拼接服务器请求URL
	 * @param action /../..
	 * @return
	 */
	public String getServiceLink(String action){
		StringBuilder url = new StringBuilder(systemConstant.getServerAddr());
		url.append(SystemConstant.CTX.split("/")[1]).append(action);
		return url.toString();
	}
	
	public String getRSLink(String action){
		//StringBuilder url = new StringBuilder(systemConstant.getRsIP());
		StringBuilder url = new StringBuilder(systemConstant.getServerAddr());
		url.append(SystemConstant.CTX.split("/")[1]).append(action);
		return url.toString();
	}
	
	public static void main(String[] args) {
//		System.out.println("/WC".split("/").clone()[1]);
		StringBuilder str = new StringBuilder("or 89 or");
		System.out.println(str.lastIndexOf("or"));
		str.replace(str.lastIndexOf("or"), str.length(), "");
		System.out.println(str.toString());
		
		String str1 = "如何,怎么,什么,为什么,怎样,是,谁,做,啥,为啥";
		System.out.println("--str1---"+str1.indexOf("什么"));
	}
	
}
