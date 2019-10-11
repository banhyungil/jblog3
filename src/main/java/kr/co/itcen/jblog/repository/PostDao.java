package kr.co.itcen.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.itcen.jblog.vo.PostVo;

@Repository
public class PostDao {

	@Autowired
	SqlSession sqlSession;

	public PostVo get(Long postNo) {
		return sqlSession.selectOne("post.get", postNo);
	}

	public List<PostVo> getList(Long categoryNo) {
		return sqlSession.selectList("post.getList", categoryNo);
	}

	public PostVo getLast(Long categoryNo) {
		return sqlSession.selectOne("post.getLast", categoryNo);
	}

	public Long getCountByCategory(Long categoryNo) {
		return sqlSession.selectOne("post.getCountByCategoryNo", categoryNo);
	}

	public Boolean insert(PostVo vo) {
		int count = sqlSession.insert("post.insert", vo);
		return (count == 1);
	}



}
