package com.lhb.utils;

import org.springframework.stereotype.Component;

/**
 * Created by lhb on 2015/9/26.
 */
@Component("systemConstant")
public class SystemConstant {

    /**
     * 项目的上下文路径
     */
    public static String CTX = null;

    private String serverAddr;
    private String nginxAddr;
    private String appID;
    private String appsecret;

    private String filterUrlApp;
    private String filterUrlServer;

    public String getFilterUrlApp() {
        return filterUrlApp;
    }

    public void setFilterUrlApp(String filterUrlApp) {
        this.filterUrlApp = filterUrlApp;
    }

    public String getFilterUrlServer() {
        return filterUrlServer;
    }

    public void setFilterUrlServer(String filterUrlServer) {
        this.filterUrlServer = filterUrlServer;
    }

    public String getServerAddr() {
        return serverAddr;
    }

    public void setServerAddr(String serverAddr) {
        this.serverAddr = serverAddr;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public String getNginxAddr() {
        return nginxAddr;
    }

    public void setNginxAddr(String nginxAddr) {
        this.nginxAddr = nginxAddr;
    }
}
