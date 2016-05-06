package com.lhb.web.controller;

import com.alibaba.fastjson.JSONObject;
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

    /**
     *
     * @param resp
     * @return ret :0 账号或密码不正确 -1:异常错误 1：正确返回
     */
    @RequestMapping("login.do") @ResponseBody
    public void Login(HttpServletResponse resp){
        JSONObject json =new JSONObject();
        int ret=1;
        try{
            json.put("ret",ret);
        }catch (Exception e){

        }
        LogUtil.paramAndResult("-Login-", "暂无", json.toJSONString());
        AjaxUtil.writer(resp, json);
    }
    @RequestMapping("test.do")
    public ModelAndView test(HttpServletResponse resp){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/index.jsp");
        return mav;
    }
}
