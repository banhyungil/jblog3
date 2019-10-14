package kr.co.itcen.jblog.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.itcen.jblog.dto.JsonResult;
import kr.co.itcen.jblog.security.Auth;
import kr.co.itcen.jblog.service.CategoryService;
import kr.co.itcen.jblog.vo.CategoryVo;

@RequestMapping("/blog/api/{userId}")
@Controller("blogController2")
public class BlogController {
	@Autowired
	CategoryService categoryService;
	
	@Auth
	@ResponseBody
	@RequestMapping(value="/insertCategory", method=RequestMethod.POST)
	public JsonResult insertCategory(@PathVariable String userId,
			CategoryVo categoryVo){
		
		Long categoryNo = categoryService.insertAndGetKey(categoryVo);
		return JsonResult.success(categoryService.get(categoryNo));
	}
	
	@Auth
	@ResponseBody
	@RequestMapping(value="/deleteCategory", method=RequestMethod.POST)
	public JsonResult deleteCategory(@PathVariable String userId,
			@RequestParam(value="categoryNo", required=true) Long categoryNo){
		
		Boolean result = categoryService.delete(categoryNo);
		return JsonResult.success(result);
	}
}
