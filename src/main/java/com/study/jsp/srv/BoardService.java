package com.study.jsp.srv;

import java.util.List;

import com.study.jsp.model.BoardDTO;
import com.study.jsp.model.SrchCriteria;

public interface BoardService {
  void create(BoardDTO dto);
  
  int total();
  
  int totSrch(SrchCriteria s_cri);
  
  List<BoardDTO> listSrch(SrchCriteria s_cri);
  
  BoardDTO read(int bno);
  
  void addcnt(int bno);
  
  void update(BoardDTO dto);
  
  void delete(int bno);
  
  
}
