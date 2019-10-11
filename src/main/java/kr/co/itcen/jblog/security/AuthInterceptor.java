package kr.co.itcen.jblog.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		if(session == null) {
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		}
		
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		//Auth가 Class에 붙어있는 경우도 있으므로
		if(auth == null) {
			auth = handler.getClass().getAnnotation(Auth.class);
		}
		
		if(auth == null) {
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		}
		
		//auth가 있는경우
		String userId = request.getParameter("userId");
		
		
		return true;
	}

}
