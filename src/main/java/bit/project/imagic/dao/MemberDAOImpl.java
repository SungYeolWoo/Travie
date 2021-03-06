package bit.project.imagic.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import bit.project.imagic.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public int create(MemberVO member) throws Exception {
		return sqlSession.insert("registerMember", member);
	}

	@Override
	public MemberVO read(String m_id) throws Exception {
		return null;
	}

	@Override
	public MemberVO read(MemberVO member) throws Exception {
		return sqlSession.selectOne("selectMember", member);
	}

	@Override
	public int update(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(MemberVO member) throws Exception {
		return sqlSession.delete("deleteMember", member);
	}

	@Override
	public int deleteByMemberId(String m_id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int regMemCheck(MemberVO member) throws Exception {
		return sqlSession.selectOne("regMemCheck", member);
	}

	


}
