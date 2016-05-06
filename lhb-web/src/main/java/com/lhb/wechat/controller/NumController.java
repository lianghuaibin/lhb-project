package com.lhb.wechat.controller;

import com.lhb.common.util.LogUtil;
import com.lhb.domain.pojo.LhbUser;
import com.lhb.service.LhbUserService;
import com.lhb.utils.SystemConstant;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lhb on 2015/10/31.
 * 点击数字请求控制Controller
 */
@Controller
@RequestMapping("wc")
public class NumController {

    @Autowired
    private SystemConstant systemConstant;
    @Autowired
    private LhbUserService lhbUserService;

    /**
     * 个人首页
     * @param req
     * @return
     */
    @RequestMapping("getHtml.wc")
    public String getHtml(HttpServletRequest req){
        Map<String,Object> userResume = new HashMap<String, Object>();
        try{
            String nginx = systemConstant.getNginxAddr();
            req.setAttribute("nginx",nginx);
            LhbUser user = lhbUserService.findById(1L);
            user.setHeadPortrait(nginx+user.getHeadPortrait());
            user.setCover(nginx+user.getCover());
            req.setAttribute("userResume", user);
        }catch (Exception e){
            LogUtil.error(e);
        }

        LogUtil.paramAndResult("-getHtml-", "", userResume == null ? "[]":userResume.toString());
        return "/jsp/userInfo/resume.jsp";
    }
}
