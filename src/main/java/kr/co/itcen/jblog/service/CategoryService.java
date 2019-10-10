package kr.co.itcen.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.itcen.jblog.repository.CategoryDao;
import kr.co.itcen.jblog.vo.CategoryVo;

@Service
public class CategoryService {
	
	@Autowired
	CategoryDao categoryDao;
	
	public void insert(CategoryVo vo) {
		categoryDao.insert(vo);
	}

	public List<CategoryVo> getList(String userId) {
		return categoryDao.getList(userId);
	}
}
