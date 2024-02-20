package com.study.jsp.persistence;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.study.jsp.model.MemberVO;

public class MemberMapperDAO implements MemberMapper{
  
  private SqlSession sqlSession;
  
  public MemberMapperDAO(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }
  
  private MemberMapper mp() {
    return sqlSession.getMapper(MemberMapper.class);
  }

  @Override
  public String getTime() {
    return mp().getTime();
  }

  @Override
  public void insertMember(MemberVO vo) {
    mp().insertMember(vo);
  }

  @Override
  public MemberVO readMember(String userid) {
    return mp().readMember(userid);
  }

  @Override
  public MemberVO readWithPW(Map<String, String> paramMap) {
    return mp().readWithPW(paramMap);
  }

}
