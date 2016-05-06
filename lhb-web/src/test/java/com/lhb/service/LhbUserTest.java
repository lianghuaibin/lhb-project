package com.lhb.service;

import com.alibaba.fastjson.JSON;
import com.lhb.BaseTest;
import com.lhb.common.util.LogUtil;
import com.lhb.domain.pojo.LhbUser;
import com.lhb.utils.SystemConstant;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author lianghuaibin
 * @since 2016/5/4
 */
public class LhbUserTest extends BaseTest{

    @Autowired
    private LhbUserService lhbUserService;
    @Autowired
    private SystemConstant systemConstant;

    @Test
    public void testInsert(){
        LhbUser user = new LhbUser();
        user.setAccount("test");
        user.setPassword("1234");
        int num = lhbUserService.insert(user);
        System.out.println(num);
        System.out.println(JSON.toJSONString(user));
    }
    @Test
    public void testUpdate(){
        LhbUser user = new LhbUser();
        user.setId(3);
        user.setAccount("3123124");
//        user.setPassword("456789");
//        user.setCover("123");
        int num = lhbUserService.update(user);
        System.out.println(num);
    }
    @Test
    public void testFindById() throws Exception {
        LhbUser user= lhbUserService.findById(1L);
        System.out.println(JSON.toJSONString(user));
        System.out.println(systemConstant.getServerAddr());
        LogUtil.paramAndResult("123","12312","41312");
    }
    @Test
    public void testFind(){
        List<LhbUser> list = lhbUserService.find(null);
        System.out.println(JSON.toJSONString(list));
    }
    @Test
    public void log(){
        logger.error("123214");
        LogUtil.paramAndResult("1111","2222","3333");
    }
}
