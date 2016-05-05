package com.lhb.utils;


import javax.servlet.*;


/**
 * application filter
 */
public class ApplicationFilter implements Filter {
    
    private String encoding;
    
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain filterChain) {
    	try {
    		servletRequest.setCharacterEncoding(encoding);
    		servletResponse.setContentType("text/html;charset=UTF-8");
    		filterChain.doFilter(servletRequest, servletResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void init(FilterConfig filterConfig) {
        this.encoding = filterConfig.getInitParameter("encoding");
    }
    
	@Override
	public void destroy() {
	}
    
}
