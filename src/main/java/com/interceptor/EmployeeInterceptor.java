package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.entity.EmployeeAccountEntity;

public class EmployeeInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		 HttpSession session = request.getSession();
			if(session.getAttribute("account") == null){
				response.sendRedirect(request.getContextPath() + "/account/login.htm");
				return false;
			}else {	
				EmployeeAccountEntity user = (EmployeeAccountEntity) session.getAttribute("account");
				//false-NV
				if (!(user.isRole() == false)) { //account_ko_la_admin
					response.sendRedirect(request.getContextPath() + "/403.htm");
					return false;
				}
			}
			return true;
	}
}
