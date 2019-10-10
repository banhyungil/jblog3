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

	/**
	 * 
	 * 가장 최근의 Post를 불러온다
	 * 
	 */
	public PostVo getByCategoryNo(Long categoryNo) {	
		return sqlSession.selectOne("post.getLastPost", categoryNo);
	}

	public PostVo getByPostNo(Long postNo) {
		return sqlSession.selectOne("post.get", postNo);
	}

	public List<PostVo> getList(Long categoryNo) {
		PostVo vo = new PostVo();
		vo.setUserId(userId);
		vo.setCategoryNo(categoryNo);
		return sqlSession.selectList("post.getList", vo);
	}



}
