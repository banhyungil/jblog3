package kr.co.itcen.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/blog")
@Controller
public class BlogController {
	
	@RequestMapping("/main")
	public String main() {
		return "blog/main";
	}
}
