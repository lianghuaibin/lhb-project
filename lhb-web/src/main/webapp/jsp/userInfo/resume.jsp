<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/getContextPath.jsp"%>


<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>主页_${lhb_title}</title>
    <meta name="description" content="${lhb_description}" />
    <meta name="keywords" content="${lhb_keywords}" />

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="${basePath}/logo.ico" rel="shortcut icon" type="image/x-icon" />
    <link rel="stylesheet" href="${basePath}/resources/css/userInfo/resume.css">
    <style type="text/css">
    </style>
</head>
<body style="background: url(${basePath}/resources/img/userInfo/resume_back.jpg) repeat fixed; background-size: cover;"
      data-0="background-position:0px 0px;" data-2000="background-position:0px -50px;">
<div class="header">
    <div class="logo">
        <%--<img style="width: 100px;height: 100px;border-radius: 50%" src="${basePath}/img/userInfo/150x150_head_portrait.jpg">
        <div class="slogan">
            <h2>梁怀宾</h2>
            <p>欢迎光临我的小舍<br/>天行健，君子以自强不息！</p>
        </div>--%>
        <img style="width: 100px;height: 100px;border-radius: 50%" src="${userResume.headPortrait}">
        <div class="slogan">
            <h2>${userResume.username}</h2>
            <p>${userResume.signature}</p></div>
        </div>
    </div>
</div>
<div class="container">

    <div class="box">
        <div class="title">关于我</div>
        <%--<img src="http://r02.abcmoban.com/content/2-about/banner.jpg">--%>
        <img src="${nginx}userInfo/about_me.jpg">
        <p style="text-align: left"><%--${userResume.desc_nature}--%>
                 ● 热爱软件事业，对IT领域的软件开发和设计工作有浓厚的兴趣，能承受较大的工作压力。
            <br/>● 自学能力强，有比较强的动手能力，勇于面对困难和挑战，有很好的分析问题与解决问题的能力。
            <br/>● 工作认真负责，交代的任务，会尽善尽美的完成，积极上进，能够吃苦耐劳，有良好的职业素质。
            <br/>● 在近三年的工作中，都能完成上级交与的任务，并且遇到困难自己都能通过各种途径解决问题！
        </p>
        <p>
            <%--<c:forEach items="${userResume.contact_way}" var="way">
                <a href="#">${way.name}：${way.option}</a>
            </c:forEach>--%>

            <a href="#">微信订阅号：ssln_2015【似水流年】</a><br/>
            <a href="#">E-mail：376288755@qq.com</a><br/>
            <a href="#">Tel：13161177229</a><br/>
            <a href="#">QQ：376288755</a><br/>
            <%--<a href="#">个人站点：开发中~~~</a>--%>
        </p>
    </div>

    <div class="box">
        <div class="title">我的工作经历</div>
        <div class="info-list">
            <div class="info-box">
                <a href="javascript:void(0);" target="_blank">
                    <div class="box-img">
                        <%--<img src="http://r02.abcmoban.com/thumbs/2-db5c0dc0f968c6204e1a0ae7d830700e.jpg"/>--%>
                            <img src="${basePath}/resources/img/userInfo/bird_nest.jpg">
                    </div>
                </a>
                <div class="box-text">
                    <a href="javascript:void(0);" target="_blank"><h4>北京八九点管理咨询有限公司(2014-至今)</h4></a>
                    <p style="color:#000">《班组汇》系列产品开发</p>
                    <p style="text-align: left">
                            ★负责班组汇后台服务端代码及Android接口编写；
                        <br>★负责视频、图片的转码压缩处理；
                        <br>★参与前端html页面编写及微信端功能；
                        <br>★参与项目的需求分析，系统设计方面的工作，并撰写技术文档；
                        <br>★完成项目经理安排的其他工作...</p></div>
            </div>
            <div class="info-box">
                <a href="javascript:void(0);" target="_blank">
                    <div class="box-img">
                        <%--<img src="http://r02.abcmoban.com/thumbs/3-73ef56817d229fc90612952294682309.jpg"/>--%>
                            <img src="${basePath}/resources/img/userInfo/water_cube.jpg">
                    </div>
                </a>
                <div class="box-text">
                    <a href="javascript:void(0);" target="_blank"><h4>龙天运通（北京）发展有限公司(2013-2014)</h4></a>
                    <p style="color:#000">任软件研发及系统部署工程师</p>
                    <p style="text-align: left">      ★参与公司网站《上观网》的开发部署；
                        <br/>★参与公司内部OA系统的设计工作；
                        <br/>★参与《国风网》项目的二次开发，并负责服务器部署上线；
                        <br/>★运维公司以上两个项目的线上正常运行…</p></div>
            </div>
            <div class="info-box">
                <a href="javascript:void(0);" target="_blank">
                    <div class="box-img">
                        <%--<img src="http://r02.abcmoban.com/thumbs/3-73ef56817d229fc90612952294682309.jpg"/>--%>
                            <img src="${basePath}/resources/img/userInfo/exquisite_pagoda.jpg">
                    </div>
                </a>
                <div class="box-text">
                    <a href="javascript:void(0);" target="_blank"><h4>北京信果科技有限公司(2011-2013)</h4></a>
                    <p style="color:#000">任软件工程师职务</p>
                    <p style="text-align: left">
                             ★参与完成《信果打印审计与监控系统》设计、开发、部署工作；
                        <br/>★编写 C++ 接口；
                        <br/>★另独立完成《视频信息加密系统》《手机屏蔽系统》《网络安全管理系统》等项目的开发；
                        <br/>★负责项目后期维护工作…</p></div>
            </div>
        </div>
    </div>

    <%--<div class="box">
        <div class="title">教育经历</div>
        <h4>山东商职学院（大专学历）</h4>
        <p>数控技术</p>
        <h4>北大青鸟</h4>
        <p>java培训</p>
    </div>--%>


    <div class="box">
        <div class="title">我掌握的技能</div>
        <p style="text-align: left"><%--${userResume.desc_skill}--%>
                 ①、熟练SpringMVC、Mybatis、Struts、Hibernate、Jquery等框架体系,并有实际开发经验；
            <br/>②、熟悉GraphicsMagick、im4java等Java图片处理插件，FFmpeg视频转换工具；
            <br/>③、熟悉Oracle、MySQL、Sql Server等主流数据库的应用；
            <br/>④、熟悉主流应用服务器，精通Tomcat、 Nginx；
            <br/>⑤、熟悉Linux环境，熟悉Linux系统的java web环境；
            <br/>⑥、有良好的沟通能力及团队精神，能独立根据项目需求完成项目开发。
        </p>
        <p><span>SpringMVC</span> <span>Tomcat</span> <span>MySQL</span> <span>Linux</span></p>
    </div>

    <%--<div class="box">
        <div class="title">我的作品/案例</div>
        <h4>我的作品1</h4>
        <img src="http://r02.abcmoban.com/content/6-0002/1.jpg">
        <h4>我的作品1</h4>
        <img src="http://r02.abcmoban.com/content/6-0002/2.jpg">
    </div>--%>


</div>
<div class="footer">
    <div class="follow">
        <a href="http://wpa.qq.com/msgrd?v=3&uin=376288755&site=qq&menu=yes" target="_blank">
            <span class="s-qq" title="与我QQ在线聊天"></span></a>
        <a href="http://mp.weixin.qq.com/s?__biz=MzA3MzQzMDc4NA==&mid=400337068&idx=1&sn=4f339c631b6a550bf563834bc7fe1756&scene=0
        &key=d4b25ade3662d64397ceea03ae152f9e1192216e16bfdf2868e292b17dcfaddd3636244223bff70dd80bd7cd66443144&ascen
        e=7&uin=MjI3NzQ3NjM0MA%3D%3D&devicetype=android-19&version=26030733&nettype=WIFI&pass_ticket=I1XP6g8GeQ
        RUnyxatglhMc9WXwQjPY49JgqdJ3cEoIbG%2BLzy9yWEoZQIpcWHeLL2" target="_blank"><span class="s-weixin" title="进入我的微信公众号"></span></a>
    </div>
    <p>© 2009-2015 <a href="http://lhb0802.cn">个人小屋</a> <a href="http://www.miitbeian.gov.cn/">备案号 15061866</a></p>
    <%--<p style="color: #fff">Power by Allvery.com&nbsp;</p>--%>
</div>

<div class="bg"></div>

<script src="${basePath}/resources/jquery/jquery-1.11.1.min.js"></script>
<script src="${basePath}/resources/js/common/skrollr.min.js"></script>
<script type="text/javascript">
    if ($(window).width() > 1023) {
        skrollr.init({
            forceHeight: false
        });
    };
</script>
</body>
</html>