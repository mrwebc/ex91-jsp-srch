package com.study.jsp.persistence;

import org.junit.Test;

import com.study.jsp.ioc.Factory;
import com.study.jsp.model.MemberDTO;
import com.study.jsp.srv.MemberService;

public class MemberMapperDaoTest {

  MemberService memberSrv = Factory.INSTANCE.getMemberService();
  
  @Test
  public void timeTest() {
    System.out.println(memberSrv.getTime());
  }
  
  @Test
  public void insertMemberTest() {
    MemberService memberSrv = Factory.INSTANCE.getMemberService();    
    MemberDTO dto = MemberDTO.builder()
        .userid("hani")
        .userpw("1234")
        .username("하니")
        .email("hani@aaa.com")
        .build();
    memberSrv.insertMember(dto);
  }
  
}
