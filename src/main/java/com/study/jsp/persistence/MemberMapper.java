package com.study.jsp.persistence;

import java.util.Map;

import com.study.jsp.model.MemberVO;

public interface MemberMapper {
  
  String getTime();
  
  void insertMember(MemberVO vo);
  
  MemberVO readMember(String userid);
  
  MemberVO readWithPW(Map<String,String> paramMap);
}
