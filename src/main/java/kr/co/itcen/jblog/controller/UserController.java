package kr.co.itcen.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.itcen.jblog.service.BlogService;
import kr.co.itcen.jblog.service.UserService;
import kr.co.itcen.jblog.vo.UserVo;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "user/join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVo vo) {
		userService.JoinMember(vo);
		
		return "user/joinsuccess";
	}
	
}
