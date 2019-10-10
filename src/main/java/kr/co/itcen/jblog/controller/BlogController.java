package kr.co.itcen.jblog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.itcen.jblog.service.BlogService;
import kr.co.itcen.jblog.service.CategoryService;
import kr.co.itcen.jblog.service.PostService;
import kr.co.itcen.jblog.vo.BlogVo;
import kr.co.itcen.jblog.vo.CategoryVo;
import kr.co.itcen.jblog.vo.PostVo;
import kr.co.itcen.jblog.vo.UserVo;

@RequestMapping("/blog")
@Controller
public class BlogController {
	
	@Autowired
	BlogService blogService;
	
	@Autowired
	PostService postService;
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/main/{userId}")
	public String main(@PathVariable String userId,
			HttpSession session,
			Model model) {
		Boolean isBlogOwner = false;
		
		//1.블로그 입장시 블로그 주인인지 확인
		//1-1.로그인된 유저인지 확인
		if(session != null && session.getAttribute("authUser") != null) {
			UserVo authUser = (UserVo)session.getAttribute("authUser");
			String authUserId = authUser.getId();
			
			//1-2.블로그 주인인지 확인
			if(authUserId.equals(userId)) {
				isBlogOwner = true;
				model.addAttribute("isBlogOwner", isBlogOwner);
			}
		}
		
		BlogVo blogVo = blogService.get(userId);
		List<CategoryVo> categoryList = categoryService.getList(userId);
		//Post Vo를 초기화시킨다
		//1.UserId
		PostVo  postVo = null;
		postVo = postService.getDefaultPost(userId);
		List<PostVo> postList = postService.getList(userId, postVo.getCategoryNo()); 
		
		model.addAttribute("blogVo", blogVo);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("postVo", postVo);
		model.addAttribute("postList", postList);
		return "blog/main";
	}
	
	@RequestMapping("/main/{userId}/{categoryNo}")
	public String main(@PathVariable String userId,
			@PathVariable Long categoryNo,
			Model model) {
		BlogVo blogVo = blogService.get(userId);
		List<CategoryVo> categoryList = categoryService.getList(userId);
		PostVo  postVo = null;
		//2.UserId + CategoryNo
		postVo = postService.getFirstPostOfCategory(userId, categoryNo);
		List<PostVo> postList = postService.getList(userId, categoryNo);
		
		model.addAttribute("blogVo", blogVo);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("postVo", postVo);
		model.addAttribute("postList", postList);
		return "blog/main";
	}
	
	@RequestMapping("/main/{userId}/{categoryNo}/{postNo}")
	public String main(@PathVariable String userId,
			@PathVariable Long categoryNo,
			@PathVariable Long postNo,
			Model model) {
		BlogVo blogVo = blogService.get(userId);
		List<CategoryVo> categoryList = categoryService.getList(userId);
		PostVo  postVo = null;
		//3.UserId + CategoryNo + PostNo
		postVo = postService.get(postNo);
		List<PostVo> postList = postService.getList(userId, categoryNo);
		
		model.addAttribute("blogVo", blogVo);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("postVo", postVo);
		model.addAttribute("postList", postList);
		return "blog/main";
	}
	
	@RequestMapping("/admin-basic")
	public String adminBasic() {
		return "blog/admin-basic";
	}
	
	@RequestMapping("/admin-category")
	public String adminCategory() {
		return "blog/admin-category";
	}
	
	@RequestMapping("/admin-write")
	public String adminWrite() {
		return "blog/admin-write";
	}
}	
