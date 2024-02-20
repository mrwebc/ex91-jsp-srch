package com.study.jsp.except;

public class NotExistPostException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  int bno;
  public NotExistPostException(int bno) {
    this.bno = bno;
  }
  
  @Override
  public String getMessage() {
    return String.format("예외처리 : 존재하지 않는 %d번 게시물에 대한 접근을 시도했습니다.",bno);
  }

  
}
