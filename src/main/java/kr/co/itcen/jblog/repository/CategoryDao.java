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

}
