package com.study.jsp.persistence;

import java.util.List;

import com.study.jsp.model.BoardVO;
import com.study.jsp.model.SrchCriteria;

public interface BoardMapper {

  int total();
  
  int totSrch(SrchCriteria s_cri);
  
  int create(BoardVO vo);
  
  //필요한 offset, spp, srchType, keyword 값을 메소드를 통해 전달받는 SrchCriteria 이용
  List<BoardVO> listSrch(SrchCriteria s_cri);
  
  BoardVO read(int bno);
  
  int addcnt(int bno);
  
  int update(BoardVO vo);
  
  int delete(int bno);
  
}
