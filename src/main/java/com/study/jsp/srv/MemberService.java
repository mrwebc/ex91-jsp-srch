package com.study.jsp.srv;

import com.study.jsp.model.MemberDTO;
import com.study.jsp.model.MemberVO;

public interface MemberService {
  
  String getTime();
  
  void insertMember(MemberDTO dto);
  
  MemberVO readMember(String userid);
  
  MemberVO readWithPW(String userid, String userpw);
}
