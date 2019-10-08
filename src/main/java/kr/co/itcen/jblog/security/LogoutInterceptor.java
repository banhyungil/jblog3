package kr.co.itcen.jblog.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogoutInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		//인증된 유저인 경우
		//세션 초기화
		if(session != null && session.getAttribute("authUser") != null) {
			session.removeAttribute("authUser");
			session.invalidate();
		}
		
		//인증을 받지 못한 경우
		response.sendRedirect(request.getContextPath() + "/");
		
		return false;
	}
	
}
