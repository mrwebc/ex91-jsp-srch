package com.study.jsp.srv;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.study.jsp.except.NotExistPostException;
import com.study.jsp.model.BoardDTO;
import com.study.jsp.model.BoardVO;
import com.study.jsp.model.SrchCriteria;
import com.study.jsp.persistence.BoardMapper;

public class BoardServiceImpl implements BoardService{

  private BoardMapper dao;
  private ModelMapper modelMapper;
  public BoardServiceImpl(BoardMapper dao, ModelMapper modelMapper) {
    this.dao = dao;
    this.modelMapper = modelMapper;
  }

  @Override
  public int total() {
    return dao.total();
  }

  @Override
  public int totSrch(SrchCriteria s_cri) {
    return dao.totSrch(s_cri);
  }

  @Override
  public void create(BoardDTO dto) {
    BoardVO vo = modelMapper.map(dto, BoardVO.class);
    int result = dao.create(vo);    
    if(result==1) System.out.println("새로운 게시글 -> 입력완료");
  }

  @Override
  public List<BoardDTO> listSrch(SrchCriteria s_cri) {
    return dao.listSrch(s_cri).stream()
        .map(vo->modelMapper.map(vo, BoardDTO.class))
        .collect(Collectors.toList());
  }

  @Override
  public BoardDTO read(int bno) {
    return modelMapper.map(dao.read(bno), BoardDTO.class);
  }

  @Override
  public void addcnt(int bno) {    
    int result = dao.addcnt(bno);
    
    //존재하지 않는 게시물에 대한 예외처리
    if(result<1) throw new NotExistPostException(bno);      
  }

  @Override
  public void update(BoardDTO dto) {
    BoardVO vo = modelMapper.map(dto, BoardVO.class);
    int result = dao.update(vo);
    if(result==1) System.out.println(dto.getBno()+"번 게시글 -> 수정완료");
  }

  @Override
  public void delete(int bno) {
    int result = dao.delete(bno);
    
    //존재하지 않는 게시물에 대한 예외처리    
    if(result<1) throw new NotExistPostException(bno);     
  }

}
