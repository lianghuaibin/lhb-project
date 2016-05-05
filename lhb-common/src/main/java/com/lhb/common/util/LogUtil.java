package com.lhb.common.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * log out util
 * @author Administrator
 * 
 */
public class LogUtil {
	
	private static Log logger = LogFactory.getLog(LogUtil.class);
	private static int logLevel = 4;
	/**
	 * 打印异常日志
	 * @param e - 异常输出
	 */
	public static void error(Throwable e)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("\r\n");
		sb.append("localizedmessage:"+e.getLocalizedMessage());
		sb.append("\r\n");
		sb.append("message:"+e.getMessage());
		sb.append("\r\n");
		sb.append("cause:"+e.getCause());
		sb.append("\r\n");
		sb.append("exceptionclass:");
		sb.append(e.getClass());
		sb.append("\r\n");
		sb.append("stacktrack:");
		for(StackTraceElement tmp: e.getStackTrace())
		{
			sb.append(tmp);
			sb.append("\r\n");
		}
		logger.error(sb);
	}
	
	/**
	 * 日志输出：参数与结果
	 * @param modelName 模块名称
	 * @param param     参数
	 * @param result    结果
	 */
	public static void paramAndResult(String modelName, String param, String result){
		StringBuilder debugInfo = new StringBuilder();
		debugInfo.append("\r\n模块名称:").append(modelName).append("\r\n参数:")
		.append(param).append("\r\n结果:").append(result);

		switch (logLevel) {
		case 1 :
			logger.debug(debugInfo);
			break;
		case 2:
			logger.info(debugInfo);
			break;
		case 3:
			logger.warn(debugInfo);
			break;
		case 4:
			logger.error(debugInfo);
			break;
		default:
			logger.info(debugInfo);

		}
	}

	/**
	 * 自定义输出日志
	 * @param ip
	 * @param desc
	 * @param param
	 * @param result
	 */
	public static void logInfo(String ip, String desc, String param, String result){
		StringBuilder debugInfo = new StringBuilder();
		debugInfo.append(desc).append("-").append(ip).append("\r\n").append(param).append("\r\n")
				.append(result);
		if(logLevel == 0){
			logLevel = 1;
		}
		//DEBUG 1 < INFO 2 < WARN 3 < ERROR 4
		switch (logLevel) {
		case 1 :
			logger.debug(debugInfo);
			break;
		case 2:
			logger.info(debugInfo);
			break;
		case 3:
			logger.warn(debugInfo);
			break;
		case 4:
			logger.error(debugInfo);
		}
	}
	
	/**
	 * 打印异常日志
	 * @param e - 异常
	 * @param ip - 服务器IP
	 */
	public static void logError(Throwable e, String ip)
	{
		StringBuilder sb = new StringBuilder("server-"+ip);
		sb.append("\r\n");
		sb.append("localizedmessage:"+e.getLocalizedMessage());
		sb.append("\r\n");
		sb.append("message:"+e.getMessage());
		sb.append("\r\n");
		sb.append("cause:"+e.getCause());
		sb.append("\r\n");
		sb.append("exceptionclass:");
		sb.append(e.getClass());
		sb.append("\r\n");
		sb.append("stacktrack:");
		for(StackTraceElement tmp: e.getStackTrace())
		{
			sb.append(tmp);
			sb.append("\r\n");
		}
		logger.error(sb);
	}
	
	
}
