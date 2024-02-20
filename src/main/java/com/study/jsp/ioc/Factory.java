package com.study.jsp.ioc;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.modelmapper.ModelMapper;

import com.study.jsp.persistence.BoardMapper;
import com.study.jsp.persistence.BoardMapperDAO;
import com.study.jsp.persistence.MemberMapper;
import com.study.jsp.persistence.MemberMapperDAO;
import com.study.jsp.srv.BoardService;
import com.study.jsp.srv.BoardServiceImpl;
import com.study.jsp.srv.MemberService;
import com.study.jsp.srv.MemberServiceImpl;
import com.study.jsp.util.MapperUtil;

import myBatis.MyBatisManager;

public enum Factory {
  
  //싱글톤
  INSTANCE;
  
  //마이바티즈
  private SqlSessionFactory sqlSessionFactory = MyBatisManager.getSqlSessionFactory();
  private SqlSession sqlSession = sqlSessionFactory.openSession(false);  
  private ModelMapper modelMapper = MapperUtil.INSTANCE.getModelMapper();  
  
  private MemberMapper memberDao = new MemberMapperDAO(sqlSession);  
  private MemberService memberSrv = new MemberServiceImpl(memberDao);
  public MemberService getMemberService() {
    return memberSrv;
  }
  
  private BoardMapper boardDao = new BoardMapperDAO(sqlSession);
  private BoardService boardSrv = new BoardServiceImpl(boardDao, modelMapper);
  public BoardService getBoardService() {
    return boardSrv;
  }


  
}
