package com.lhb.web.controller;

import com.lhb.common.util.LogUtil;
import com.lhb.utils.AjaxUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * @author lianghuaibin
 * @since 2016/5/4
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @RequestMapping("login.do") @ResponseBody
    public void Login(HttpServletResponse resp){
        try{

        }catch (Exception e){

        }
        LogUtil.paramAndResult("-Login-", "12345", "呵呵");
        AjaxUtil.writer(resp, null);
    }
    @RequestMapping("test.do")
    public ModelAndView test(HttpServletResponse resp){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/index.jsp");
        return mav;
    }
}
