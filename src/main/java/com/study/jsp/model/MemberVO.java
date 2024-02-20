package com.study.jsp.model;

import java.io.Serializable;
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
public class MemberVO implements Serializable{

  private static final long serialVersionUID = 1L;

  private String userid;
  private String userpw; 
  private String username;
  private String email;
  private Date regdate;
  private Date updatedate;  
}
