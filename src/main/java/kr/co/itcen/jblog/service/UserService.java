package kr.co.itcen.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.co.itcen.jblog.repository.UserDao;
import kr.co.itcen.jblog.vo.BlogVo;
import kr.co.itcen.jblog.vo.CategoryVo;
import kr.co.itcen.jblog.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public void JoinMember(UserVo vo) {
		CategoryService categoryService = new CategoryService();
		categoryService.insertDefault(vo.getId());
		
		BlogService blogService = new BlogService();
		blogService.insertDefault(vo.getId());

		userDao.insert(vo);
	}
	

	public UserVo getSessionUser(UserVo loginVo) {
		return userDao.getSessionUser(loginVo);
	}
}
