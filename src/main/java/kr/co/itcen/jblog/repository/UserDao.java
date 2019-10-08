package kr.co.itcen.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.itcen.jblog.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	SqlSession sqlSession;
	public Boolean insert(UserVo vo) {
		int count = sqlSession.insert("user.insert", vo);
		return (count == 1);
	}
	public UserVo getSessionUser(UserVo loginVo) {
		return sqlSession.selectOne("user.getByIdAndPassword", loginVo);
	}
}
