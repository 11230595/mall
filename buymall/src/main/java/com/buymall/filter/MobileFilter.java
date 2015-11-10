package com.buymall.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.buymall.constants.Constants;
/**
 * 判断是否是手机登录
 * @author zhoudong
 *
 */
public class MobileFilter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request2 = (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse)response;
		
		String userAgent = request2.getHeader("user-agent");  //请求从哪来的
		if(userAgent.contains("Android") || userAgent.contains("iPhone")){
			httpRes.sendRedirect(Constants.config.getString("MOBILE_URL"));
		}else {
			chain.doFilter(request, response);  
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
