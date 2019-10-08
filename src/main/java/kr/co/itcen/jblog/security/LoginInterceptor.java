package kr.co.itcen.jblog.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.itcen.jblog.service.UserService;
import kr.co.itcen.jblog.vo.UserVo;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		UserVo loginVo = new UserVo();
		loginVo.setId(id);
		loginVo.setPassword(password);
		
		UserVo authUser = userService.getSessionUser(loginVo);
		
		//로그인이 실패
		if(authUser == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}
		
		//로그인 성공
		HttpSession session = request.getSession();
		session.setAttribute("authUser", authUser);
		
		response.sendRedirect(request.getContextPath() + "/");
		return false;
	}
	
}
