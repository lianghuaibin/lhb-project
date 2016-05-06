package com.lhb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by LHB on 2015/10/2.
 */

@Controller
@RequestMapping("bsc")
public class SkipController {

    /**
     * 跳转到欢迎页
     * @return
     */
    @RequestMapping("welcome.do")
    public String getWelcome(HttpServletRequest req,HttpServletResponse resp) {
        try {
            String basePath;
            // basePath filter post
            if(req.getServerName().contains("lhb0802")){
                basePath = req.getScheme() + "://" + req.getServerName();
            }else{
                basePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
            }
            if(basePath.endsWith("/")){
                basePath = basePath.substring(0,basePath.length() - 1);
            }
            //必须重定向 不然css不起作用，原因没找
            resp.sendRedirect(basePath+"/jsp/welcome/welcome.jsp");
//            req.getRequestDispatcher("/jsp/welcome/welcome.jsp").forward(req,resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 跳转到我的简历
     * @return
     */
    @RequestMapping("resume.do")
    public String getResume(HttpServletRequest req,HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("/jsp/userInfo/resume.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return "/jsp/userInfo/resume.jsp";
        return null;
    }
    /**
     * 跳转到我得最爱
     * @return
     */
    @RequestMapping("myLove.do")
    public String getMyLove() {
        return "/jsp/MyLove/myLove.jsp";
    }
    /**
     * 跳转到详细信息
     * @return
     */
    @RequestMapping("homePage.do")
    public String getHomePage() {
        return "/jsp/homePage/myDetail.jsp";
    }


}
