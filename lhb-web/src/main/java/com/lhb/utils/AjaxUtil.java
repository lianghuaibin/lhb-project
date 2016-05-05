package com.lhb.utils;

import com.lhb.common.util.LogUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 输出流
 * @author cs
 *
 */
public class AjaxUtil {

	/**
	 * 输出流
	 * @param response 
	 * @param message 输出内容
	 * @throws java.io.IOException
	 */
	public static void writer(HttpServletResponse response, Object message) {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
			LogUtil.error(e);
		}
		out.print(message != null ? message.toString() : "");
		out.flush();
		out.close();
	}
}
