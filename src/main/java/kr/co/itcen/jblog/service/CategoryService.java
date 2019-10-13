package kr.co.itcen.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.itcen.jblog.repository.CategoryDao;
import kr.co.itcen.jblog.repository.PostDao;
import kr.co.itcen.jblog.vo.CategoryVo;

@Service
public class CategoryService {
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	PostDao postDao;
	
	public void insert(CategoryVo vo) {
		categoryDao.insert(vo);
	}

	public List<CategoryVo> getList(String userId) {
		return categoryDao.getList(userId);
	}

	public List<CategoryVo> getListWithPostCount(String userId) {
		List<CategoryVo> list = getList(userId);
		for(CategoryVo vo : list) {
			Long postCount = postDao.getCountByCategory(vo.getNo());
			//Post가 없는 경우
			if(postCount == null)
				postCount = 0L;
			
			vo.setPostCount(postCount);
		}
		
		return list;
	}

	public CategoryVo get(Long no) {
		return categoryDao.get(no);
	}

	public Boolean delete(Long no) {
		return categoryDao.delete(no);
	}
}
