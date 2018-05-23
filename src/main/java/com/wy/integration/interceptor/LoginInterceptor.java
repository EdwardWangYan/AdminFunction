package com.wy.integration.interceptor;


import com.wy.integration.utils.Constants;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
* 类名称：登录过滤，权限验证
* 类描述： 
 *
 * Created by Edward on 2018/05/23.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		String path = request.getServletPath();//获取url
		if (path.matches(Constants.NO_INTERCEPT_PATH)) {
			System.out.println("path:"+path);
			return true;
		}
		// TODO: 2018/5/23 0023   因为 swagger  所以这里暂时不拦截  先不做用户拦截
		return true;
	}
	
}
