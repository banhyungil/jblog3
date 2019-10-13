package kr.co.itcen.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.itcen.jblog.vo.CategoryVo;

@Repository
public class CategoryDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public Boolean insert(CategoryVo vo) {
		int count = sqlSession.insert("category.insert", vo);
		return (count == 1);
	}

	public List<CategoryVo> getList(String userId) {
		return sqlSession.selectList("category.getList", userId);
	}
	
	public Long getFirstCategoryNo(String userId) {
		return sqlSession.selectOne("category.getCategoryNo", userId);
	}

	public CategoryVo get(Long no) {
		return sqlSession.selectOne("category.get", no);
	}

	public Boolean delete(Long no) {
		int count = sqlSession.delete("category.delete",no);
		return (count == 1);
	}

	

}
