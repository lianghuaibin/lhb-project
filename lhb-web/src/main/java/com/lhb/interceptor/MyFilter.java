package com.lhb.interceptor;



import com.lhb.common.util.LogUtil;
import com.lhb.utils.SpringContext;
import com.lhb.utils.SystemConstant;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lhb on 2015/9/26.
 */
public class MyFilter implements Filter {

    private boolean isInit = false;
    private String encoding;
    private SystemConstant systemConstant;
    private String filterUrlApp;
    private String filterUrlServer;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            request.setCharacterEncoding(encoding);
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            if(StringUtils.isEmpty(SystemConstant.CTX)){
                SystemConstant.CTX = req.getContextPath();
            }
            if(!isInit){
                systemConstant = SpringContext.getBean(SystemConstant.class);
                filterUrlApp = systemConstant.getFilterUrlApp();
                filterUrlServer = systemConstant.getFilterUrlServer();
            }
            isInit =true;


            /**
             * get request url....
             * like pattern: http://localhost:8080/Lhb/login/login.bs
             */
            String url = req.getRequestURL().toString();
            String[] urlArr = url.split("/");
            String action = urlArr[urlArr.length - 1];
            String[] actionArr = action.split("\\.");
            action = actionArr[0];
            String suffix = "";
            if(actionArr.length == 2){
                suffix = actionArr[1];
            }
            /*switch (suffix) {
                case "bs":
                    break;
                case "wc":
                    break;
            }*/

//            Filter 只是链式处理，请求依然转发到目的地址。
            chain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.error(e);
        }
    }

    @Override
    public void destroy() {

    }
}
