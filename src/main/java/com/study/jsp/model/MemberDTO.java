package com.study.jsp.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDTO {

  private String userid;
  private String userpw; 
  private String confirmpw; 
  private String username;
  private String email;
  private Date regdate;
  private Date updatedate; 
  
  public void setConfirmPwd(String userpw) {
    this.userpw = userpw;
  }

  //동일암호 입력확인
  public Boolean comparePwd() {
    return userpw.equals(confirmpw);
  }  
}
