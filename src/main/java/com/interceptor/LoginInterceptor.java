package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.entity.EmployeeAccountEntity;


public class LoginInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute("account") != null) {
			EmployeeAccountEntity user = (EmployeeAccountEntity) session.getAttribute("account");
			if (user.isRole() == false) {

				response.sendRedirect(request.getContextPath() + "/employee/");
				return false;
			}

			else if (user.isRole() == true) {

				response.sendRedirect(request.getContextPath() + "/admin/");
				return false;
			}
		} 

		return true;
	}
}
