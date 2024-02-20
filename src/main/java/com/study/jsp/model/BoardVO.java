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
public class BoardVO {
  private int bno;
  private String title;
  private String content;
  private String writer;
  private Date regdate;
  private int viewcnt;
}
