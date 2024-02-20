package com.study.jsp.srv;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;

import com.study.jsp.model.MemberDTO;
import com.study.jsp.model.MemberVO;
import com.study.jsp.persistence.MemberMapper;
import com.study.jsp.util.MapperUtil;

public class MemberServiceImpl implements MemberService{
  
  private ModelMapper modelMapper;
  
  private MemberMapper dao;
  public MemberServiceImpl(MemberMapper dao) {
    this.dao = dao;
    this.modelMapper = MapperUtil.INSTANCE.getModelMapper();
  }

  @Override
  public String getTime() {
    return dao.getTime();
  }

  @Override
  public void insertMember(MemberDTO dto) {
    MemberVO vo = modelMapper.map(dto, MemberVO.class);
    dao.insertMember(vo);
  }

  @Override
  public MemberVO readMember(String userid) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public MemberVO readWithPW(String userid, String userpw) {
    
    Map<String, String> paramMap = new HashMap<String, String>();
    paramMap.put("userid", userid);
    paramMap.put("userpw", userpw);
    
    return dao.readWithPW(paramMap);
  }

}
