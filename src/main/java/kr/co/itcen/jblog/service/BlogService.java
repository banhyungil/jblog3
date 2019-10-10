package kr.co.itcen.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.itcen.jblog.repository.BlogDao;
import kr.co.itcen.jblog.vo.BlogVo;

@Service
public class BlogService {
	@Autowired
	BlogDao blogDao;
	
	public void insert(BlogVo vo) {
		blogDao.insert(vo);
	}

	public BlogVo get(String userId) {
		BlogVo vo = blogDao.get(userId);
		return vo;
	}
	
}
