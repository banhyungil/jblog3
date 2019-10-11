package kr.co.itcen.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.itcen.jblog.repository.BlogDao;
import kr.co.itcen.jblog.repository.CategoryDao;
import kr.co.itcen.jblog.repository.UserDao;
import kr.co.itcen.jblog.vo.BlogVo;
import kr.co.itcen.jblog.vo.CategoryVo;
import kr.co.itcen.jblog.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	BlogDao blogDao;
	
	public void JoinMember(UserVo vo) {
		userDao.insert(vo);
		
		BlogVo blogVo = new BlogVo();
		blogVo.setUserId(vo.getId());
		blogVo.setTitle("jblog");
		blogVo.setLogo("default.jpg");
		blogDao.insert(blogVo);	
		
		CategoryVo categoryVo = new CategoryVo();
		categoryVo.setUserId(vo.getId());
		categoryVo.setName("기타");	
		categoryVo.setDescription("default");	
		categoryDao.insert(categoryVo);
	}
	
	public UserVo getSessionUser(UserVo loginVo) {
		return userDao.getSessionUser(loginVo);
	}
}
