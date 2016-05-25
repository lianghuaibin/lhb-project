package com.lhb.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lhb.common.util.LogUtil;
import com.lhb.common.util.MD5;
import com.lhb.domain.pojo.LhbUser;
import com.lhb.domain.query.LhbUserQuery;
import com.lhb.service.LhbUserService;
import com.lhb.utils.AjaxUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author lianghuaibin
 * @since 2016/5/4
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @Resource
    LhbUserService lhbUserService;
    /**
     *
     * @param resp
     * @return ret :0 账号或密码不正确 -1:异常错误 1：正确返回
     */
    @RequestMapping("login.do") @ResponseBody
    public void Login(HttpServletResponse resp,@ModelAttribute LhbUserQuery query){
        LogUtil.paramAndResult("-Login-", JSON.toJSONString(query), "");
        JSONObject json =new JSONObject();
        int ret=-1;
        try{
            query.setPassword(MD5.md5Encrypt(MD5.md5Encrypt(query.getPassword())));
            List<LhbUser> list = lhbUserService.find(query);
            if(list==null || list.size()<=0){
                ret=0;
            }else {
                ret=1;
            }
        }catch (Exception e){
            LogUtil.error(e);
            ret=-1;
        }
        json.put("ret", ret);
        AjaxUtil.writer(resp, json);
    }
    @RequestMapping("test.do")
    public ModelAndView test(HttpServletResponse resp){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/index.jsp");
        return mav;
    }
}
