package com.study.jsp.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.study.jsp.model.BoardVO;
import com.study.jsp.model.SrchCriteria;

public class BoardMapperDAO implements BoardMapper{
  
  private SqlSession sqlSession;
  
  public BoardMapperDAO(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }
  
  private BoardMapper mp() {
    return sqlSession.getMapper(BoardMapper.class);
  }

  @Override
  public int total() {
    return mp().total();
  }

  @Override
  public int totSrch(SrchCriteria s_cri) {
    return mp().totSrch(s_cri);
  }

  @Override
  public int create(BoardVO vo) {
    int result = 0;
    
    try {
      result = mp().create(vo);
      sqlSession.commit();
    }catch(Exception e) {
      e.printStackTrace();
      sqlSession.rollback();
    }
    
    return result;
  }

  @Override
  public List<BoardVO> listSrch(SrchCriteria s_cri) {
    return mp().listSrch(s_cri);
  }

  @Override
  public BoardVO read(int bno) {
    return mp().read(bno);
  }

  @Override
  public int addcnt(int bno) {
    int result = 0;
    
    try {
      result = mp().addcnt(bno);
      sqlSession.commit();
    }catch(Exception e) {
      e.printStackTrace();
      sqlSession.rollback();
    }
    
    return result;
  }

  @Override
  public int update(BoardVO vo) {

    int result = 0;
    
    try {
      result = mp().update(vo);
      sqlSession.commit();
    }catch(Exception e) {
      e.printStackTrace();
      sqlSession.rollback();
    }
    
    return result;    
  }

  @Override
  public int delete(int bno) {
    
    int result = 0;
    
    try {
      result = mp().delete(bno);
      sqlSession.commit();
    }catch(Exception e) {
      e.printStackTrace();
      sqlSession.rollback();
    }
    
    return result;        
  }

}
