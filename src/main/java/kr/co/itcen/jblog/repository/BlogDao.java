package kr.co.itcen.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.itcen.jblog.vo.BlogVo;

@Repository
public class BlogDao {
	@Autowired
	SqlSession sqlSession;
	
	public Boolean insert(BlogVo vo) {
		int count = sqlSession.insert("blog.insert", vo);
		return (count == 1);
	}

	public BlogVo get(String userId) {
		BlogVo vo = sqlSession.selectOne("blog.get", userId);
		
		return vo;
	}
	

}
