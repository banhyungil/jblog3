package kr.co.itcen.jblog.security;



import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.itcen.jblog.vo.UserVo;

/**
 * 
 * Blog 관련 Interceptor
 *
 */
public class AuthInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(request.getRequestURI());
		System.out.println(request.getMethod());
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		
		//auth가 없는경우, Blog main으로 가는경우다
		if(auth == null)
			return true;
		
		 
		//auth가있는경우, Admin Page로 가는경우
		HttpSession session = request.getSession();
		if(session == null || session.getAttribute("authUser") == null)
			return false;
		
		UserVo authUser = (UserVo)session.getAttribute("authUser");	
		
		Map<?, ?> pathVariables = (Map<?, ?>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		
		if(!pathVariables.get("userId").equals(authUser.getId())) {
			response.sendRedirect(request.getContextPath() + "/blog/main/" + pathVariables.get("userId"));
			return false;
		}
		
		return true;
	}

}
