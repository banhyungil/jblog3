package kr.co.itcen.jblog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.itcen.jblog.repository.BlogDao;
import kr.co.itcen.jblog.repository.CategoryDao;
import kr.co.itcen.jblog.repository.PostDao;
import kr.co.itcen.jblog.vo.BlogVo;
import kr.co.itcen.jblog.vo.CategoryVo;
import kr.co.itcen.jblog.vo.PostVo;

@Service
public class BlogService {
	@Autowired
	BlogDao blogDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	PostDao postDao;
	
	public void insert(BlogVo vo) {
		blogDao.insert(vo);
	}
	
	public BlogVo get(String userId) {
		return blogDao.get(userId);
	}
	/**
	 * userId만 넘어온 경우 : category 첫번째 꺼 얻어온 후, 마지막 post
	 */
	public Map getMainInfo(String userId) {
		Long categoryNo = categoryDao.getFirstCategoryNo(userId);
		Map map = getMainInfo(userId, categoryNo);
		
		return map;
	}
	
	/**
	 * categoryNo가 넘어온 경우 : 해당 category 마지막 post
	 */
	public Map getMainInfo(String userId, Long categoryNo) {
		Map map = getMainInfo(userId, categoryNo, null);
		
		return map;
	}
	
	/**
	 * 가변 데이터 : PostVo
	 * postNo가 넘어온 경우 : 해당 Post를 받아온다
	 */
	public Map getMainInfo(String userId, Long categoryNo, Long postNo) {
		BlogVo blogVo = blogDao.get(userId);
		List<CategoryVo> categoryList = categoryDao.getList(userId);
		List<PostVo> postList = postDao.getList(categoryNo); 
	
		PostVo postVo;
		if(postNo == null)
			postVo = postDao.getLast(categoryNo);
		else
			postVo = postDao.get(postNo);
		
		//post가 없는 경우
		//빈데이터를 넣어준다.
		if(postVo == null) {
			postVo = new PostVo();
			postVo.setTitle("제목 없음");
			postVo.setContents("글을 작성하세요");
		}
				
		//map에 삽입
		Map map = new HashMap<String, Object>();
		map.put("blogVo", blogVo);		
		map.put("categoryList", categoryList);		
		map.put("postVo", postVo);		
		map.put("postList", postList);		
		
		return map;
	}

	public void updateBlog(BlogVo blogVo) {
		//만약 로고가 들어왔으면 os에 file삭제하고 변경작업을 한다.
		blogDao.update(blogVo);
	}
	
}
