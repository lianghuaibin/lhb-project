<%@ page language="java" pageEncoding="UTF-8"%>
<%

	String ctx = request.getContextPath();
	String basePath;
	// basePath filter post
	if(request.getServerName().contains("lhb0802")){
		basePath = request.getScheme() + "://" + request.getServerName();
	}else{
		basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + ctx;
	}
	if(basePath.endsWith("/")){
		basePath = basePath.substring(0,basePath.length() - 1);
	}
	request.setAttribute("basePath", basePath);
	request.setAttribute("ctx", ctx);


	// HTML SEO SET
	request.setAttribute("lhb_title","梁怀宾de小屋");
	request.setAttribute("lhb_description","在这里大家可以看到，本人的一些信息及技术的积累。当然有很多不成熟之处，希望大家多多指导！");
	request.setAttribute("lhb_keywords","lhb,梁怀宾,0802,liunx,mysql,java,memcached,技术,数据库,服务器,tomcat");
	
%>