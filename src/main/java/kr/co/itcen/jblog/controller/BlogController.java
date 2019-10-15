package kr.co.itcen.jblog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.itcen.jblog.security.Auth;
import kr.co.itcen.jblog.security.AuthRole;
import kr.co.itcen.jblog.security.AuthUser;
import kr.co.itcen.jblog.service.BlogService;
import kr.co.itcen.jblog.service.CategoryService;
import kr.co.itcen.jblog.service.FileUploadService;
import kr.co.itcen.jblog.service.PostService;
import kr.co.itcen.jblog.vo.BlogVo;
import kr.co.itcen.jblog.vo.CategoryVo;
import kr.co.itcen.jblog.vo.PostVo;
import kr.co.itcen.jblog.vo.UserVo;


@RequestMapping("/blog/{userId}")
@Controller("blogController1")
public class BlogController {
	
	@Autowired
	BlogService blogService;
	
	@Autowired
	PostService postService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	FileUploadService fileUploadService;
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main(@PathVariable String userId,
			@AuthUser UserVo authUser,
			Model model) {
		Map<String, Object> map = blogService.getMainInfo(userId);
		model.addAllAttributes(map);
		return "blog/main";
	}
	
	@RequestMapping(value="/main/{categoryNo}", method=RequestMethod.GET)
	public String main(@PathVariable String userId,
			@PathVariable Long categoryNo,
			Model model) {
		
		Map map = blogService.getMainInfo(userId, categoryNo);
		model.addAllAttributes(map);
		return "blog/main";
	}
	
	@RequestMapping(value="/main/{categoryNo}/{postNo}", method=RequestMethod.GET)
	public String main(@PathVariable String userId,
			@PathVariable Long categoryNo,
			@PathVariable Long postNo,
			Model model) {
		
		Map map = blogService.getMainInfo(userId, categoryNo, postNo);	
		model.addAllAttributes(map);
		return "blog/main";
	}
	
	@Auth(AuthRole.ADMIN)
	@RequestMapping(value="/admin-basic", method=RequestMethod.GET)
	public String adminBasic(@PathVariable String userId,
			Model model) {
		BlogVo blogVo = blogService.get(userId);
		model.addAttribute("blogVo", blogVo);
		return "blog/admin-basic";
	}
	
	@Auth(AuthRole.ADMIN)
	@RequestMapping(value="/admin-category", method=RequestMethod.GET)
	public String adminCategory(@PathVariable String userId,
			Model model) {
		BlogVo blogVo = blogService.get(userId);
		List<CategoryVo> categoryList = categoryService.getListWithPostCount(userId);
		
		model.addAttribute("blogVo", blogVo);
		model.addAttribute("categoryList", categoryList);
		return "blog/admin-category";
	}
	
	@Auth(AuthRole.ADMIN)
	@RequestMapping(value="/admin-write", method=RequestMethod.GET)
	public String adminWrite(@PathVariable String userId,
			Model model) {
		BlogVo blogVo = blogService.get(userId);
		List<CategoryVo> categoryList = categoryService.getList(userId);
		model.addAttribute("blogVo", blogVo);
		model.addAttribute("categoryList", categoryList);
		return "blog/admin-write";
	}
	
	/**
	 * 넘어온 Post데이터를 기반으로 insert를 한다
	 * blog/main으로 돌아갈 때 userId와 CategoryNo를 넘겨준다
	 */
	@Auth(AuthRole.ADMIN)
	@RequestMapping(value="/writePost", method=RequestMethod.POST)
	public String writePost(PostVo postVo,
			@PathVariable String userId) {
		
		postService.insert(postVo);
		return "redirect:/blog/" + userId + "/main/" + postVo.getCategoryNo();
	}
	
	@Auth(AuthRole.ADMIN)
	@RequestMapping(value="/updateBlog", method=RequestMethod.POST)
	public String updateBlog(@PathVariable(value="userId", required=true) String userId,
			@RequestParam(value="multipartFile", required=false) MultipartFile multipartFile,
			BlogVo blogVo) {
		
		String logo = fileUploadService.getUrl(multipartFile);
		blogVo.setUserId(userId);
		blogVo.setLogo(logo);
		blogService.updateBlog(blogVo);
		
		return "redirect:/blog/" + userId + "/main";
	}
}	

