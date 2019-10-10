package kr.co.itcen.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.itcen.jblog.repository.CategoryDao;
import kr.co.itcen.jblog.repository.PostDao;
import kr.co.itcen.jblog.vo.PostVo;

@Service
public class PostService {
	
	@Autowired
	PostDao postDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	public PostVo getDefaultPost() {
		Long categoryNo = 
		PostVo vo = postDao.get(userId);
		return vo;
	}

	public PostVo getFirstPostOfCategory(Long categoryNo) {
		PostVo vo = postDao.get(categoryNo);
		return vo;
	}

	public PostVo get(Long postNo) {
		PostVo vo = postDao.get(postNo);
		return vo;
	}

	public List<PostVo> getList(String userId, Long categoryNo) {
		return postDao.getList(userId, categoryNo);
	}
	
}
