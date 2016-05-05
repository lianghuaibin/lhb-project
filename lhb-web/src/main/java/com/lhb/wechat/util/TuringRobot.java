package com.lhb.wechat.util;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by lhb on 2015/11/3.
 */
public class TuringRobot {

    //图灵机器人key
    private final static String key = "bd32cd388402f8d7ab2f16be5d661b08";
    /**
     * 发起http get请求获取网页源代码
     *
     * @param requestUrl
     * @return
     *   {"text":"XXXX","code":XXXX}
     */
    public String httpRequest(String requestUrl) {
        StringBuffer buffer = null;

        try {

            if (requestUrl.indexOf("?") != -1) {
                requestUrl = requestUrl + "&key=" + key;
            } else {
                requestUrl = requestUrl + "?key=" + key;
            }

            // 建立连接
            URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod("GET");

            // 获取输入流
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // 读取返回结果
            buffer = new StringBuffer();
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            httpUrlConn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
}