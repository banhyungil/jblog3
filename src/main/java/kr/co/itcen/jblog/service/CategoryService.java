package kr.co.itcen.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.itcen.jblog.repository.CategoryDao;
import kr.co.itcen.jblog.vo.CategoryVo;

@Service
public class CategoryService {
	@Autowired
	CategoryDao categoryDao;
	
	public void insertDefault(String userId) {
		CategoryVo vo = new CategoryVo();
		vo.setUserId(userId);
		vo.setName("기타");
		vo.setDescription("default");
		insert(vo);
	}
	
	public void insert(CategoryVo vo) {
		categoryDao.insert(vo);
	}
}
